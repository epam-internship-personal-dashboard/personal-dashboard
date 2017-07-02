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
		
		//List out all Users
		listUsers();
		
		//Modify a User		
		modifyUser();
		
		//Delete a User
		deleteUser(hashUsers);
		
		//List out all Users
		listUsers();
	}
		
	public static  void listUsers() {
		for( User element : hashUsers){
			System.out.println(element +"\n");
		}
	}
	
	public static void modifyUser () {	
		System.out.println("Please enter the current email of the user you wish to modify:");
		String email = scanner.next().toString();		
		for( User element : hashUsers){
			if (element.getEmail().equals(email)){
				hashUsers.remove(element);
			}			
		}		
		System.out.println("Please enter name:");
		user.setName(scanner.nextLine());
		System.out.println("Please enter age:");
		user.setAge(scanner.nextInt());
		System.out.println("Please enter email:");
		user.setEmail(scanner.next());	
	}	
	
	public static void deleteUser (HashSet<User> hshUsers) {
		System.out.println("Please enter the current email of the user you wish to delete:");
		String email = scanner.next().toString();			
		for( User element : hshUsers){
			if (element.getEmail().equals(email)){
				hshUsers.remove(element);
			}			
		}		
	}
	
}

