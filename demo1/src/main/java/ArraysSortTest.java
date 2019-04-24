package main.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 深度理解Arrays.sort(),此方法一般用来排序用户定于的对象数组。Java DOC文档简要地说明下此方法的用途，
 * 但没有深入解释，下面我们通过关键信息理解此方法的用法。
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
        一个比较器被定义来通过Dog的尺寸比较Dog,之后将比较器对象作为一个Arrays.sort()中的一个参数。
        在这个例子中，当传入不同的比较器可能得到不同算法结果。
         */
        Arrays.sort(dogArray, new SizeComparator());
        for (Dog dog : dogArray) {
            System.out.print("size=" + dog.size + " weight=" + dog.weight + " ");
        }
        System.out.println();

        System.out.println("---------------------------------");
        /*
        现在，传入另一个比较器，以Dog的重量来对Dog进行比较
         */
        Arrays.sort(dogArray, new WeightCompatator());
        for (Dog dog : dogArray) {
            System.out.print("size=" + dog.size + " weight=" + dog.weight + " ");
        }
        /*
        Comparator比较器是一个接口，任何一个实现此接口的比较器可以在运行时使用，这是策略模式的关键点。
         */

        /**
         * 对于方法Arrays.sort(T[],Comparator<? super T> c)，如果Comparator<T> c是其参数就很简单，
         * 但是方法中第二个参数是Comparator<? super T> c 表示类型可以是T或者它的父类。
         * 也就是说，这个方法可以允许同样的比较器用在所有的父类中，
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
//以Dog的尺寸来创建比较器
class SizeComparator implements Comparator<Dog>{
    public int compare(Dog o1, Dog o2) {
        return o1.size - o2.size;
    }
}

//以Dog的重量weight来创建比较器
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
