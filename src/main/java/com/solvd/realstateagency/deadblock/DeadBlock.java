package com.solvd.realstateagency.deadblock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadBlock {
    private static final Logger LOGGER = LogManager.getLogger(DeadBlock.class);

    public static void main(String[] args){
        Object obj1 = new Object();
        Object obj2 = new Object();

        AgencyThread deadThread1 = new AgencyThread(obj1, obj2);
        deadThread1.start();
        CustomerThread deadThread2 = new CustomerThread(obj1, obj2);
        deadThread2.start();
    }
}
