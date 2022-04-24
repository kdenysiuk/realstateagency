package com.solvd.realstateagency.runner;

import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.person.Company;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;

public class Option {

    private static final Logger LOGGER = LogManager.getLogger(MainOld.class);
    static Scanner input = new Scanner(System.in);
    public static void showRentingInfo(Customer person) {
        LOGGER.info("Name: " + person.getPName()
                + "\nDNI: " + person.getPID()
                + "\nTel: " + person.getPTelephone()
                + "\nSalary per month: AR$" + person.getSalary()
                + "\n"
                + "\nPress ENTER to continue");
        input.nextLine();
    }

    public static void showBuyingInfo(Owner person) {
        LOGGER.info("Name: " + person.getPName()
                + "\nDNI: " + person.getPID()
                + "\nTel: " + person.getPTelephone()
                + "\nMoney Available: AR$" + person.getMoneyAvailable()
                + "\n"
                + "\nPress ENTER to continue");
        input.nextLine();
    }

    public static void showCompanyInfo(Company company) {
        LOGGER.info("Name: " + company.getPName()
                + "\nDNI: " + company.getCUIT()
                + "\nTel: " + company.getPTelephone()
                + "\n"
                + "\nPress ENTER to continue");
        input.nextLine();
    }

    public static void asCustomerOption() {
        int choice2;
        boolean flag = true;
        LOGGER.info("Which type of building do you want to choose?:"
                + "\nOption 1: Apartment"
                + "\nOption 2: House"
                + "\nOption 3: Office"
                + "\nOption 4: Premises");
        while (flag) {
            choice2 = input.nextInt();
            switch (choice2) {
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

    public static void asCompanyOption(LinkedList<Building> propertiesList) {
        int choice;
        boolean flag = true;
        LOGGER.info("Choose which type of list you want to see:"
                + "\nOption 1: List of rent prices"
                + "\nOption 2: List of sale prices");
        while (flag) {
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    LOGGER.info("List of Rent Prices");
                    propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAdress() + " Price per month: AR$ " + elem.getRentPrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                case 2:
                    LOGGER.info("List of Sale Prices");
                    propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAdress() + " Price: AR$ " + elem.getSalePrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                default:
                    LOGGER.info("Invalid option, try again!");
            }
        }
    }

    public static void showAvailablePropertiesList (LinkedList<Building> building) {
        for (Building value : building) {
            switch (value.getClass().toString()) {
                case "class com.solvd.realstateagency.building.Apartment":
                    LOGGER.info("tomo apartment");
                    break;
                case "class com.solvd.realstateagency.building.House":
                    LOGGER.info("tomo house");
                    break;
                case "class com.solvd.realstateagency.building.Office":
                    LOGGER.info("tomo office");
                    break;
                default:
                    LOGGER.info("tomo premises");
                    break;
            }
        }
    }


}
