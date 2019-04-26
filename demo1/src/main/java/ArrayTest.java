package main.java;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        /**
         * 为什么数组有length属性？
         * 首先，一个数组是一个容器对象，它拥有固定数量的单一类型的值。一个数组被创建后，它的长度就不能再改变了。
         * 数组的长度可以用作最终实例变量的长度。因此length可以被当做一个数组的一个定义的属性。
         * 一个数组可以通过两种方式创建：1）数组创建表达式；2）数组初始值设定相。当数组被创建，它的容量就变特定的了。
         *
         */
        int[] arr = new int[3];
        System.out.println(arr.length);//length for array

        String str = "abc";
        System.out.println(str.length());//length() for string

        int[] array = new int[3]; //数组创建表达式。它设定了元素类型、嵌套数组的级别数、数组的长度(至少一维数组的长度)。

        /**
         * String类为什么有length()方法？
         * String的底层数据结构是char数组。不需要定义每个应用都不需要的字段。
         */

        /**
         * 怎样高效地确定一个数组是否包含某一值？
         * 这是Java中非常有用并且高频地被使用的操作，也是Stack Overflow上搞投票的问题。正如搞投票的解答中，
         * 这个问题可以通过几种不同的方式解决，但是时间复杂度确相差很大。具体如下:
         * 1. 使用List
         * public boolean contain(String[] array,String targetValue){
         *         return Arrays.asList(array).contains(targetValue);
         *     }
         * 2. 使用Set
         * public boolean contain(String[] array,String targetValue){
         *         Set<String> set = new HashSet<String>(Arrays.asList(array));
         *         return set.contains(targetValue);
         *     }
         * 3. 使用简单的循环
         * public boolean contain(String[] array,String targetValue){
         *         for (String s : array){
         *             if (s.equals(targetValue))
         *                 return true;
         *         }
         *         return false;
         *     }
         * 4. 使用数组的二分查找
         * 二分查找只能在有序的数组下才能使用。
         * public boolean contain(String[] array,String targetValue){
         *         int a = Arrays.binarySearch(array, targetValue);
         *         if (a > 0) {
         *             return true;
         *         }
         *         return false;
         *     }
         *时间复杂度，简单的循环要好于集合的方法。
         */


        /*
        1. 打印一个数组
         */
        int[] intArray = {1, 3, 5, 7, 9};
        String string = Arrays.toString(intArray);
        System.out.println(intArray);
        System.out.println(string);

        /*
        2. 根据一个数组创建ArrayList
         */
        String[] strArray = new String[]{"dong", "xiang", "is", "a", "genius"};
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        System.out.println(list);

        /*
        3. 检查是否一个数组中包含某个值
         */
        String[] strArray1 = new String[]{"one", "two", "three", "four"};
        boolean flag = Arrays.asList(strArray1).contains("two");
        System.out.println(flag);


        /*
        4. 连接两个数组
         */
        int[] intArray1 = {3, 5, 7, 9};
        int[] intArray2 = {1, 2, 4, 6, 8};
        int[] combinedIntArray = ArrayUtils.addAll(intArray1, intArray2);
        for (int i : combinedIntArray) {
            System.out.print(i + " ");
        }

        /*
        5. 声明以内联数组
        method(new String[]{"1","2","4","6","8"})
         */

        /*
        6. 把提供的数组元素放入一个字符串中
         */
        String string1 = StringUtils.join(new String[]{"a", "b", "c"}, ",");
        System.out.println();
        System.out.println(string1);

        /*
        7. 将数组放入set中
         */
        String[] strArray3 = new String[]{"one", "two", "three"};
        Set<String> set = new HashSet<>(Arrays.asList(strArray3));
        System.out.println(set);

        /*
        8. 反转一个数组
         */
        String[] strArray4 = new String[]{"1", "4", "7", "21"};
        ArrayUtils.reverse(strArray4);
        for (String s : strArray4) {
            System.out.print(s + " ");
        }
        System.out.println();

        /*
        9. 将ArrayList转换成Array
         */
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        String[] strArray5 = new String[list1.size()];
        list1.toArray(strArray5);
        for (String string2 : strArray5) {
            System.out.print(string2 + " ");
        }
        System.out.println();

        /*
        10. 从一个数组中移除一个元素
         */
        String[] strings = new String[]{"shane","is","gneius"};
        String[] strings1 = ArrayUtils.removeElement(strings, "shane");
        System.out.println(Arrays.toString(strings1));

        /*
        one more:将int转换成byte数组
         */
        byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
        for (byte b:bytes){
            System.out.format("0x%x ",b);
        }

    }
}
