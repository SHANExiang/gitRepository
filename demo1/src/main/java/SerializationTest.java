package main.java;

import java.io.*;

/**
 * Java中，对象序列化是指以字符序列表示一个对象。这个字节包括对象数据和信息。
 * 序列化对象可以写入到文件或者数据库中，并且从文件或数据库中读取并反序列化。
 * 表示对象和数据的字节可以用来在内存中新建对象。
 *
 * 为什么我们需要序列化对象？
 * 当需要将对象传到网络中或者存储在文件中，这时就需要序列化了。网络设备和存储硬盘只能理解位和字节，
 * 而不能理解对象，序列化将对象转换成字节并通过网络发送并保存。
 * 为什么我们需要将对象储存或者传递？
 * 1. 对象创建取决于很多上下文，一旦创建，其他的组件就需要它的方法或者字段；
 * 2. 当对象创建后，我们不确定使用哪个字段，因此将其存储到数据库以便以后的数据分析。
 */
public class SerializationTest {
    public static void main(String[] args){
        Bird bird = new Bird();
        bird.setName("shane");
        bird.setColor("read");
        bird.setWeight(2.3);

        //序列化对象
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("c:/bird.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bird);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("序列化Bird被写入了文件/bird.ser中。");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //去序列化
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
        System.out.println("bird的名字是： " + bird.getName());
        System.out.println("bird的颜色是： " + bird.getColor());
        System.out.println("bird的重量是： " + bird.getWeight());

        bird.introduce();
    }
}
class Bird implements Serializable{
    private static final long serialVersionUID =  -5742822984616863149L;
    private String name;
    private String color;
    private transient double weight;//表示序列化过程不会对字段weight操作

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
