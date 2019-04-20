package main.java;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    事实上，所有的Collection子类型都有一个接收另一个Collection对象的构造器，用所接收的Collection对象
    中的元素填充新的容器。
    下面这个类使用Generator在容器中放置所需数量的对象，然后所产生的容器可以传递给任何Collection的构造器
 */
class CollectionData<T> extends ArrayList<T>{
    public CollectionData(Generator<T> generator,int number){
        for(int i = 0;i< number;i++){
            add(generator.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> generator,int number){
        return new CollectionData<T>(generator, number);
    }
}

class Govenment implements Generator<String>{
    String[] stringArrays = ("shane is a genius " + "yes you are right").split(" ");
    private int index;
    public String next() {
        return stringArrays[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Govenment(), 8));
        set.addAll(CollectionData.list(new Govenment(), 8));
        System.out.println(set);
    }

}
