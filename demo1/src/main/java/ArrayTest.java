package main.java;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.util.*;

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


        /*
        1. ��ӡһ������
         */
        int[] intArray = {1, 3, 5, 7, 9};
        String string = Arrays.toString(intArray);
        System.out.println(intArray);
        System.out.println(string);

        /*
        2. ����һ�����鴴��ArrayList
         */
        String[] strArray = new String[]{"dong", "xiang", "is", "a", "genius"};
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        System.out.println(list);

        /*
        3. ����Ƿ�һ�������а���ĳ��ֵ
         */
        String[] strArray1 = new String[]{"one", "two", "three", "four"};
        boolean flag = Arrays.asList(strArray1).contains("two");
        System.out.println(flag);


        /*
        4. ������������
         */
        int[] intArray1 = {3, 5, 7, 9};
        int[] intArray2 = {1, 2, 4, 6, 8};
        int[] combinedIntArray = ArrayUtils.addAll(intArray1, intArray2);
        for (int i : combinedIntArray) {
            System.out.print(i + " ");
        }

        /*
        5. ��������������
        method(new String[]{"1","2","4","6","8"})
         */

        /*
        6. ���ṩ������Ԫ�ط���һ���ַ�����
         */
        String string1 = StringUtils.join(new String[]{"a", "b", "c"}, ",");
        System.out.println();
        System.out.println(string1);

        /*
        7. ���������set��
         */
        String[] strArray3 = new String[]{"one", "two", "three"};
        Set<String> set = new HashSet<>(Arrays.asList(strArray3));
        System.out.println(set);

        /*
        8. ��תһ������
         */
        String[] strArray4 = new String[]{"1", "4", "7", "21"};
        ArrayUtils.reverse(strArray4);
        for (String s : strArray4) {
            System.out.print(s + " ");
        }
        System.out.println();

        /*
        9. ��ArrayListת����Array
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
        10. ��һ���������Ƴ�һ��Ԫ��
         */
        String[] strings = new String[]{"shane","is","gneius"};
        String[] strings1 = ArrayUtils.removeElement(strings, "shane");
        System.out.println(Arrays.toString(strings1));

        /*
        one more:��intת����byte����
         */
        byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
        for (byte b:bytes){
            System.out.format("0x%x ",b);
        }

    }
}
