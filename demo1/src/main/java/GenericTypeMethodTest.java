package main.java;

import java.util.HashSet;
import java.util.Set;

public class GenericTypeMethodTest {
    public static void main(String[] args) {
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        set1.add(23);
        set1.add(45);
        set1.add(67);
        set2.add(45);
        set2.add(67);
        set2.add(80);
        Set set = getIntersection(set1, set2);
        System.out.println(set);
        /*
        getIntersection()不是类型安全的，编译器会发出警告。会出现几个问题：
        1）方法执行后，返回一个set，但是调用者可能不知道返回值的类型，这就必须要通过对每个元素进行类型转换操作；
        2）当两个Set中存放不同类型元素时，方法不能执行；
        3）我们可能要经常修复警告信息。
         */

        /*
        getIntersection1()方法时类型安全的，并且编译器不会发出警告。特定三种set有着相同的类型数据，都是E类型的
        调用者可以知道返回类型，并且不需要进行类型转换操作，现在对集合中元素类型进行强制限制，所以只有两个
        拥有相同元素类型的集合才能进行取交集操作。
         */
    }
    /**
     * 假设需要写一个方法传入两个Set，要得到它们的交集，这种方法实现具体如下：
     */
    private static Set getIntersection(Set set1,Set set2){
        Set set = new HashSet();
        for (Object object:set1){
            if (set2.contains(object)){
                set.add(object);
            }
        }
        return set;
    }
    //Generic Types method
    private static <E> Set<E> getIntersection1(Set<E> set1,Set<E> set2){
        Set<E> set = new HashSet<E>();
        for (E e:set1){
            if (set2.contains(e)){
                set.add(e);
            }
        }
        return set;
    }

}
