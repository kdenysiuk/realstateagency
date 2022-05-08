package com.solvd.realstateagency.main;

import com.solvd.realstateagency.building.*;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.exception.InvalidOptionException;
import com.solvd.realstateagency.exception.NullBuildingException;
import com.solvd.realstateagency.innterface.IBuy;
import com.solvd.realstateagency.innterface.IPrintable;
import com.solvd.realstateagency.innterface.ISell;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.reflection.BuildingReflection;
import com.solvd.realstateagency.util.CustomLinkedlist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agency implements IBuy, ISell {

    private int CUIT;
    private String pName;
    private String pTelephone;
    private double moneyAvailable;
    CustomLinkedlist<Building> properties = new CustomLinkedlist<>();
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    static Scanner input = new Scanner(System.in);

    LinkedList<Building> propertiesAvailable = new LinkedList<>();
    private static boolean hasMultiOffice;
    private static boolean hasHouseYard;
    private static boolean hasUniqueRoom;
    private static boolean isIndustryPremises;
    private static String buildingClass;

    //constructor
    public Agency (int CUIT, String pName, String pTelephone) {
        this.CUIT = CUIT;
        this.pName = pName;
        this.pTelephone = pTelephone;
    }

    //setters
    public void setMoneyAvailable(int moneyAvailable) throws InvalidNumberException {
        if (moneyAvailable < 0) {
            throw new InvalidNumberException();
        }
        this.moneyAvailable = moneyAvailable;
    }
    public void setPID(int pID) {
        this.CUIT = pID;
    }
    public void setPName(String pName) {
        this.pName = pName;
    }
    public void setPTelephone(String pTelephone) {
        this.pTelephone = pTelephone;
    }

    //getters
    public int getCUIT() {
        return CUIT;
    }
    public String getPName() {
        return pName;
    }
    public String getPTelephone() {
        return pTelephone;
    }
    public double getMoneyAvailable() {
        return moneyAvailable;
    }

    @Override
    public void buy(Building property) {
        if (moneyAvailable < property.getSalePrice()) {
            throw new InvalidAmountException();
        }
        moneyAvailable = moneyAvailable - property.getSalePrice();
        properties.addElement(property);
    }

    @Override
    public void sell(int propertyPrice, int index) {
        moneyAvailable = moneyAvailable + propertyPrice;
        properties.removeElementAt(index);
    }

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

    public static void showCompanyInfo(Agency company) {
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
                        buildingClass = "class com.solvd.realstateagency.building.Apartment";
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
                        buildingClass = "class com.solvd.realstateagency.building.House";
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
                        buildingClass = "class com.solvd.realstateagency.building.Office";
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
                        buildingClass = "class com.solvd.realstateagency.building.Premises";
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
        IPrintable rentProperList = () -> propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price per month: AR$ " + elem.getRentPrice()));
        IPrintable saleProperList = () -> propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price: AR$ " + elem.getSalePrice()));
        int choice;
        boolean flag = true;
        LOGGER.info("Choose which type of list you want to see:"
                + "\nOption 1: List of rent prices"
                + "\nOption 2: List of sale prices"
                + "\nOption 3: Identify Buildings");
        while (flag) {
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    LOGGER.info("List of Rent Prices");
                    rentProperList.showList();
                    //propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price per month: AR$ " + elem.getRentPrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                case 2:
                    LOGGER.info("List of Sale Prices");
                    saleProperList.showList();
                    //propertiesList.forEach((Building elem) -> LOGGER.info("Address: " + elem.getAddress() + " Price: AR$ " + elem.getSalePrice()));
                    LOGGER.info("\n"
                            + "\nPress ENTER to continue");
                    flag = false;
                    break;
                case 3:
                    BuildingReflection.identifyBuilding(propertiesList);
                    break;
                default:
                    LOGGER.info("Invalid option, try again!");
            }
        }
    }

    public static void showAvailableBuyingPropertiesList(LinkedList<Building> building, CustomLinkedlist<Building> availableForYou, Owner person) throws InvalidOptionException {

        LinkedList<Building> buildingFilter = new LinkedList<>(building.stream().filter(building1 -> (building1.getClass().toString().equals(buildingClass))).collect(Collectors.toList()));

        for (int i=0; i < buildingFilter.size(); i++) {

            switch (buildingFilter.get(i).getClass().toString()) {
                case "class com.solvd.realstateagency.building.Apartment":
                    if (((Apartment)buildingFilter.get(i)).getUniqueRoom() == hasUniqueRoom && person.getMoneyAvailable() > buildingFilter.get(i).getSalePrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.House":
                    if (((House) buildingFilter.get(i)).getHasHouseYard() == hasHouseYard && person.getMoneyAvailable() > buildingFilter.get(i).getSalePrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Office":
                    if (((Office)buildingFilter.get(i)).getUniqueOffice() == hasMultiOffice && person.getMoneyAvailable() > buildingFilter.get(i).getSalePrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Premises":
                    if (((Premises)buildingFilter.get(i)).getIndustriesType() == isIndustryPremises && person.getMoneyAvailable() > buildingFilter.get(i).getSalePrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                default:
                    throw new InvalidOptionException();
            }
        }
        if (availableForYou.getElementAt(0) == null) {
            throw new NullBuildingException();
        }
    }

    public static void showAvailableRentingPropertiesList(LinkedList<Building> building, CustomLinkedlist<Building> availableForYou, Customer person) throws InvalidOptionException {

        LinkedList<Building> buildingFilter = new LinkedList<>(building.stream().filter(building1 -> (building1.getClass().toString().equals(buildingClass))).collect(Collectors.toList()));

        for (int i=0; i < buildingFilter.size(); i++) {

            switch (buildingFilter.get(i).getClass().toString()) {
                case "class com.solvd.realstateagency.building.Apartment":
                    if (((Apartment)buildingFilter.get(i)).getUniqueRoom() == hasUniqueRoom && person.getSalary() * 0.5 > buildingFilter.get(i).getRentPrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.House":
                    if (((House)buildingFilter.get(i)).getHasHouseYard() == hasHouseYard && person.getSalary() * 0.5 > buildingFilter.get(i).getRentPrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Office":
                    if (((Office)buildingFilter.get(i)).getUniqueOffice() == hasMultiOffice && person.getSalary() * 0.5 > buildingFilter.get(i).getRentPrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                case "class com.solvd.realstateagency.building.Premises":
                    if (((Premises)buildingFilter.get(i)).getIndustriesType() == isIndustryPremises && person.getSalary() * 0.5 > buildingFilter.get(i).getRentPrice()) {
                        availableForYou.addElement(buildingFilter.get(i));
                    }
                    break;
                default:
                    throw new InvalidOptionException();
            }
        } if (availableForYou.getElementAt(0) == null) {
            throw new NullBuildingException();
        }
    }
}
