package com.briup.ch13;
/**
	教师类
*/
public class Teacher {
	private long id;
	private String name;
	private int age;
	//构造函数
	public Teacher(){
	
	}
	public Teacher(long id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//setter getter
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}

	//重写Object toString
	public String toString(){
		return "Teacher[ id:"+this.id+",name:"+this.name+",age:"+this.age+"]";
	}
}