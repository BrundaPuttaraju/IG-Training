package com.example2;

import java.util.function.BiFunction;

public class MerhodReference3 {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer>adder = Arithmetic::add; 
		int result = adder.apply(10, 20);  
		System.out.println(result);  
		}  
	}


