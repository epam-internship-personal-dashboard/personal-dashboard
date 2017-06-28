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
		
		//Modify a User
		modifyUser(hashUsers);
		
		//Delete a User
		deleteUser(hashUsers);
		
		//List out all Users
		listUsers(hashUsers);
	}
	
	public static void registerUsers (HashSet<User> hshUsers) {
		System.out.println("Please enter name:");
		uName = scanner.nextLine();
		System.out.println("Please enter age:");
		uAge = scanner.nextInt();
		System.out.println("Please enter email:");
		uEmail = scanner.next();		
		hshUsers.add(new User(uName, uAge, uEmail));
		//hshUsers.remove(o)
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
			if (element.getEmail().equals(email)){
				element.setName(newName);
				element.setEmail(newEmail);
				element.setAge(newAge);
				System.out.println(element +"\n");
			}
			
		}
	}	
	
	public static void deleteUser (HashSet<User> hshUsers) {
		System.out.println("Please enter the current email of the user you wish to delete:");
		String email = scanner.next().toString();	
		String newName;
		
		for( User element : hshUsers){
			if (element.getEmail().equals(email)){
				newName = element.getName();
				hshUsers.remove(element);
				System.out.println("The user:" + newName +"has been deleted");
			}
			
		}		
	}
	
}

