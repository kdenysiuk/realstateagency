package com.solvd.realstateagency.runner;

import com.solvd.realstateagency.person.Company;
import com.solvd.realstateagency.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Option {

    private static final Logger LOGGER = LogManager.getLogger(MainOld.class);


    public static void asCompanyOption() {
        try (Scanner input = new Scanner(System.in)){
            int choice;
            boolean flag = true;
            LOGGER.info("Which action do you want to do?:"
                    + "\nOption 1: Renting Customer"
                    + "\nOption 2: Buying Customer"
                    + "\nOption 3: Company");
        }
    }

    public static void showPersonInfo(Person person) {
        try(Scanner enter = new Scanner(System.in)) {
            LOGGER.info("Name: " + person.getPName()
                + "\nDNI: " + person.getPID()
                + "\nTel: " + person.getPTelephone()
                + "\n"
                + "\nPress ENTER to continue");
            enter.nextLine();
        }
    }

    public static void showCompanyInfo(Company company) {
        try(Scanner enter = new Scanner(System.in)) {
            LOGGER.info("Name: " + company.getPName()
                    + "\nDNI: " + company.getCUIT()
                    + "\nTel: " + company.getPTelephone()
                    + "\n"
                    + "\nPress ENTER to continue");
            enter.nextLine();
        }
    }
    public static void asCustomerOption(){
        try (Scanner input = new Scanner(System.in)) {
            int choice;
            boolean flag = true;
            LOGGER.info("Which type of building do you want to choose?:"
                    + "\nOption 1: Apartment"
                    + "\nOption 2: House"
                    + "\nOption 3: Office"
                    + "\nOption 4: Premises");
            while (flag) {

                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        LOGGER.info("Do you want a unique room apartment? (y/n)");
                        while (flag) {
                            String uniqueRoom = input.next();
                            if (uniqueRoom.equalsIgnoreCase("y")) {
                                LOGGER.info("You chose an Apartment with a unique room.");
                                flag = false;
                            } else if (uniqueRoom.equalsIgnoreCase("n")) {
                                LOGGER.info("You chose an Apartment with two or more rooms.");
                                flag = false;
                            } else {
                                LOGGER.info("Invalid option, try again.");
                            }
                        }
                        break;
                    case 2:
                        LOGGER.info("Do you want to have house-yard too? (y/n)");
                        while (flag) {
                            String hasHouseYard = input.next();
                            if (hasHouseYard.equalsIgnoreCase("y")) {
                                LOGGER.info("You chose an house with houseyard.");
                                flag = false;
                            } else if (hasHouseYard.equalsIgnoreCase("n")) {
                                LOGGER.info("You chose an house without houseyard.");
                                flag = false;
                            } else {
                                LOGGER.info("Invalid option, try again.");
                            }
                        }
                        break;
                    case 3:
                        LOGGER.info("Do you want a multi-office room? (y/n)");
                        while (flag) {
                            String hasMultiOffice = input.next();
                            if (hasMultiOffice.equalsIgnoreCase("y")) {
                                LOGGER.info("You chose a multi-office room.");
                                flag = false;
                            } else if (hasMultiOffice.equalsIgnoreCase("n")) {
                                LOGGER.info("You a only office.");
                                flag = false;
                            } else {
                                LOGGER.info("Invalid option, try again.");
                            }
                        }
                        break;

                    case 4:
                        LOGGER.info("Do you want an industry premise? (y/n)");
                        while (flag) {
                            String industry = input.next();
                            if (industry.equalsIgnoreCase("y")) {
                                LOGGER.info("You chose an industries premises.");
                                flag = false;
                            } else if (industry.equalsIgnoreCase("n")) {
                                LOGGER.info("You chose an non industries premises.");
                                flag = false;
                            } else {
                                LOGGER.info("Invalid option, try again.");
                            }
                        }
                        break;

                    default:
                        LOGGER.info("Invalid option, try again.");
                }
            }
        }
    }
}
