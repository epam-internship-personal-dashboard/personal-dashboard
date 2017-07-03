package main;

import java.util.*;

public class Dashboard {
	static String uName;
	static int uAge; 
	static String uEmail;
	static User user = new User();
	static HashSet<User> hashUsers =  new HashSet<User>();
	static Scanner scanner = new Scanner(System.in);	
	
	public static void main(String[] args) {				
	//Register User		
		System.out.println("Please enter name:");
		user.setName(scanner.nextLine());
		System.out.println("Please enter age:");
		user.setAge(scanner.nextInt());
		System.out.println("Please enter email:");
		user.setEmail(scanner.next());	
		registerUsers();
		
		//List out all Users
		listUsers();
		
		//Modify a User		
		System.out.println("Please enter the current email of the user you wish to modify:");
		deleteUser();
		System.out.println("Please enter name:");
		user.setName(scanner.nextLine());
		System.out.println("Please enter age:");
		user.setAge(scanner.nextInt());
		System.out.println("Please enter email:");
		user.setEmail(scanner.next());	
		registerUsers();
		System.out.println("User details modified:");
		
		//List out all Users
		listUsers();
		
		//Delete a User
		System.out.println("Please enter the current email of the user you wish to delete:");
		deleteUser();
		
		
		//List out all Users
		listUsers();
	}
	
	public static void registerUsers () {			
		hashUsers.add(user);		
		 	}
		
	public static  void listUsers() {
		for( User element : hashUsers){
			System.out.println(element +"\n");
		}
	}
	

	public static void deleteUser () {		
		String email = scanner.next().toString();			
		for( User element : hashUsers){
			if (element.getEmail().equals(email)){
				hashUsers.remove(element);
			}			
		}		
	}
	
}

