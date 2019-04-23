package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 你可能经常需要一个计数器获得一个数据库或者文本中的words出现次数，
 * 计数器可以通过HashMap很容易地实现。
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
        System.out.println("counter1用时： " + (endTime1 - beginTime1));

        System.out.println("--------------------------------");

        long beginTime2 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter2(strArray);
        }
        long endTime2 = System.nanoTime();
        System.out.println("counter2用时： " + (endTime2 - beginTime2));

        System.out.println("-----------------------------------");

        long beginTime3 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter3(strArray);
        }
        long endTime3 = System.nanoTime();
        System.out.println("counter3用时： " + (endTime3 - beginTime3));

        System.out.println("-----------------------------------");

        long beginTime21 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter21(strArray);
        }
        long endTime21 = System.nanoTime();
        System.out.println("counter3用时： " + (endTime21 - beginTime21));

        System.out.println("-----------------------------------");

        long beginTime22 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter22(strArray);
        }
        long endTime22 = System.nanoTime();
        System.out.println("counter3用时： " + (endTime22 - beginTime22));

        System.out.println("-----------------------------------");

        long beginTime23 = System.nanoTime();
        for (int i =0;i < 1000000;i++){
            counter23(strArray);
        }
        long endTime23 = System.nanoTime();
        System.out.println("counter3用时： " + (endTime23 - beginTime23));

    }

    /*
    每次循环中，先判断键是否存在，如果存在取出值加1，如果不存在，直接将值设为1，put进去。
    当键存在时，containsKey()和get()被调用两次，这就意味着map被搜索了两次；
    由于Integer类是不可变类，每一次循环都会创建一个新的值来替换旧的值。
    这导致了此方法低效的。
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
    counter2()方法使用可变类MutableInteger来避免创建更多类，但是当键存在时，每次循环还是搜索了两次。
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
     * counter3()方法。
     * 由于HashMap.put(K,V)方法返回当前键所对应的值，所以我们利用之一特性，可以通过旧值的引用来更新值
     * 没有搜索map多次
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
 * 对第二种方法counter2()进行改进。如下
 *
 */
/*
1. 没有containsKey()方法；仅仅调用HashMap.get()方法，
通常，想要的元素在HashMap中，这样从两次搜索减少到一次。
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
    2. 使用AtomicInteger类
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
    3. 使用int[]数组
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

