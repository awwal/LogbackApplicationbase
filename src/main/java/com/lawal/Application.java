package com.lawal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Application {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws InterruptedException {

        int count = 0;
        while (true) {

            LOG.trace("This is a trace");
            LOG.debug("This is a debug");
            LOG.info("This is an info " + count);
            LOG.warn("This is a warning");
            LOG.error("This is an error");

            count++;
            if (count % 15 == 0) {
                try {
                    throwAnException();
                } catch (Exception e) {
                    LOG.error("thrown ", e);
                }
            }

            TimeUnit.SECONDS.sleep(1);

        }


    }

    private static void throwAnException() {
        String s = null;
        int length = s.length();
    }
}
