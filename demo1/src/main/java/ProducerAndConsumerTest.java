package main.java;

import java.util.Vector;

public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        new Consumer(producer).start();
    }
}
class Producer extends Thread{
    static final int MAXQUEUE = 5;
    Vector message = new Vector();

    @Override
    public void run() {
        while (true) {
            try {
                putMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void putMessage() throws InterruptedException{
        while(message.size() == MAXQUEUE){
            wait();
        }
        message.addElement(new java.util.Date().toString());
        System.out.println("putMessage");
        notify();
    }

    public synchronized String getMessage() throws InterruptedException{
        notify();
        while(message.size() == 0){
            wait();
        }
        String element = (String) message.firstElement();
        message.remove(element);
        return element;
    }
}
class Consumer extends Thread{
    Producer producer;
    Consumer (Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String element = (String)producer.getMessage();
                System.out.println("getMessage: " + element);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
