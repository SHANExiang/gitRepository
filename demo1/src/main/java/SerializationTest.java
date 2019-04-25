package main.java;

import java.io.*;

/**
 * Java�У��������л���ָ���ַ����б�ʾһ����������ֽڰ����������ݺ���Ϣ��
 * ���л��������д�뵽�ļ��������ݿ��У����Ҵ��ļ������ݿ��ж�ȡ�������л���
 * ��ʾ��������ݵ��ֽڿ����������ڴ����½�����
 *
 * Ϊʲô������Ҫ���л�����
 * ����Ҫ�����󴫵������л��ߴ洢���ļ��У���ʱ����Ҫ���л��ˡ������豸�ʹ洢Ӳ��ֻ�����λ���ֽڣ�
 * ���������������л�������ת�����ֽڲ�ͨ�����緢�Ͳ����档
 * Ϊʲô������Ҫ�����󴢴���ߴ��ݣ�
 * 1. ���󴴽�ȡ���ںܶ������ģ�һ���������������������Ҫ���ķ��������ֶΣ�
 * 2. �����󴴽������ǲ�ȷ��ʹ���ĸ��ֶΣ���˽���洢�����ݿ��Ա��Ժ�����ݷ�����
 */
public class SerializationTest {
    public static void main(String[] args){
        Bird bird = new Bird();
        bird.setName("shane");
        bird.setColor("read");
        bird.setWeight(2.3);

        //���л�����
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("c:/bird.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bird);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("���л�Bird��д�����ļ�/bird.ser�С�");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ȥ���л�
        bird = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("c:/bird.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bird = (Bird)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("bird�������ǣ� " + bird.getName());
        System.out.println("bird����ɫ�ǣ� " + bird.getColor());
        System.out.println("bird�������ǣ� " + bird.getWeight());

        bird.introduce();
    }
}
class Bird implements Serializable{
    private static final long serialVersionUID =  -5742822984616863149L;
    private String name;
    private String color;
    private transient double weight;//��ʾ���л����̲�����ֶ�weight����

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

   public void introduce(){
       System.out.println("I hava a " + name + " " + color + " bird.");
   }
}
