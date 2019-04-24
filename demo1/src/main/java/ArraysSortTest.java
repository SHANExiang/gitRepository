package main.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ������Arrays.sort(),�˷���һ�����������û����ڵĶ������顣Java DOC�ĵ���Ҫ��˵���´˷�������;��
 * ��û��������ͣ���������ͨ���ؼ���Ϣ���˷������÷���
 */
public class ArraysSortTest {
    public static void main(String[] args) {
        Dog dog1 = new Dog(9, 24);
        Dog dog2 = new Dog(4, 12);
        Dog dog3 = new Dog(7, 90);

        Dog[] dogArray = new Dog[]{dog1, dog2, dog3};
        for (Dog dog : dogArray) {
            System.out.print("size=" + dog.size + " weight=" + dog.weight + " ");
        }

        System.out.println();
        System.out.println("--------------------------------");

        /*
        һ���Ƚ�����������ͨ��Dog�ĳߴ�Ƚ�Dog,֮�󽫱Ƚ���������Ϊһ��Arrays.sort()�е�һ��������
        ����������У������벻ͬ�ıȽ������ܵõ���ͬ�㷨�����
         */
        Arrays.sort(dogArray, new SizeComparator());
        for (Dog dog : dogArray) {
            System.out.print("size=" + dog.size + " weight=" + dog.weight + " ");
        }
        System.out.println();

        System.out.println("---------------------------------");
        /*
        ���ڣ�������һ���Ƚ�������Dog����������Dog���бȽ�
         */
        Arrays.sort(dogArray, new WeightCompatator());
        for (Dog dog : dogArray) {
            System.out.print("size=" + dog.size + " weight=" + dog.weight + " ");
        }
        /*
        Comparator�Ƚ�����һ���ӿڣ��κ�һ��ʵ�ִ˽ӿڵıȽ�������������ʱʹ�ã����ǲ���ģʽ�Ĺؼ��㡣
         */

        /**
         * ���ڷ���Arrays.sort(T[],Comparator<? super T> c)�����Comparator<T> c��������ͺܼ򵥣�
         * ���Ƿ����еڶ���������Comparator<? super T> c ��ʾ���Ϳ�����T�������ĸ��ࡣ
         * Ҳ����˵�����������������ͬ���ıȽ����������еĸ����У�
         */

        System.out.println();
        System.out.println("-------------------------");
        Cat cat1 = new Cat(23);
        Cat cat2 = new Cat(89);
        Cat cat3 = new Cat(2);
        Cat[] cats = new Cat[]{cat1,cat2,cat3};
        for (Cat cat:cats){
            System.out.print("size=" + cat.size + " ");
        }
        System.out.println();
        System.out.println("--------------------------");
        Comparator<Animal> animalSizeComparator = new AnimalSizeComparator();
        Arrays.sort(cats,animalSizeComparator);
        for (Cat cat:cats){
            System.out.print("size=" + cat.size + " ");
        }

    }

}
class Dog{
    int size;
    int weight;

    public Dog(int size, int weight) {
        this.size = size;
        this.weight = weight;
    }

}
//��Dog�ĳߴ��������Ƚ���
class SizeComparator implements Comparator<Dog>{
    public int compare(Dog o1, Dog o2) {
        return o1.size - o2.size;
    }
}

//��Dog������weight�������Ƚ���
class WeightCompatator implements Comparator<Dog>{
    public int compare(Dog o1, Dog o2) {
        return o1.weight - o2.weight;
    }
}

class AnimalSizeComparator implements Comparator<Animal>{
    public int compare(Animal o1, Animal o2) {
        return o1.size - o2.size;
    }
}
class Animal{
    int size;
}
class Cat extends Animal{
    public Cat(int s) {
        size = s;
    }
}

class Pig extends Animal{
    public Pig(int s) {
        size = s;
    }
}
