package com.github.gokolo.personaldashboard;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.github.gokolo.personaldashboard.dao.UserDAO;
import com.github.gokolo.personaldashboard.dto.AddressDTO;
import com.github.gokolo.personaldashboard.dto.UserDTO;

public final class Dashboard {
    private static MapStoreImpl<UserDTO> storeUsers = new MapStoreImpl<>();
    private static UserDAO userDAO;
    private static Scanner scanner = new Scanner(System.in);
    private static final int EXIT_MENU = 0;
    private static final int REGISTER_MENU = 1;
    private static final int LIST_MENU = 2;
    private static final int MODIFY_MENU = 3;
    private static final int DELETE_MENU = 4;

    public static void main(final String... args) {
        System.out.println("Welcome to User Management System ");
        int menu = 0;
        String email;

        do {
            System.out.println("[0] EXIT");
            System.out.println("[1] REGISTER USER");
            System.out.println("[2] LIST ALL USERS");
            System.out.println("[3] MODIFY USER");
            System.out.println("[4] DELETE USER");

            try {
                System.out.println("Choose a menu: ");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                }

                menu = scanner.nextInt();
                scanner.nextLine();

                switch (menu) {
                case EXIT_MENU:
                    // Quit
                    System.out.println("GoodBye...");
                    System.exit(0);
                    break;

                case REGISTER_MENU:
                    // Register User
                    registerUser();
                    break;

                case LIST_MENU:
                    // List out all Users
                    listUsers();
                    break;

                case MODIFY_MENU:
                    // Modify a User
                    System.out.println("Please enter the current email of the user you wish to modify:");
                    email = scanner.next();
                    if (findUser(email)) {
                        deleteUser(email);
                        scanner.nextLine();
                        try {
                            registerUser();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("User details modified:");

                    } else {
                        System.out.println("This user does not exist \n \n");
                    }

                    break;

                case DELETE_MENU:
                    // Delete a User
                    System.out.println("Please enter the current email of the user you wish to delete:");
                    email = scanner.next();
                    deleteUser(email);
                    break;

                default:
                    System.out.println("You have entered an valid menu :( \nPlease try again");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect menu entered :( \nPlease try again");
            }

        } while (true);

    }

    public static void registerUser() {
        UserDTO user = new UserDTO();
        AddressDTO address = new AddressDTO();
        System.out.println("Please enter name:");
        user.setName(scanner.nextLine());
        System.out.println("Please enter username:");
        user.setUsername(scanner.nextLine());
        System.out.println("Please enter password:");
        user.setPassword(scanner.nextLine());
        // Birthday start
        System.out.println("Please enter birthday in the format yyyy-MM-dd: ");
        System.out.println("For example: 1998-12-31");
        Date date = null;
        while (date == null) {
            String line = scanner.nextLine();
            date = java.sql.Date.valueOf(line);
        }
        // Birthday end
        System.out.println("Please enter email:");
        user.setEmail(scanner.nextLine());
        System.out.println("Please enter gender:");
        user.setGender(Gender.valueOf(scanner.nextLine()));
        System.out.println("Please enter role:");
        user.setRole(Role.valueOf(scanner.nextLine()));

        System.out.println("Please enter email:");
        user.setEmail(scanner.next());
        insertUser(user);
    }

    public static void insertUser(final UserDTO user) {
        userDAO.save(user);
    }

    public static void listUsers() {
        System.out.println(storeUsers.retrieve());
    }

    public static boolean findUser(final String email) {
        boolean exists = false;
        for (UserDTO element : storeUsers.retrieve()) {
            if (element.getEmail().equals(email)) {
                exists = true;
            } else {
                exists = false;
            }
        }
        return exists;
    }

    public static void deleteUser(final String email) {
        for (UserDTO element : storeUsers.retrieve()) {
            if (element.getEmail().equals(email)) {
                storeUsers.delete(element);
            }
        }
    }

    private Dashboard() {
    }

}
