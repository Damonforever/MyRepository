package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 15:26
 */
public class DamonApplicationContext {
    private Class configClass;
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();//单例池
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();//Bean对应的定义
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();
    public DamonApplicationContext(Class configClass){
        this.configClass = configClass;
        scan(configClass);
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")){
                Object bean = createBean(beanName,beanDefinition);
                singletonObjects.put(beanName,bean);
            }
        }


    }
    public Object createBean(String beanName,BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            //依赖注入，对属性进行赋值
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)){
                    Object bean = getBean(declaredField.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(instance,bean);
                }
            }
            //Aware回调
            if (instance instanceof BeanNameAware){
                ((BeanNameAware)instance).setBeanName(beanName);
            }
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance,beanName);
            }
            //初始化
            if (instance instanceof InitializingBean){
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance,beanName);
            }
            //BeanPostProcessor,方便程序员在初始化前后进行某些操作


            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void scan(Class configClass){
        //解析配置类
        //解析ComponentScan注解--->拿到扫描路径--->扫描--->BeanDefinition--->beanDefinitionMap
        //拿到注解
        ComponentScan componentScanAnnotation = (ComponentScan)configClass.getDeclaredAnnotation(ComponentScan.class);
        //获取属性
        String path = componentScanAnnotation.value();//扫描路径com.damon.service
        path = path.replace(".","/");

        //扫描
        //BootStrap---->jre/lib
        //Ext---------->jre/ext/lib
        //App---------->classpath
        ClassLoader classLoader = DamonApplicationContext.class.getClassLoader();//app
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        //判断是不是目录
        if (file.isDirectory()){
            File[] files = file.listFiles();//拿到所有文件XxUtil和UserService
            for (File f : files) {
                String fileName = f.getAbsolutePath();

                if (fileName.endsWith(".class")){
                    //f的内容如下
                    //F:\JavaWorkSpace\Spring-Damon\target\classes\com\damon\service\UserService.class
                    //F:\JavaWorkSpace\Spring-Damon\target\classes\com\damon\service\XxUtil.class
                    String className = fileName.substring(fileName.indexOf("com"),fileName.indexOf(".class"));
                    //className 变成
                    // com.damon.service.UserService
                    //com.damon.service.XxUtil
                    className = className.replace("\\", ".");


                    try {
                        Class<?> clazz = classLoader.loadClass(className);//加载类，获取到Class对象
                        if (clazz.isAnnotationPresent(Component.class)){//判断当前类下是否有Component注解
                            //有的话，表示这个类是一个bean
                            //解析类---->，判断是单例bean还是原型bean(prototype)
                            //BeanDefinition
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                try {
                                    BeanPostProcessor instance = (BeanPostProcessor)clazz.getDeclaredConstructor().newInstance();
                                    beanPostProcessorList.add(instance);
                                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                    e.printStackTrace();
                                }
                            }
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);

                            if (clazz.isAnnotationPresent(Scope.class)){
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());

                            }else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName,beanDefinition);

                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
    public Object getBean(String beanName){
        if (beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")){
                return singletonObjects.get(beanName);
            }else {
                Object bean = createBean(beanName,beanDefinition);
                return bean;
            }
        }else {
            //不存在对应的bean
            throw new NullPointerException();
        }
    }
}
