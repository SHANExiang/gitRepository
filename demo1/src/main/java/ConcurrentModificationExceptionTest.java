package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 这是通过ArrayList迭代时候，中间删除某个元素时发生的异常。
 */
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
//        for (String string:list){
//            if (string.equals("three"))
//                list.remove(string);
//        }
        //上述代码会发生java.util.ConcurrentModificationException。
        //解决方法有两种，一个如下：
        //1. 通过迭代器，迭代器允许调用者在迭代过程中从底层集合中移除元素
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("two")){
                iterator.remove();
            }
        }
        System.out.println(list);

        System.out.println("-----------------------------");

        //2. 第二种解决方法。使用CopyOnWriteArrayList。CopyOnWriteArrayList是ArrayList的线程安全的变体。
        //它是通过创建基础数组的新副本来进行变化的操作（add(),set()等等）。

        List<String> list1 = new CopyOnWriteArrayList<String>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        System.out.println(list1);
        for (String string:list1){
            if (string.equals("two")){
                list1.remove(string);
            }
        }
        System.out.println(list1);
    }
}
