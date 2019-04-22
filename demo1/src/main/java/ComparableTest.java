package main.java;

public class ComparableTest {
    /**
     * Comparable 和 Comparator是Java Core API中的两个接口，从名字可以看出他们的作用时以某种方式比较东西。
     * 但是这两个接口之间有什么差别，我们通过以下例子来说明。
     * 1. Comparable由类实现，以便将自身对象与其他对象进行比较。类本身必须实现其接口才能比较其实例。
     * 要求重写的方法为compareTo()
     */
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook(13, "HUAWEI");
        Notebook notebook2 = new Notebook(15, "Thinkpad");
        if (notebook1.compareTo(notebook2) > 0){
            System.out.println(notebook1.getBrand() + " is better");
        }
        else {
            System.out.println(notebook2.getBrand() + " is better");
        }


    }
}

//comparable的用法
class Notebook implements Comparable<Notebook>{
    private int size;
    private String brand;
    public Notebook(int size,String brand){
        this.size = size;
        this.brand = brand;
    }

    //以下为字段的getter和setter方法
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

    //重写Comparable的方法
    public int compareTo(Notebook o) {
        if (this.getSize() > o.getSize())
            return 1;
        else if (this.getSize() < o.getSize())
            return -1;
        return 0;
    }
}

