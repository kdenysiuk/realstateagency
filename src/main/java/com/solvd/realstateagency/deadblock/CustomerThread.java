package com.solvd.realstateagency.deadblock;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(CustomerThread.class);
    private Object obj1;
    private Object obj2;

    public CustomerThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1) {
            try {
                LOGGER.info("The customer want to buy a property, waiting for the agency.");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                LOGGER.info("The costumer bought the property from the agency.");
            }
        }
    }

}
