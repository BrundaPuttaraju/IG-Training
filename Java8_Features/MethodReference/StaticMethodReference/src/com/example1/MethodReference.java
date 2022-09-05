package com.example1;

public class MethodReference {

	public static void saySomething() {

		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {

		Sayable s1 = MethodReference::saySomething;

		s1.say();

	}
}
