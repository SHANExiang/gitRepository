package main.java;

/**
 * Ϊʲô��Java����Ҫʹ�÷���Generic Types��
 * ʹ��Generic Types��Ŀ���ǣ������ڱ������Ϳ��Է���bug��
 * �ڱ����ھ��ܷ���bug���Խ�ʡJava program�ĵ���ʱ�䣬������Ϊ�����ڵ�bugs�����׷��ֺͼ�顣
 * Generic Types�������ڱ����ڡ�
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
        //���Կ�����Ҫ�ڽ�get()�����õ�������ǿת��Integer���ͣ�������Ϊ�������Ѿ�֪���᷵��Integer�����ˡ�
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
 * �ܽ�ΪʲôҪʹ��Generic Types��
 * 1. �ڱ���ʱ�и�ǿ������ͼ�飻
 * 2. ������ʽת����
 * 3. ʵ�ִ���Ŀ������ԣ����緺���㷨��ʵ�֡�
 * Java Generic Types������һ������ʱ���������ʱ�����е�������Ϣ���������ˣ���Ҳ��Ϊ���Ͳ�����
 */
