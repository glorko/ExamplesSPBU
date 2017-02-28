package net.punklan.glorfindeil.study.lesson2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Aleksandr_Kichev on 27-Feb-17.
 */
public class ListExamples {
    public static void main(String[] args) {
        List<String> example = new ArrayList<String>();
        example.add("Hop");
        example.add("Hey");
        example.add("Lalalay");
        example.addAll(Arrays.asList("Gde", "Vopros", "i", "Gde", "Otvet"));
        System.out.println(example.get(4));
        try {
            System.out.println(example.get(100));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ok we got an exception" + e);
        }
        for (String str : example) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println("Size is " + example.size());
        System.out.println(example.indexOf("Vopros"));
        example.remove("Gde");
        example.remove(2);
        //java 8 lambda stuff
        System.out.println(example.stream().collect(Collectors.joining(" ", "\\", "/")));
        checkSpeed(100000);
        checkSpeed(10000000);

    }

    private static void checkSpeed(Integer size) {
        System.out.println("Checking operations speed with array size " + size + " -----------------------");
        List<CustomObjectBefore> arrayList = new ArrayList<CustomObjectBefore>();
        List<CustomObjectBefore> linkedList = new LinkedList<CustomObjectBefore>();
        Long time = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            CustomObjectBefore obj = new CustomObjectBefore("TEST" + i);
            arrayList.add(i, obj);
        }
        System.out.println("Insert in AL for " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(i, new CustomObjectBefore("TEST" + i));
        }
        System.out.println("Insert in LL for " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            arrayList.get(i);
        }
        System.out.println("Get from AL for " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            linkedList.get(i);
        }
        System.out.println("Get from LL for " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.remove(i + 10000);
        }
        System.out.println("Delete from AL for " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.remove(i + 10000);
        }
        System.out.println("Delete from LL for " + (System.currentTimeMillis() - time));
    }
}
