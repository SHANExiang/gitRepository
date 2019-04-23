package main.java;

import java.util.*;

public class SortMapByValue4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("dong", 12);
        map.put("xiang", 45);
        map.put("shane", 23);
        map.put("genius", 32);

        System.out.println(map);

        System.out.println("--------------------------------------");
        Map<String, Integer> sortedMap4 = sortMapByValue4(map);
        System.out.println(sortedMap4);
    }

//  另一个泛型方式
    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue4(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<K, V> map4 = new LinkedHashMap<K, V>();
        for (Map.Entry entry : list) {
            map4.put((K) entry.getKey(), (V) entry.getValue());
        }
        return map4;
    }
}
