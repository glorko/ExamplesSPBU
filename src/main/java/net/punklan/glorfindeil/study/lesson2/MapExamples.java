package net.punklan.glorfindeil.study.lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr_Kichev on 28-Feb-17.
 */
public class MapExamples {
    public static void main(String[] args) {
        Map<String, CustomObjectAfter> map = new HashMap<>();
        map.put("First", new CustomObjectAfter(1 + ""));
        map.put("Second", new CustomObjectAfter(2 + ""));
        System.out.println(map.size());
        System.out.println(map.containsKey("Second"));
        for (Map.Entry<String, CustomObjectAfter> entry : map.entrySet()) {
            System.out.println("1:   " + entry.getKey() + " -> " + entry.getValue());
        }
        map.remove("Second");
        for (Map.Entry<String, CustomObjectAfter> entry : map.entrySet()) {
            System.out.println("2:   " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
