

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ����ͨ��ArrayList����ʱ���м�ɾ��ĳ��Ԫ��ʱ�������쳣��
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
        //��������ᷢ��java.util.ConcurrentModificationException��
        //������������֣�һ�����£�
        //1. ͨ��������������������������ڵ��������дӵײ㼯�����Ƴ�Ԫ��
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("two")){
                iterator.remove();
            }
        }
        System.out.println(list);

        System.out.println("-----------------------------");

        //2. �ڶ��ֽ��������ʹ��CopyOnWriteArrayList��CopyOnWriteArrayList��ArrayList���̰߳�ȫ�ı��塣
        //����ͨ����������������¸��������б仯�Ĳ�����add(),set()�ȵȣ���

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
