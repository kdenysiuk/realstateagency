package com.solvd.realstateagency.reflection;

import com.solvd.realstateagency.main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class BuildingReflection {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void identifyBuilding (LinkedList list){
        for (Object c : list) {
            Method[] methods = c.getClass().getMethods();
            for (Method m : methods) {
                if (m.getName().equals("getUniqueRoom")) {
                    try {
                        boolean chain = (boolean) m.invoke(c);
                        if (chain) {
                            LOGGER.info("This building is a unique-room apartment.");
                        } else {
                            LOGGER.info("This building is a multi-room apartment.");
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                if (m.getName().equals("getHasHouseYard")) {
                    try {
                        boolean chain = (boolean) m.invoke(c);
                        if (chain) {
                            LOGGER.info("This building is a house with a yard.");
                        } else {
                            LOGGER.info("This building is a house without a yard.");
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                if (m.getName().equals("getUniqueOffice")) {
                    try {
                        boolean chain = (boolean) m.invoke(c);
                        if (chain) {
                            LOGGER.info("This building is a unique-office place.");
                        } else {
                            LOGGER.info("This building is a multi-office place.");
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                if (m.getName().equals("getIndustriesType")) {
                    try {
                        boolean chain = (boolean) m.invoke(c);
                        if (chain) {
                            LOGGER.info("This building is a non-industry premises.");
                        } else {
                            LOGGER.info("This building is an industry premises.");
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
