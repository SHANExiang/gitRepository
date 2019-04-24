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
        getIntersection()�������Ͱ�ȫ�ģ��������ᷢ�����档����ּ������⣺
        1������ִ�к󣬷���һ��set�����ǵ����߿��ܲ�֪������ֵ�����ͣ���ͱ���Ҫͨ����ÿ��Ԫ�ؽ�������ת��������
        2��������Set�д�Ų�ͬ����Ԫ��ʱ����������ִ�У�
        3�����ǿ���Ҫ�����޸�������Ϣ��
         */

        /*
        getIntersection1()����ʱ���Ͱ�ȫ�ģ����ұ��������ᷢ�����档�ض�����set������ͬ���������ݣ�����E���͵�
        �����߿���֪���������ͣ����Ҳ���Ҫ��������ת��������
         */
    }
    /**
     * ������Ҫдһ��������������Set��Ҫ�õ����ǵĽ��������ַ���ʵ�־������£�
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
