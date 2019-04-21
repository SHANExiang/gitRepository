package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayTest {
    public static void main(String[] args) {
        /**
         * Ϊʲô������length���ԣ�
         * ���ȣ�һ��������һ������������ӵ�й̶������ĵ�һ���͵�ֵ��һ�����鱻���������ĳ��ȾͲ����ٸı��ˡ�
         * ����ĳ��ȿ�����������ʵ�������ĳ��ȡ����length���Ա�����һ�������һ����������ԡ�
         * һ���������ͨ�����ַ�ʽ������1�����鴴�����ʽ��2�������ʼֵ�趨�ࡣ�����鱻���������������ͱ��ض����ˡ�
         *
         */
        int[] arr = new int[3];
        System.out.println(arr.length);//length for array

        String str = "abc";
        System.out.println(str.length());//length() for string

        int[] array = new int[3]; //���鴴�����ʽ�����趨��Ԫ�����͡�Ƕ������ļ�����������ĳ���(����һά����ĳ���)��

        /**
         * String��Ϊʲô��length()������
         * String�ĵײ����ݽṹ��char���顣����Ҫ����ÿ��Ӧ�ö�����Ҫ���ֶΡ�
         */

        /**
         * ������Ч��ȷ��һ�������Ƿ����ĳһֵ��
         * ����Java�зǳ����ò��Ҹ�Ƶ�ر�ʹ�õĲ�����Ҳ��Stack Overflow�ϸ�ͶƱ�����⡣�����ͶƱ�Ľ���У�
         * ����������ͨ�����ֲ�ͬ�ķ�ʽ���������ʱ�临�Ӷ�ȷ���ܴ󡣾�������:
         * 1. ʹ��List
         * public boolean contain(String[] array,String targetValue){
         *         return Arrays.asList(array).contains(targetValue);
         *     }
         * 2. ʹ��Set
         * public boolean contain(String[] array,String targetValue){
         *         Set<String> set = new HashSet<String>(Arrays.asList(array));
         *         return set.contains(targetValue);
         *     }
         * 3. ʹ�ü򵥵�ѭ��
         * public boolean contain(String[] array,String targetValue){
         *         for (String s : array){
         *             if (s.equals(targetValue))
         *                 return true;
         *         }
         *         return false;
         *     }
         * 4. ʹ������Ķ��ֲ���
         * ���ֲ���ֻ��������������²���ʹ�á�
         * public boolean contain(String[] array,String targetValue){
         *         int a = Arrays.binarySearch(array, targetValue);
         *         if (a > 0) {
         *             return true;
         *         }
         *         return false;
         *     }
         *ʱ�临�Ӷȣ��򵥵�ѭ��Ҫ���ڼ��ϵķ�����
         */


    }

}
