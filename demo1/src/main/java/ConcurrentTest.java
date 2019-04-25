package main.java;

public class ConcurrentTest {
    public static void main(String[] args) {
        AdditionThread additionThread = new AdditionThread();
        MultiplicationThread multiplicationThread = new MultiplicationThread();

        additionThread.start();
        multiplicationThread.start();

        //join()是将主线程等待子线程完成后才能继续运行。
        try {
            additionThread.join();
            multiplicationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double result = (double) (additionThread.value/multiplicationThread.value);
        System.out.println(result);

        System.out.println("------------------------------");
        /**
         * 1. synochronized关键字是用来互斥访问的；
         * 2. 为了使一个方法时同步的，只需要在方法声明中添加synchronized关键字；
         * 对一个对象的两个同步方法的调用不能交错进行。
         * 3. 同步语句必须执行提供内部锁定的对象；
         * 当synochronized(this)被使用时，应当避免同步其他对象方法的调用；
         * 4.wait()告诉调用者放弃monitor，并且去睡眠等待其他线程进入monitor调用notify()
         * 5. notify()唤醒在同一对象上调用wait()的第一个线程。
         */
        ThreadA threadA = new ThreadA();
        threadA.start();

        //threadA被同步，Main线程必须等待ThreadA的run()方法完成后才能输出最终的值。
        synchronized (threadA){
            System.out.println("waiting for threadA to complete...");
            try {
                threadA.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("totalValue=" + threadA.totalValue);
        }

        System.out.println("------------------------------");


    }
}
class AdditionThread extends Thread{
    int value;

    @Override
    public void run() {
        value = (1 + 1);
    }
}
class MultiplicationThread extends Thread{
    int value;

    @Override
    public void run() {
        value = 1 * 2;
    }
}

class ThreadA extends Thread{
    int totalValue;

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0;i < 100;i++) {
                totalValue += i;
            }
        }
    }
}
