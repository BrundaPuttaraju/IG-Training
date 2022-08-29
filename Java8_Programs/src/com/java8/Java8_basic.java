package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8_basic {

	public static void main(String[] args) {
		
		// Count the empty strings 
		
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk"); 
		long count = strList.stream() .filter(x -> x.isEmpty()) .count(); 
		System.out.printf("List %s has %d empty strings %n", strList, count);   
		
		// Count String with length more than 3 
		
		long num = strList.stream() .filter(x -> x.length()> 3) .count(); 
		System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);     
		
		// Count number of String which startswith "a" 
		
		count = strList.stream() .filter(x -> x.startsWith("a")) .count(); 
		System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);   
		
		// Remove all empty Strings from List 
		
		List<String> filtered = strList.stream() .filter(x -> !x.isEmpty()) .collect(Collectors.toList()); 
		System.out.printf("Original List : %s, List without Empty Strings : %s %n", strList, filtered);   
		
		// Create a List with String more than 2 characters 
		
		filtered = strList.stream() .filter(x -> x.length()> 2) .collect(Collectors.toList()); 
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);     
		
		// Convert String to Uppercase and join them using coma 
		
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
		String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", ")); 
		System.out.println(G7Countries);   
		
		System.out.println("--------------");
		
		// List of integers
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4); 
		
		// Create List of square of all distinct numbers
		List<Integer> distinct = numbers.stream() .map( i -> i*i).distinct() .collect(Collectors.toList()); 
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);   
		
		System.out.println("--------------");
		//print even numbers
		List<Integer> myList = Arrays.asList(2,8,10,17,27,33,8,2,10);
		myList.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		//numbers starting with 1
		System.out.println("--------------");
		
		myList.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		//find the first element of the list 
		System.out.println("--------------");
		
		myList.stream().findFirst().ifPresent(System.out::println);
		
		//find duplicate elements in a given integers list
		System.out.println("--------------");
		
		Set<Integer> set = new HashSet();
		myList.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		// sorted elements
		System.out.println("--------------");
		
		myList.stream().sorted().forEach(System.out::println);
		
		System.out.println("--------------"); 
		
		// remove duplicates from an array
		 List<Integer> withoutduplicates = myList.stream().distinct().collect(Collectors.toList());
		 System.out.println("withoutduplicates"+withoutduplicates);
		 System.out.println("--------------");
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		//Get count, min, max, sum, and average for numbers 
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics(); 
		System.out.println("Highest prime number in List : " + stats.getMax()); 
		System.out.println("Lowest prime number in List : " + stats.getMin()); 
		System.out.println("Sum of all prime numbers : " + stats.getSum()); 
		System.out.println("Average of all prime numbers : " + stats.getAverage()); }  

		
	}


