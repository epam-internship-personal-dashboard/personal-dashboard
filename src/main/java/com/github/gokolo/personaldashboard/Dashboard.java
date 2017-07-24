package com.github.gokolo.personaldashboard;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.github.gokolo.personaldashboard.dao.AddressDAO;
import com.github.gokolo.personaldashboard.dao.AddressDAOImpl;
import com.github.gokolo.personaldashboard.dao.UserDAO;
import com.github.gokolo.personaldashboard.dao.UserDAOImpl;
import com.github.gokolo.personaldashboard.dto.AddressDTO;
import com.github.gokolo.personaldashboard.dto.UserDTO;

@SuppressWarnings("PMD")
public final class Dashboard {
    private static Scanner scanner = new Scanner(System.in);
    private static final int EXIT_MENU = 0;
    private static final int REGISTER_MENU = 1;
    private static final int LIST_MENU = 2;
    private static final int FIND_MENU = 3;
    private static final int MODIFY_MENU = 4;
    private static final int DELETE_MENU = 5;
    private static AddressDAO addressDAOImpl = new AddressDAOImpl();
    private static UserDAO userDAO = new UserDAOImpl();

    public static void main(final String... args) {
        AddressDTO address = new AddressDTO();
        System.out.println("Welcome to User Management System ");
        int menu = 0;

        do {
            System.out.println("[0] EXIT");
            System.out.println("[1] REGISTER USER");
            System.out.println("[2] LIST ALL USERS");
            System.out.println("[3] FIND A USER");
            System.out.println("[4] MODIFY USER");
            System.out.println("[5] DELETE USER");

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

                case FIND_MENU:
                    // Find User by ID
                    try {
                        System.out.println("Please enter the User's ID:");
                        int id = scanner.nextInt();
                        UserDTO user = findUser(id);
                        if (user.getId() != 0) {
                            System.out.println(user);
                            address = addressDAOImpl.findById(user.getAddressId());
                            System.out.println(address);
                        } else {
                            System.out.println("There is no user with that ID.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input entered! \n");
                    }
                    break;

                case MODIFY_MENU:
                    try {
                        System.out.println("Please enter the ID of the user you wish to modify:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        UserDTO user = findUser(id);
                        if (user.getId() != 0) {
                            System.out.println("You are modifying the user: " + user.getName());
                            int addressId = user.getAddressId();
                            user = receiveUserData();
                            address = receiveAddressData();
                            user.setId(id);
                            modifyUsers(user);
                            address.setId(addressId);
                            addressDAOImpl.modify(address);

                        } else {
                            System.out.println("There is no user with that ID.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input entered! \n");
                    }

                    break;

                case DELETE_MENU:
                    // Delete a User
                    try {
                        System.out.println("Please enter the ID of the user you wish to delete:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        UserDTO user = findUser(id);
                        if (user.getId() != 0) {
                            System.out.println(user);
                            System.out.println("You have deleted the user: " + user.getName());
                            address = addressDAOImpl.findById(user.getAddressId());
                            System.out.println(address);
                            deleteUser(user);
                            addressDAOImpl.delete(address);

                        } else {
                            System.out.println("There is no user with that ID.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input entered! \n");
                    }
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

    public static UserDTO receiveUserData() {
        UserDTO user = new UserDTO();
        System.out.println("Please enter name:");
        user.setName(scanner.nextLine());
        System.out.println("Please enter username:");
        user.setUsername(scanner.nextLine());
        System.out.println("Please enter password:");
        user.setPassword(scanner.nextLine());

        try {
            System.out.println("Please enter birthday in the format yyyy-MM-dd: ");
            System.out.println("For example: 1998-12-31");
            Date date = null;
            while (date == null) {
                String line = scanner.nextLine();
                date = java.sql.Date.valueOf(line);
                user.setBirthday(date);
                System.out.println("Please enter gender:");
                user.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));
                System.out.println("Please enter role:");
                user.setRole(Role.valueOf(scanner.nextLine().toUpperCase()));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input! Try again.");
            System.exit(0);
        }
        System.out.println("Please enter email:");
        user.setEmail(scanner.nextLine());

        return user;
    }

    public static AddressDTO receiveAddressData() {
        AddressDTO address = new AddressDTO();
        System.out.println("Please provide an address");
        System.out.println("Enter house number:");
        address.setHouseNumber(scanner.next());
        System.out.println("Enter name of street:");
        address.setStreet(scanner.next());
        System.out.println("Enter zip code:");
        address.setZipCode(scanner.next());
        System.out.println("Enter name of city:");
        address.setCity(scanner.next());
        System.out.println("Enter name of country:");
        address.setCountry(scanner.next());
        return address;
    }

    public static void registerUser() {
        UserDTO user = receiveUserData();
        AddressDTO address = receiveAddressData();

        address = addressDAOImpl.save(address);
        user.setAddressId(address.getId());
        userDAO.save(user);
    }

    public static void listUsers() {
        System.out.println(userDAO.findAll());
    }

    public static void modifyUsers(final UserDTO user) {
        userDAO.modify(user);
    }

    public static UserDTO findUser(final int id) {
        UserDTO user = new UserDTO();
        user = userDAO.findById(id);
        return user;
    }

    public static void deleteUser(final UserDTO user) {
        userDAO.delete(user);
    }

    private Dashboard() {
    }

}
