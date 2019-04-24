package main.java;

/**
 * 为什么在Java中需要使用泛型Generic Types？
 * 使用Generic Types的目的是：便于在编译器就可以发现bug。
 * 在编译期就能发现bug可以节省Java program的调试时间，这是因为编译期的bugs很容易发现和检查。
 * Generic Types仅仅存在编译期。
 *
 */
public class WhyNeedGenericTypes {
    public static void main(String[] args) {
        Room room = new Room();
        room.add(50);
        Integer integer = (Integer) room.get();
        System.out.println(integer);

        System.out.println("-----------------------");

        Room1<Integer> room1 = new Room1();
        room1.add(45);
        //可以看到不要在将get()方法得到的数据强转成Integer类型，这是因为编译期已经知道会返回Integer类型了。
        Integer integer1 = room1.getT();
    }
}
class Room{
    Object object;

    public void add(Object object){
        this.object = object;
    }
    public Object get(){
        return object;
    }
}

class Room1<T>{
    private T t;

    public void add(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }

}

/**
 * 总结为什么要使用Generic Types：
 * 1. 在编译时有更强大的类型检查；
 * 2. 消除显式转换；
 * 3. 实现代码的可重用性，例如泛型算法的实现。
 * Java Generic Types仅仅是一个编译时概念。当运行时，所有的类型信息都被擦除了，这也称为类型擦除。
 */
