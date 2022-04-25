package com.solvd.realstateagency.main;

import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.company.Company;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.util.CustomLinkedlist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;

public class Option {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    static Scanner input = new Scanner(System.in);
    private static CustomLinkedlist<Building> availableForYou = new CustomLinkedlist<>();
    private static boolean hasMultiOffice;
    private static boolean hasHouseYard;
    private static boolean hasUniqueRoom;
    private static boolean isIndustryPremises;

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
                            isIndustryPremises = true;
                            flag = false;
                        } else if (chocie3.equalsIgnoreCase("n")) {
                            LOGGER.info("You chose an non industries premises.");
                            isIndustryPremises = false;
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

    public static void showAvailableRentingPropertiesList(LinkedList<Building> building, Customer person) {

        for (int i=0; i < building.size(); i++) {
            switch (building.get(i).getClass().toString()) {
                case "class com.solvd.realstateagency.building.Apartment":
                    if (building.get(i).getUniqueRoom() == hasUniqueRoom && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.House":
                    if (building.get(i).getUniqueRoom() == hasHouseYard && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Office":
                    if (building.get(i).getUniqueRoom() == hasMultiOffice && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                default:
                    if (building.get(i).getUniqueRoom() == isIndustryPremises && person.getSalary() * 0.5 > building.get(i).getRentPrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
            }
        }
    }

    public static void rentAvailableBuilding (Customer person){
        int c = 0;
        int choice;
        LOGGER.info("Which property do you want to rent?: ");
        for (int i = 0; i < availableForYou.size(); i++) {
            LOGGER.info("Option " + (c+1) +": " + availableForYou.getElementAt(c).getElement().getAddress() + "Price per month: AR$ " + availableForYou.getElementAt(c).getElement().getRentPrice());
        }
        try{
            choice = input.nextInt() - 1;
            person.rent(availableForYou.getElementAt(choice).getElement());
        } catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("Property rented!");
    }

    public static void showAvailableBuyingPropertiesList(LinkedList<Building> building, Owner person) {
        for (int i=0; i < building.size(); i++) {
            switch (building.get(i).getClass().toString()) {
                case "class com.solvd.realstateagency.building.Apartment":
                    if (building.get(i).getUniqueRoom() == hasUniqueRoom && person.getMoneyAvailable() > building.get(i).getSalePrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.House":
                    if (building.get(i).getUniqueRoom() == hasHouseYard && person.getMoneyAvailable() > building.get(i).getSalePrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Office":
                    if (building.get(i).getUniqueRoom() == hasMultiOffice && person.getMoneyAvailable() > building.get(i).getSalePrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
                default:
                    if (building.get(i).getUniqueRoom() == isIndustryPremises && person.getMoneyAvailable() > building.get(i).getSalePrice()) {
                        availableForYou.addElement(building.get(i));
                    }
                    break;
            }
        }
    }

    public static void buyAvailableBuilding (Owner person){
        int c = 0;
        int choice;
        LOGGER.info("Which property do you want to buy?: ");
        for (int i = 0; i < availableForYou.size(); i++) {
            LOGGER.info("Option " + (c+1) +": " + availableForYou.getElementAt(c).getElement().getAddress() + "Price: AR$ " + availableForYou.getElementAt(c).getElement().getSalePrice());
        }
        try{
            choice = input.nextInt() - 1;
            person.buy(availableForYou.getElementAt(choice).getElement());
        } catch(Exception e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("Property bought!");
    }
}
