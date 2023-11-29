package com.hellocoder.log4j;

import lombok.SneakyThrows;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author huangyongwen
 * @date 2022/1/6
 * @Description 直接使用 log4j https://www.cnblogs.com/Yee-Q/p/16864734.html
 */

public class Log4jAPI {

    private static final Logger log = Logger.getLogger(Log4jAPI.class.getName() + "1111");


    @SneakyThrows
    public static void main(String[] args) {

        while (true){
            log.info("info直接使用log4j");
            log.debug("debug直接使用log4j");
            TimeUnit.MILLISECONDS.sleep(10);
        }

    }

}
