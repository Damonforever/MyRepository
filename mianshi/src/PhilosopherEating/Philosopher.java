package PhilosopherEating;

/**
 * @description: 哲学家就餐，方案一：左右两只筷子都拿的到才能拿
 * @author: Damon
 * @date: 2021/8/8 22:04
 */
class Philosopher extends Thread {
    private String name;
    private Fork fork;
    public Philosopher(String name,Fork fork){
        super(name);
        this.name = name;
        this.fork = fork;
    }

    @Override
    public void run() {
        while (true){
            Thinking();
            fork.takeFork();
            Eating();
            fork.putFork();
        }
    }

    public void Eating(){
        System.out.println("I am Eating: " + name);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Thinking(){
        System.out.println("I am Thinking: " + name);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Fork{
    //5只叉子初始时都未被使用
    private boolean[] used = new boolean[]{false,false,false,false,false};
    /*只有当左右手的筷子都未被使用时，才允许获取筷子，且必须同时获取左右手筷子*/
    public synchronized void  takeFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        while (used[i] || used[(i+1)%5]){
            try {
                wait();//如果左右手有一个被用了，就要等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        used[i ]= true;
        used[(i+1)%5]=true;
    }
    //叉子同时释放
    public synchronized void putFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        used[i ]= false;
        used[(i+1)%5]=false;
        notifyAll();//唤醒所有人
    }
}
class Test{
    public static void main(String[] args) {
        Fork fork = new Fork();
        new Philosopher("0",fork).start();
        new Philosopher("1",fork).start();
        new Philosopher("2",fork).start();
        new Philosopher("3",fork).start();
        new Philosopher("4",fork).start();
    }
}
