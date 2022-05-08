package com.solvd.realstateagency.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionQueue {
    private static Queue<String> queue = new LinkedList<>();
    private static final Logger LOGGER = LogManager.getLogger(TransactionQueue.class);

    public static void storeTransactionOrder(String buildingAddress) {
        queue.add(buildingAddress);
    }

    public static void getTransactionOrderStored() {
        for (int i=0; i < queue.size(); i++) {
            LOGGER.info(queue.poll()+"\n");
        }
    }

}
