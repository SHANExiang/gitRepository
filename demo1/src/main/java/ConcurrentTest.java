package main.java;

public class ConcurrentTest {
    public static void main(String[] args) {
        AdditionThread additionThread = new AdditionThread();
        MultiplicationThread multiplicationThread = new MultiplicationThread();

        additionThread.start();
        multiplicationThread.start();

        //join()�ǽ����̵߳ȴ����߳���ɺ���ܼ������С�
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
         * 1. synochronized�ؼ���������������ʵģ�
         * 2. Ϊ��ʹһ������ʱͬ���ģ�ֻ��Ҫ�ڷ������������synchronized�ؼ��֣�
         * ��һ�����������ͬ�������ĵ��ò��ܽ�����С�
         * 3. ͬ��������ִ���ṩ�ڲ������Ķ���
         * ��synochronized(this)��ʹ��ʱ��Ӧ������ͬ���������󷽷��ĵ��ã�
         * 4.wait()���ߵ����߷���monitor������ȥ˯�ߵȴ������߳̽���monitor����notify()
         * 5. notify()������ͬһ�����ϵ���wait()�ĵ�һ���̡߳�
         */
        ThreadA threadA = new ThreadA();
        threadA.start();

        //threadA��ͬ����Main�̱߳���ȴ�ThreadA��run()������ɺ����������յ�ֵ��
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
