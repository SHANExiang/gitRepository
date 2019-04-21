package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


    }

}
