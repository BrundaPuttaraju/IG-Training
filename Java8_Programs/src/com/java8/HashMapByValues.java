package com.java8;
import java.util.*;
import java.util.Map.Entry;

class HashMapByValues {

  public static void main(String[] args) {

    LinkedHashMap<Integer, String> list = new LinkedHashMap();
    list.put(1, "Java");
    list.put(5, "Springboot");
    list.put(3, "C");
    list.put(8, "Pyton");
    list.put(4, "Html");

    Map<Integer, String> result = sortMap(list);

    for (Map.Entry entry : result.entrySet()) {
      System.out.print("Key: " + entry.getKey());
      System.out.println(" Value: " + entry.getValue());
    }
  }

  public static LinkedHashMap sortMap(LinkedHashMap map) {
    List <Entry<Integer, String>> list1 = new LinkedList<>(map.entrySet());

    Collections.sort(list1, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));

    
    LinkedHashMap<Integer, String> result = new LinkedHashMap();

    
    for (Map.Entry<Integer, String> entry : list1) {
      result.put(entry.getKey(), entry.getValue());
    }

    return result;
  }
}