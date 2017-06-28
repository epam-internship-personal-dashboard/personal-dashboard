package main;

import java.util.*;

public class Dashboard {
	static String uName;
	static int uAge; 
	static String uEmail;
	static HashSet<User> hashUsers =  new HashSet<User>();
	static Scanner scanner = new Scanner(System.in);	
	
	public static void main(String[] args) {				
		//Register User
		registerUsers(hashUsers);
		
		//List out all Users
		listUsers(hashUsers);
		
		//
		modifyUser(hashUsers);
	}
	
	public static void registerUsers (HashSet<User> hshUsers) {
		System.out.println("Please enter name:");
		uName = scanner.next();
		System.out.println("Please enter age:");
		uAge = scanner.nextInt();
		System.out.println("Please enter email:");
		uEmail = scanner.next();		
		hshUsers.add(new User(uName, uAge, uEmail));
	}	
	
	public static  void listUsers(HashSet<User> hshUsers) {
		for( User element : hshUsers){
			System.out.println(element +"\n");
		}
	}
	
	public static void modifyUser (HashSet<User> hshUsers) {	
		System.out.println("Please enter the current email of the user you wish to modify:");
		String email = scanner.next().toString();	
		
		System.out.println("Please enter new name:");
		String newName = scanner.next().toString();
		System.out.println("Please enter new email:");
		String newEmail = scanner.next().toString();
		System.out.println("Please enter new age:");
		int newAge = scanner.nextInt();
		
		for( User element : hshUsers){
			if (element.getEmail() == email){
				element.setName(newName);
				element.setEmail(newEmail);
				element.setAge(newAge);
				System.out.println(element +"\n");
			}
			
		}
	}	
	
	public void deleteUser (String uName, String uAge, String uEmail) {
		//email = uEmail;		
		//loop through to find email.
	}
	
}

