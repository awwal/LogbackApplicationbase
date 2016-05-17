package com.lawal;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.FileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


public class Application {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws InterruptedException {
        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
        for (ch.qos.logback.classic.Logger logger : context.getLoggerList()) {


            for (Iterator<Appender<ILoggingEvent>> index = logger.iteratorForAppenders(); index.hasNext();) {
                Appender<ILoggingEvent> appender = index.next();
                if (appender instanceof FileAppender) {
                    FileAppender fileAppender=(FileAppender<?>)appender;
                    System.out.println(new File(fileAppender.getFile()).getAbsolutePath());
                }
            }
        }


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
