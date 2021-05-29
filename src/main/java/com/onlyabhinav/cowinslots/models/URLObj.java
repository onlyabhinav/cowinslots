package com.onlyabhinav.cowinslots.models;

import com.onlyabhinav.cowinslots.utils.URLHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class URLObj {

    private static Logger logger = LoggerFactory.getLogger(URLObj.class);


    int sequence = 0;
    String url;
    Boolean checked = Boolean.FALSE;

    public URLObj(String url) {
        logger.info("Adding URL Object={}", url);
        this.url = url;
    }

}
