package com.hexaware.util;

import java.util.Scanner;

import com.hexaware.model.Cars;

/**
 * main class
 *
 */
public class carsMain {
    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        System.out.println("1. List all Cars");
        System.out.println("2. List a car");
        System.out.println("3. Add a Car");
        System.out.println("4. Update a Car");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Select your option: ");
        int ch = sc.nextInt();

        subMenu(ch);
        sc.close();
    }

    static void subMenu(int ch) {
        switch (ch) {
            case 1:
                listAllCarDetails();
                break;
            case 2:
                listCarDetails();
                break;
            case 3:
                addCar();
                break;
            case 4:
                updateCar();
                break;
            default:
                Runtime.getRuntime().halt(0);
        }
    }

    static void addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Car Name:");
        String carName = sc.next();
        System.out.println("Enter Price");
        double price = sc.nextDouble();

        int result = Cars.insertCar(carName, price);
        if (result > 0) {
            System.out.println("Car Inserted");
        } else {
            System.out.println("Sorry! Was unable to insert car");
        }
        sc.close();
    }

    static void updateCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which is the Car you want to update (enter id)? ");
        int id = sc.nextInt();
        System.out.println("Enter the new price: ");
        double price = sc.nextDouble();
        Cars car=new Cars();
        car.setId(id);
        car.setPrice(price);

        int result = Cars.updateCar(car);
        if (result > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("Update unsuccessful");
        }

        sc.close();
    }

    static void listCarDetails() {
        Scanner sc = new Scanner(System.in);
        // accepting the car name
        System.out.println("Enter Car Id:");
        int id = sc.nextInt();

        // creating a car object
        Cars car = Cars.find(id);
        System.out.println("Car Details");
        System.out.println("Car Name:" + car.getCarName() + " Price: " + car.getPrice());
        sc.close();
    }

    static void listAllCarDetails() {
        Cars[] car = Cars.listAll();
        for (Cars c : car) {
            System.out.println(c.getCarName() + " " + c.getPrice());
        }
    }
}