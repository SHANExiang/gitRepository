package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Computer computer1 = new Computer(21, "MPB");
        Computer computer2 = new Computer(55, "MI");
        Computer computer3 = new Computer(60, "HUAWEI");
        List<Computer> list = new ArrayList<Computer>();
        list.add(computer1);
        list.add(computer2);
        list.add(computer3);

        Collections.sort(list,new MyComparator());//ͨ���Խ��ıȽ�����list����
        for (Computer computer : list){
            System.out.println(computer.getBrand());
        }
    }
}
/***
 * ��ĳЩ�����£�����Ҫ�ı���ʹ��ʵ��Comparable�ӿڡ���ʱ��Comparator�ӿڿ�������ͨ��ĳЩ�ֶλ����������Ƚϡ�
 * ��Ҫʵ�ֵķ�����compara()
 * Collections��Arrays���ṩ��ʹ��һ��comparator���Ƚϵ�sort()������
 *
 * ʲôʱ��ʹ��Comparable��ʲôʱ��ʹ��Comparator�أ�
 * �����֮��ʵ��Comparable�ӿڵ����ǿɱȽϵģ���ζ���������໥�Ƚ�ʵ����
 * һ��ʵ��Compator�ӿڵ�����������������£�1�������Դ��ݸ�sort()��������Collections.srot()�Լ�
 * Arrays.sort(),������ȷ����˳��2��������������һЩ���ݽṹ��˳���������Set��TreeSet��������Map(TreeMap)
 */


class Computer {
    private int size;
    private String brand;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Computer(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }
}
class MyComparator implements Comparator<Computer>{
    public int compare(Computer o1, Computer o2) {
        if (o1.getSize() > o2.getSize()){
            return 1;
        }
        else if (o1.getSize() < o2.getSize()){
            return -1;
        }
        return 0;
    }
}

