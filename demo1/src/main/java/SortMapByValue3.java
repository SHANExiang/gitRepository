package main.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("dong", 12);
        map.put("xiang", 45);
        map.put("shane", 23);
        map.put("genius", 32);

        System.out.println(map);

        System.out.println("--------------------------------------");

        Comparator valueComparator3 = new ValueComparator3(map);
        Map sortedMap = new TreeMap(valueComparator3);
        sortedMap.putAll(map);
        System.out.println(sortedMap);

        System.out.println("------------------------------------------");
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
        map3.put(2, 35);
        map3.put(4, 23);
        map3.put(6, 19);
        map3.put(89, 100);

        Map sortedMap3 = new TreeMap(new ValueComparator3(map3));
        sortedMap3.putAll(map3);
        System.out.println(sortedMap3);
    }
}
//使用泛型，使比较器更加通用
//这种方法不是类型安全的，我们需要类型安全并且更通用的解决方法
class ValueComparator3<K,V extends Comparable<V>> implements Comparator<K>{
    Map<K, V> map = new HashMap<K, V>();

    public ValueComparator3(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K o1, K o2) {
        return -map.get(o1).compareTo(map.get(o2));//降序排列
    }
}


