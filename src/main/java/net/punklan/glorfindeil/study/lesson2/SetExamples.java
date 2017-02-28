package net.punklan.glorfindeil.study.lesson2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Aleksandr_Kichev on 28-Feb-17.
 */
public class SetExamples {
    public static void main(String[] args) {
        Set<CustomObjectBefore> unique = new HashSet<CustomObjectBefore>();
        Set<CustomObjectAfter> notUnique = new HashSet<CustomObjectAfter>();
        for (int i = 0; i < 10000; i++) {
            unique.add(new CustomObjectBefore("TEST"));
            notUnique.add(new CustomObjectAfter("TEST"));
        }
        System.out.println(unique.size());
        System.out.println(notUnique.size());
        SortedSet<CustomObjectAfter> sorted = new TreeSet<CustomObjectAfter>();
        try {
            sorted.add(new CustomObjectAfter("wow"));
        } catch (ClassCastException e) {
            System.out.println("Cannot add not comparable " + e);
        }
        sorted = new TreeSet<>(new Comparator<CustomObjectAfter>() {
            @Override
            public int compare(CustomObjectAfter o1, CustomObjectAfter o2) {
                return o1.getSomeField().compareTo(o2.getSomeField());
            }
        });
        for (int i = 100; i > 0; i--) {
            sorted.add(new CustomObjectAfter(i + ""));
        }
        System.out.println(sorted.stream().map(CustomObjectAfter::getSomeField).collect(Collectors.joining(" ")));
        sorted = new TreeSet<>(new Comparator<CustomObjectAfter>() {
            @Override
            public int compare(CustomObjectAfter o1, CustomObjectAfter o2) {
                return Integer.valueOf(o1.getSomeField()).compareTo(Integer.valueOf(o2.getSomeField()));
            }
        });
        for (int i = 100; i > 0; i--) {
            sorted.add(new CustomObjectAfter(i + ""));
        }
        System.out.println(sorted.stream().map(CustomObjectAfter::getSomeField).collect(Collectors.joining(" ")));
    }
}
