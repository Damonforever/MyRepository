package xiaolin;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> append;
    Stack<Integer> delete;
    //初始化
     public MyQueue(){
         append = new Stack<>();
         delete = new Stack<>();
     }
     //入队
    void push(int x){
         append.push(x);
    }
    //出队
    int pop(){
         //delete为空，才会将append的数据全部导进来
        if(delete.isEmpty()){
            while(!append.isEmpty()){
                delete.push(append.peek());
                append.pop();
            }
        }
        int result = delete.peek();
        delete.pop();
        return result;
    }
    //获取头元素
    int peek(){
         int res = this.pop();
         delete.push(res);
         return res;
    }
    //判空
    boolean empty(){
         return append.isEmpty() && delete.isEmpty();
    }
}
