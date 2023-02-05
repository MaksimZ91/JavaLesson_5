package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap <Integer, String> hm = new HashMap<>();
        hm.put(1,"Белый");
        hm.putIfAbsent(2, "Черный");
        hm.putIfAbsent(2, "Синий");
        hm.put(3, "Зеленый");
        //System.out.println(hm);

        for (Integer tmp: hm.keySet()) {
            hm.compute(tmp, (k,v) -> v + "!");
        }
        //System.out.println(hm);

        TreeMap <Integer, String> tm = new TreeMap<>();
        tm.put(1,"Желтый");
        tm.putIfAbsent(2, "Зеленый");
        tm.putIfAbsent(2, "Синий");
        tm.put(3, "Красный");
        //System.out.println(tm);
        tm.clear();
        hm.clear();
        LinkedHashMap  <Integer, String> lhm = new LinkedHashMap<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            tm.put(random.nextInt() , "Общая строка");
            hm.put(random.nextInt(), "Общая строка");
            lhm.put(random.nextInt(), "Общая строка");
        }


        long start = System.currentTimeMillis();
        hm.forEach((k,v) -> System.out.println(v));
        long end = System.currentTimeMillis();

        long start1 = System.currentTimeMillis();
        tm.forEach((k,v) -> System.out.println(v));
        long end1= System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        lhm.forEach((k,v) -> System.out.println(v));
        long end2= System.currentTimeMillis();

        System.out.printf("Перебор HashMap: %d\n", end-start);
        System.out.printf("Перебор TreeMap: %d\n", end1-start1);
        System.out.printf("Перебор LinkedHashMap: %d\n", end2-start2);


    }
}