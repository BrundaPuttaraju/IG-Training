package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee_Info {
	
	private String name;
	private String dept;
	private int age;
	private long salary;


	

	public Employee_Info(String name, String dept, int age, long salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.salary = salary;
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


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public static void main(String[] args) {
		
	List<Employee_Info> emplist = new ArrayList<Employee_Info>();
	emplist.add(new Employee_Info("Harshad","CS",25,15000));
	emplist.add(new Employee_Info("Karishma","EC",29,25000));
	emplist.add(new Employee_Info("Deepa K","CS",32,32000));
	emplist.add(new Employee_Info("Sagar","EC",23,13000));
	emplist.add(new Employee_Info("Harshad","Mech",20,10000));
	emplist.add(new Employee_Info("Amit","CS",32,43000));
	emplist.add(new Employee_Info("Himanshu","EC",35,50000));
	
	//Select Department, count(*) from employee_schema.employee_info group by Department;
	
	Map<String, Long> emplist1=
			emplist.stream().collect(Collectors.groupingBy(Employee_Info::getDept, Collectors.counting()));
	
	Long count = emplist.stream().filter(i->i.getName().equalsIgnoreCase("Harshad")).count();
	
	// employees salary greater than 30000 and age greater than 32
	emplist.stream().filter(i->i.getSalary() > 30000 && i.getAge()>32).map(Employee_Info::getSalary).forEach(System.out::println);
	
			System.out.println(emplist1);
			
			System.out.println(count);

	
	}}