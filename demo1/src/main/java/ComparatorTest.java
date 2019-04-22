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

        Collections.sort(list,new MyComparator());//通过自建的比较器将list排序
        for (Computer computer : list){
            System.out.println(computer.getBrand());
        }
    }
}
/***
 * 在某些情形下，不想要改变类使其实现Comparable接口。这时候Comparator接口可以用来通过某些字段或者属性来比较。
 * 需要实现的方法是compara()
 * Collections和Arrays类提供了使用一个comparator来比较的sort()方法。
 *
 * 什么时候使用Comparable？什么时候使用Comparator呢？
 * 简而言之。实现Comparable接口的类是可比较的，意味着他可以相互比较实例。
 * 一个实现Compator接口的类可用在两种情形下：1）它可以传递给sort()方法，如Collections.srot()以及
 * Arrays.sort(),用来精确控制顺序。2）可以用来控制一些数据结构的顺序，如有序的Set（TreeSet）和有序Map(TreeMap)
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

