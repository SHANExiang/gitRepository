package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static  void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("MI", 21);
        hashMap.put("HUAWEI", 36);
        hashMap.put("THINKPAD", 78);
        hashMap.put("MPB", 100);
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        System.out.println("-------------------------------------------");

        for (Map.Entry entry:hashMap.entrySet()){
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

    }

}
