package main;

import java.util.*;

public class User {
	private String name;
	private int age;
	private String email;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	User (String uName, int uAge, String uEmail) {
		name = uName;
		age = uAge;
		email = uEmail;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String uName){
		name = uName;
	}	
		
	public int getAge(){
		return age;
	}
	public void setAge(int uAge){
		age = uAge;
	}	
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String uEmail){
		email = uEmail;
	}

}
