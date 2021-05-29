package com.onlyabhinav.cowinslots.jobs;

import com.onlyabhinav.cowinslots.models.SlotStatus;
import com.onlyabhinav.cowinslots.models.URLObj;
import com.onlyabhinav.cowinslots.service.CowinSlotCheckService;
import com.onlyabhinav.cowinslots.utils.SoundUtil;
import com.onlyabhinav.cowinslots.utils.URLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartJob {

    private static Logger logger = LoggerFactory.getLogger(StartJob.class);

    public static final Integer long_delay = 1000 * 60;
    public static final Integer short_delay = 1000 * 5;

    @Autowired
    public CowinSlotCheckService vaccineService;

    @Autowired
    SoundUtil soundUtil;

    @Autowired
    private URLHelper urlHelper;

    @Scheduled(fixedDelay = 1000 * 5)
    public void timedTask() {

        URLObj urlObj = urlHelper.getNextURL();

        String urlDynamic = urlObj.getUrl() + "&t=" + System.currentTimeMillis();

        logger.info(" --- Checking Slots for URL = {} --- ", urlDynamic);

        List<SlotStatus> availableStatuses = vaccineService.isAvailable(urlDynamic);

        if (availableStatuses.size() > 0) {
            logger.info("{} Slots Found in City {}", availableStatuses.size(), availableStatuses.get(0).getCenter().district_name);

            for (SlotStatus status : availableStatuses) {
                String centreInfo = String.format("PIN=[%6d], [%30s] || [%20s]",
                        status.getCenter().pincode,
                        status.getCenter().name,
                        status.getCenter().address);

                logger.info("Slot  Date::{}, Slots::{}, Centre::{},",
                        status.getSession().date,
                        status.getSession().available_capacity,
                        centreInfo);
            }

            soundUtil.playSound();
        }
        availableStatuses = null;

    }

}
