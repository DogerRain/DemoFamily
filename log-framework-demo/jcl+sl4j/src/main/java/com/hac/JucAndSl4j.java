package com.hac;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JucAndSl4j {
//    java common logging
    private static final Log JUC = LogFactory.getLog(JucAndSl4j.class);
    // sl4j
    private static final Logger Sl4j = LoggerFactory.getLogger(JucAndSl4j.class);

    public static void main(String[] args) {
        JUC.info("JUC");
        Sl4j.info("Sl4j");
    }
}
