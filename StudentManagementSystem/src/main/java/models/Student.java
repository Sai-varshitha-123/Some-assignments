package models;

public class Student {
	private int age;
	private String name;
	private String email;
	
	public Student(int age,String name,String email)
	{
		this.age=age;
		this.name=name;
		this.email=email;
	}
	public int getAge() {return age;}
	public String getName() {return name;}
	public String getEmail() {return email;}
}
