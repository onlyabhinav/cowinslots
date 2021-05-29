package com.onlyabhinav.cowinslots;

import com.onlyabhinav.cowinslots.configs.AppConfig;
import com.onlyabhinav.cowinslots.jobs.StartJob;
import com.onlyabhinav.cowinslots.utils.WindowsNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CowinslotsApplication {
    private static Logger logger = LoggerFactory.getLogger(CowinslotsApplication.class);

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(CowinslotsApplication.class, args);

        // WindowsNotification.notifyWithMessage("Application Started.");

        logger.info("Application Started.. ");



/*        while(1==1){
            logger.info("Keep running");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }

}
