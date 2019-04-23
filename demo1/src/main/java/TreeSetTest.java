package main.java;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(23);
        treeSet.add(45);
        treeSet.add(90);
        treeSet.add(56);

        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
        System.out.println("--------------------------");
        if (treeSet.isEmpty()){
            System.out.println("treeSet is empty!");
        }
        else{
            System.out.println("treeSet����Ԫ�أ� " + treeSet.size() + "��");
        }
        System.out.println("--------------------------");
        System.out.println("treeSet�ĵ�һ��Ԫ�أ� " + ((TreeSet<Integer>) treeSet).first());
        System.out.println("treeSet�����һ��Ԫ�أ� " + ((TreeSet<Integer>) treeSet).last());

        if (treeSet.remove(90)){
            System.out.println("treeSet�л��ж��ٸ�Ԫ�أ� " + treeSet.size());
        }
        else{
            System.out.println("treeSet��û�����Ԫ�أ�");
        }
        while(iterator.hasNext()){
            System.out.println(iterator.next() + ",");
        }
        treeSet.clear();
        if (treeSet.isEmpty()){
            System.out.println("treeSet is empty!");
        }
        else{
            System.out.println("treeSet����Ԫ�أ� " + treeSet.size() + "��");
        }

    }
}
