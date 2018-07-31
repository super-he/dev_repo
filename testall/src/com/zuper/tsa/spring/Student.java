package com.zuper.tsa.spring;

public class Student {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("2 call attr's setter ..");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "3-4 Student [id=" + id + ", name=" + name + "]";
	}
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
		super();
		System.out.println("1 default constructor ..");
	}
	
	public void init(){
		System.out.println("3 bean init ..");
	}
	
	public void destroy(){
		System.out.println("4 bean destroy ..");
	}
}
