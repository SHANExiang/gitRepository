package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����ܾ�����Ҫһ�����������һ�����ݿ�����ı��е�words���ִ�����
 * ����������ͨ��HashMap�����׵�ʵ�֡�
 */
public class CounterImplements {
    public static void main(String[] args) {
        String str = "one two three three three two two one";
        String[] strArray = str.split(" ");

        long beginTime1 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter1(strArray);
        }
        long endTime1 = System.nanoTime();
        System.out.println("counter1��ʱ�� " + (endTime1 - beginTime1));

        System.out.println("--------------------------------");

        long beginTime2 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter2(strArray);
        }
        long endTime2 = System.nanoTime();
        System.out.println("counter2��ʱ�� " + (endTime2 - beginTime2));

        System.out.println("-----------------------------------");

        long beginTime3 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter3(strArray);
        }
        long endTime3 = System.nanoTime();
        System.out.println("counter3��ʱ�� " + (endTime3 - beginTime3));

        System.out.println("-----------------------------------");

        long beginTime21 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter21(strArray);
        }
        long endTime21 = System.nanoTime();
        System.out.println("counter3��ʱ�� " + (endTime21 - beginTime21));

        System.out.println("-----------------------------------");

        long beginTime22 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter22(strArray);
        }
        long endTime22 = System.nanoTime();
        System.out.println("counter3��ʱ�� " + (endTime22 - beginTime22));

        System.out.println("-----------------------------------");

        long beginTime23 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter23(strArray);
        }
        long endTime23 = System.nanoTime();
        System.out.println("counter3��ʱ�� " + (endTime23 - beginTime23));

    }

    /*
    ÿ��ѭ���У����жϼ��Ƿ���ڣ��������ȡ��ֵ��1����������ڣ�ֱ�ӽ�ֵ��Ϊ1��put��ȥ��
    ��������ʱ��containsKey()��get()���������Σ������ζ��map�����������Σ�
    ����Integer���ǲ��ɱ��࣬ÿһ��ѭ�����ᴴ��һ���µ�ֵ���滻�ɵ�ֵ��
    �⵼���˴˷�����Ч�ġ�
     */
    private static Map<String,Integer> counter1(String[] strArray){
        HashMap<String, Integer> counter1 = new HashMap<String, Integer>();
        for (String string : strArray){
            if (counter1.containsKey(string)){
                int value = counter1.get(string);
                counter1.put(string, value + 1);
            }
            else{
                counter1.put(string, 1);
            }
        }
        return counter1;
    }

    /*
    counter2()����ʹ�ÿɱ���MutableInteger�����ⴴ�������࣬���ǵ�������ʱ��ÿ��ѭ���������������Ρ�
     */
    private static Map<String,MutableInteger> counter2(String[] strArray){
        HashMap<String, MutableInteger> counter2 = new HashMap<String, MutableInteger>();
        for (String string:strArray){
            if (counter2.containsKey(string)){
                MutableInteger oldNumber = counter2.get(string);
                oldNumber.setNumber(oldNumber.getNumber() + 1);
                counter2.put(string, oldNumber);
            }
            else{
                counter2.put(string, new MutableInteger(1));
            }
        }
        return counter2;
    }

    /**
     * counter3()������
     * ����HashMap.put(K,V)�������ص�ǰ������Ӧ��ֵ��������������֮һ���ԣ�����ͨ����ֵ������������ֵ
     * û������map���
     */
    private static Map<String,MutableInteger> counter3(String[] strArray){
        Map<String, MutableInteger> counter3 = new HashMap<String, MutableInteger>();
        for (String string:strArray){
            MutableInteger initValue = new MutableInteger(1);
            MutableInteger oldValue = counter3.put(string, initValue);
            if (oldValue != null){
                oldValue.setNumber(oldValue.getNumber() + 1);
                counter3.put(string, oldValue);
            }
        }
        return counter3;
    }


/**
 * �Եڶ��ַ���counter2()���иĽ�������
 *
 */
/*
1. û��containsKey()��������������HashMap.get()������
ͨ������Ҫ��Ԫ����HashMap�У������������������ٵ�һ�Ρ�
 */
    private static Map<String,MutableInteger> counter21(String[] strArray){
        Map<String, MutableInteger> counter21 = new HashMap<String, MutableInteger>();
        for (String string:strArray){
            MutableInteger oldValue = counter21.get(string);
            if (oldValue != null){
                oldValue.setNumber(oldValue.getNumber() + 1);
                counter21.put(string, oldValue);
            }
            counter21.put(string, new MutableInteger(1));
        }
        return counter21;
    }
    /*
    2. ʹ��AtomicInteger��
     */
    private static Map<String, AtomicInteger> counter22(String[] strArray){
        Map<String, AtomicInteger> counter22 = new HashMap<String, AtomicInteger>();
        for (String string:strArray){
            AtomicInteger oldValue = counter22.get(string);
            if (oldValue != null){
                oldValue.incrementAndGet();
                counter22.put(string, oldValue);
            }
            counter22.put(string, new AtomicInteger(1));
        }
        return counter22;
    }

    /*
    3. ʹ��int[]����
     */
    private static Map<String,int[]> counter23(String[] strArray){
        Map<String, int[]> counter23 = new HashMap<String, int[]>();
        for (String string:strArray){
            int[] valueWrapper = counter23.get(string);
            if (valueWrapper == null){
                counter23.put(string, new int[]{1});
            }
            else{
                valueWrapper[0]++;
                counter23.put(string, valueWrapper);
            }
        }
        return counter23;
    }

}


class MutableInteger {
    private int number;

    public MutableInteger(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}

