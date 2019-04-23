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
            System.out.println("treeSet中有元素： " + treeSet.size() + "个");
        }
        System.out.println("--------------------------");
        System.out.println("treeSet的第一个元素： " + ((TreeSet<Integer>) treeSet).first());
        System.out.println("treeSet的最后一个元素： " + ((TreeSet<Integer>) treeSet).last());

        if (treeSet.remove(90)){
            System.out.println("treeSet中还有多少个元素： " + treeSet.size());
        }
        else{
            System.out.println("treeSet中没有这个元素！");
        }
        while(iterator.hasNext()){
            System.out.println(iterator.next() + ",");
        }
        treeSet.clear();
        if (treeSet.isEmpty()){
            System.out.println("treeSet is empty!");
        }
        else{
            System.out.println("treeSet中有元素： " + treeSet.size() + "个");
        }

    }
}
