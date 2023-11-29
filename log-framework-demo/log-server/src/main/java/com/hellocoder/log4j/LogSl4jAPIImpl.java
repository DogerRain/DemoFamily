package com.hellocoder.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hac.Log4jCoexistLog4j2;

/**
 * @author huangyongwen
 * @date 2022/1/12
 * @Description
 */
public class LogSl4jAPIImpl {

    private static final Logger log = LoggerFactory.getLogger(LogSl4jAPIImpl.class);

    public static void main(String[] ars) {
        Log4jCoexistLog4j2 logSl4jAPI = new Log4jCoexistLog4j2();
        logSl4jAPI.main(null);

        log.info("SL4j 结合");

    }
}
