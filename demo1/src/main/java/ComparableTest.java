package main.java;

public class ComparableTest {
    /**
     * Comparable �� Comparator��Java Core API�е������ӿڣ������ֿ��Կ������ǵ�����ʱ��ĳ�ַ�ʽ�Ƚ϶�����
     * �����������ӿ�֮����ʲô�������ͨ������������˵����
     * 1. Comparable����ʵ�֣��Ա㽫�������������������бȽϡ��౾�����ʵ����ӿڲ��ܱȽ���ʵ����
     * Ҫ����д�ķ���ΪcompareTo()
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

//comparable���÷�
class Notebook implements Comparable<Notebook>{
    private int size;
    private String brand;
    public Notebook(int size,String brand){
        this.size = size;
        this.brand = brand;
    }

    //����Ϊ�ֶε�getter��setter����
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

    //��дComparable�ķ���
    public int compareTo(Notebook o) {
        if (this.getSize() > o.getSize())
            return 1;
        else if (this.getSize() < o.getSize())
            return -1;
        return 0;
    }
}

