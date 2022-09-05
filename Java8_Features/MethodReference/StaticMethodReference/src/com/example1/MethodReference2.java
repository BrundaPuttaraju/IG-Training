package com.example1;

class MethodReference2 {
	
	public static void ThreadStatus() {
		
		System.out.println("Thread is running");
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread(MethodReference2::ThreadStatus);
		t1.start();
		
	}

}
