package main.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("dong", 12);
        map.put("xiang", 45);
        map.put("shane", 23);
        map.put("genius", 32);

        System.out.println(map);

        System.out.println("--------------------------------------");

        Map sortedMap = sortMapByValue2(map);
        System.out.println(sortedMap);

    }
    public static Map<String,Integer> sortMapByValue2(Map<String,Integer> map){
        Comparator valueComparator2 = new ValueCompatator2(map);
        Map<String, Integer> map2 = new TreeMap<String,Integer>(valueComparator2);
        map2.putAll(map);
        return map2;
    }
}

/**
 * 忽略泛型，使比较器使用与任何类型。
 */

class ValueCompatator2 implements Comparator{
    Map map;

    public ValueCompatator2(Map map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        Comparable value1 = (Comparable) map.get(o1);
        Comparable value2 = (Comparable) map.get(o2);
        return value1.compareTo(value2);
    }
}

