package com.Example1;

public class InstanceMethodReference {

	public void saySomething() {
		System.out.println("Hello, this is non-static method.");
	}

	public static void main(String[] args) {

		InstanceMethodReference i1 = new InstanceMethodReference();

		Say s2 = i1::saySomething;

		s2.say();

		Say s3 = new InstanceMethodReference()::saySomething;

		s3.say();
	}
}
