package com.sandalliyasarcan.main;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer>  cities = new HashMap<>();

        cities.put("Izmir" , 35);
        cities.put("Istanbul" , 34);
        cities.put("Kocaeli" , 41);

        System.out.println(cities.get("Istanbul"));


        cities.put("Istanbul" , 99);

        System.out.println(cities.get("Istanbul"));




    }
}
