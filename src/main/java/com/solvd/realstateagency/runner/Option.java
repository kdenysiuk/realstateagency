package com.solvd.realstateagency.runner;

import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.person.Company;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.util.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;

public class Option {

    private static final Logger LOGGER = LogManager.getLogger(MainOld.class);
    static Scanner input = new Scanner(System.in);
    private static boolean hasMultiOffice;
    private static boolean hasHouseYard;
    private static boolean hasUniqueRoom;
    private static boolean isIndusrtyPremises;

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
                        String chocie3 = input.next();
                        if (chocie3.equalsIgnoreCase("y")) {
                            LOGGER.info("You chose an Apartment with a unique room.");
                            hasUniqueRoom = true;
                            flag = false;
                        } else if (chocie3.equalsIgnoreCase("n")) {
                            LOGGER.info("You chose an Apartment with two or more rooms.");
                            hasUniqueRoom = false;
                            flag = false;
                        } else {
                            LOGGER.info("Invalid option, try again.");
                        }
                    }
                    break;
                case 2:
                    LOGGER.info("Do you want to have house-yard too? (y/n)");
                    while (flag) {
                        String choice3 = input.next();
                        if (choice3.equalsIgnoreCase("y")) {
                            LOGGER.info("You chose an house with houseyard.");
                            hasHouseYard = true;
                            flag = false;
                        } else if (choice3.equalsIgnoreCase("n")) {
                            LOGGER.info("You chose an house without houseyard.");
                            hasHouseYard = false;
                            flag = false;
                        } else {
                            LOGGER.info("Invalid option, try again.");
                        }
                    }
                    break;
                case 3:
                    LOGGER.info("Do you want a multi-office room? (y/n)");
                    while (flag) {
                        String choice3 = input.next();
                        if (choice3.equalsIgnoreCase("y")) {
                            LOGGER.info("You chose a multi-office room.");
                            hasMultiOffice = true;
                            flag = false;
                        } else if (choice3.equalsIgnoreCase("n")) {
                            LOGGER.info("You a only office.");
                            hasMultiOffice = false;
                            flag = false;
                        } else {
                            LOGGER.info("Invalid option, try again.");
                        }
                    }
                    break;

                case 4:
                    LOGGER.info("Do you want an industry premise? (y/n)");
                    while (flag) {
                        String chocie3 = input.next();
                        if (chocie3.equalsIgnoreCase("y")) {
                            LOGGER.info("You chose an industries premises.");
                            isIndusrtyPremises = true;
                            flag = false;
                        } else if (chocie3.equalsIgnoreCase("n")) {
                            LOGGER.info("You chose an non industries premises.");
                            isIndusrtyPremises = false;
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
                    propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price per month: AR$ " + elem.getRentPrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                case 2:
                    LOGGER.info("List of Sale Prices");
                    propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price: AR$ " + elem.getSalePrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                default:
                    LOGGER.info("Invalid option, try again!");
            }
        }
    }

    public static void showAvailablePropertiesList (LinkedList<Building> building, Customer person) {
        for (int i=0; i < building.size(); i++) {
            if(building.get(i).getClass().toString().equals("class com.solvd.realstateagency.building.Apartment")) {
                if (building.get(i).getUniqueRoom() == hasUniqueRoom && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                    person.properties.addElement(building.get(i));
                }
            } else if (building.get(i).getClass().toString().equals("class com.solvd.realstateagency.building.House")) {
                if (building.get(i).getUniqueRoom() == hasHouseYard && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                    person.properties.addElement(building.get(i));
                }
            } else if (building.get(i).getClass().toString().equals("class com.solvd.realstateagency.building.Office")) {
                if (building.get(i).getUniqueRoom() == hasMultiOffice && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                    person.properties.addElement(building.get(i));
                }
            } else {
                if (building.get(i).getUniqueRoom() == isIndusrtyPremises && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                    person.properties.addElement(building.get(i));
                }
            }
        }
        LOGGER.info(person.properties.getElementAt(0).getElement().getAddress());
    }
}
