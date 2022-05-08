package com.solvd.realstateagency.deadblock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgencyThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(AgencyThread.class);
    private Object obj1;
    private Object obj2;

    public AgencyThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2) {
            try {
                LOGGER.info("The agency want to sell a property, waiting for the customer.");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1) {
                LOGGER.info("The agency sold the property to the agency.");
            }
        }
    }
}
