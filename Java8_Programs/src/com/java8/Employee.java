package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

	private long empId;
	  private String name;
	  private int age;
	  private String designation;
	
	public Employee(long empId, String name, int age, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static void main(String[] args) {
		
		 List<Employee> emp = new ArrayList<Employee>();
		 emp.add(new Employee(1,"Martin",35,"Manager"));
		 emp.add(new Employee(2,"Rocky",38,"General Manager"));
		 emp.add(new Employee(1,"David",40,"Manager"));
		 emp.add(new Employee(1,"Maddy",35,"Developer"));
		 emp.add(new Employee(1,"Joyce",34,"Accountant"));
		 
		 List<Employee> list = emp.stream().filter(e->"Manager".equalsIgnoreCase(e.getDesignation()) 
				 && e.getAge()>30).collect(Collectors.toList());
		 
		 list.forEach(e->System.out.println("Designation : "+e.designation + " , Age : "+e.getAge()));
		 
		 List<String> upper = emp.stream().map(i->i.getName().toUpperCase()).collect(Collectors.toList());

		 System.out.println(upper);
		 
		 //sort the names
		 
		 emp.stream().map(i->i.getName()).sorted().forEach(System.out::println);
		 
		 
		 

	}

}
