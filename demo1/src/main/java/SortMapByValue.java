package main.java;


import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class SortMapByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("dong", 12);
        hashMap.put("xiang", 45);
        hashMap.put("shane", 23);
        hashMap.put("genius", 32);
        System.out.println(hashMap);

        System.out.println("---------------------------------------------------");

        TreeMap<String, Integer> treeMap = SortMapByValue.sortMapByValue(hashMap);
        System.out.println(treeMap);
    }
    public static TreeMap<String,Integer> sortMapByValue(HashMap<String,Integer> map){
        Comparator valueComparator = new ValueComparator(map);
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(valueComparator);
        treeMap.putAll(map);
        return treeMap;
    }
}

/**
 * 我们通过TreeMap进行值得排序，创建TreeMap时给它传递一个比较器。
 * 比较器中封装一个Map对象，比较器接受string参数，通过map得到value,在compare()方法中进行比较。
 * 但这种方法不通用
 */

class ValueComparator implements Comparator<String>{
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public int compare(String o1, String o2) {
        if (hashMap.get(o1) >= hashMap.get(o2)){
            return -1;
        }
         else{
            return 1;
        }
    }
}
