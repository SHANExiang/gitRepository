import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Predicate;

public class CollectionTest {
    public static void main(String[] args) {
        /**
         * 以下是stackOverFlow上讨论最多的问题。
         */
        /*
        1. 什么时候使用LinkedList和ArrayList
        首先，ArrayList的基础是一个数组，元素可以通过索引来访问。如果数组已满，需要一个更大的数组来分配，
        并且，需要移动所有的元素到新的数组中，这将耗费O(n)的时间复杂度。
        当添加或者删除元素时，会移动数组中存在的元素到新得位置。这种操作对ArrayList来说是不方便。
        而，LinkedList是一个双向链表，当访问中间的元素时，必须从前往后取寻找。
        但是，要是添加或者移除元素操作就很快，因为仅仅是在本地进行改变。
        总结：最坏的时间复杂度比较如下：
        get(index)        |    O(1)   |   O(n)
        add(E)            |    O(n)   |   O(1)
        add(E, index)     |    O(n)   |   O(n)
        remove(index)     |    O(n)   |   O(n)
        Iterator.remove() |    O(n)   |   O(1)
        Iterator.add(E)   |    O(n)   |   O(1)
        尽管运行实际很长，但对于大List,应当考虑内存使用情况。
        在LinkedList中，每个节点至少需要两个额外指针来链接到前一个节点和下一个节点，
        然而在ArrayList仅仅需要一个元素数组。
         */

        /*
        2. 集合中迭代元素中删除元素的合理用法
        List<Integer> list = new ArrayList<>();
        for(Integer i:list){
        list.remove(i);
        }
        上述代码会抛出java.util.ConcurrentModificationException.
        这是因为生成了一个迭代器（在for语句中）遍历列表，但同时列表由Iterator.remove（）更改。
        在Java中，“一个线程通常不允许修改集合，而另一个线程正在迭代它。”
        可以使用以下方法迭代数据:
         List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.remove();
        }
         */

        /*
        3. 将List转化成数组，最简单方便的方法就是使用Apache commons lang package中的ArrayUtils
          List<Integer> list1 = new ArrayList<>();
        int[] intArray = ArrayUtils.toPrimitive(list1.toArray(new Integer[0]));
        JDK中没有捷径，不能使用list1.toArray()，因为它会返回Integer[]
        但可以使用下面的方法
        for(int i = 0;i< list1.size();i++){
            intArray[i] = list1.get(i);
        }
         */

        /*
        4. 将数组转化成集合。同样最简单的方法就是Apache commons lang package中的ArrayUtils，
        以及Arrays类的asList()方法，如下：
        int[] intArray2 = new int[]{1,2,3,5,7};
        List<Integer> list2 = new ArrayList<>();
        list2 = Arrays.asList(ArrayUtils.toObject(intArray2));
        JDK中就是使用for循环一个一个添加
         */

        /*
        5. 过滤一个集合。
        可以使用迭代器完成。如下：
        List<Integer> list3 = new ArrayList<>();
        Iterator<Integer> iterator = list3.iterator();
        while(iterator.hasNext()){
            int i = iterator.next();
            if (i > 5){
                iterator.remove();
            }
        }
        同样，也可以使用第三方JAR包，如Guava和Apache common lang package。使用Predicate接口
        它们中的实现如下：
        public Interface Predicate<T>{
            boolean test(T t);
        }

    public static <T> void filter(Collection<T> collection, Predicate<T> predicate){
        if((collection != null)&&(predicate != null)){
            Iterator<T> iterator = collection.iterator();
            while(iterator.hasNext()){
                T t = iterator.next();
                if (!predicate.test(t)){
                    iterator.remove();
                }
            }
        }
    }
    看filter()具体使用。
    filter(list3,new Predicate<Integer>()){
        public boolean test(Integer i){
            return i <= 5;
        }
    }
         */

        /*
        6. 将List转换成Set
        第一个方法就将list放入到HashSet中
        Set<Integer> hashSet = new HashSet<>(list);
        第二个方法就是放入到TreeSet中，给他一个比较器
        Set<Integer> treeSet = new TreeSet<>(new Comparator());
        TreeSet.addAll(list);
         */

        /*
        7. 怎样移除list中重复的元素？这可以联系第6条。
        Set<Integer> hashSet = new HashSet<>(list);
        list.clear();
        list.addAll(hashSet);

        如果对元素顺序有要求，可以使用LinkedHashSet。
         */

        /*
        8. 集合排序
        第一个方法就是使用Collections.sort();
        第二种方法时PriorityQueue；
        第三种方法时TreeSet
         */

        /*
        9.Collections.emptyList()返回的实例是不变的。这意味着你不能在empty list中添加元素。
        在后台，Collections.emptyList（）的每次调用实际上都不会创建空列表的新实例。
        相反，它将重用现有的空实例。
         */

        /*
        10.Collections.copy().集合的拷贝
        第一种方法使用ArrayList的构造方法。
        ArrayList desList = new ArrayList(srcList);
        另一种方法就是Collections.copy()。
        ArrayList desList = new ArrayList(srcList.size());
        Collections.copy(desList,srcArray);
         */

    }


}


