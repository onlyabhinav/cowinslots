package com.onlyabhinav.cowinslots.jobs;

import com.onlyabhinav.cowinslots.models.SlotStatus;
import com.onlyabhinav.cowinslots.service.CowinSlotCheckService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        CowinSlotCheckService vaccineService = new CowinSlotCheckService();


        while (true) {
            List<SlotStatus> isAvailable = vaccineService.isAvailable("");

            if (isAvailable.size() > 0) {
                vaccineService.notifyOnMac();
                System.out.println("Available");
            }

            //calls after X minutes
            Thread.sleep(60 * 1000);
        }


    }
}
