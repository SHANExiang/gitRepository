package main.java;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    ��ʵ�ϣ����е�Collection�����Ͷ���һ��������һ��Collection����Ĺ��������������յ�Collection����
    �е�Ԫ������µ�������
    ���������ʹ��Generator�������з������������Ķ���Ȼ�����������������Դ��ݸ��κ�Collection�Ĺ�����
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
