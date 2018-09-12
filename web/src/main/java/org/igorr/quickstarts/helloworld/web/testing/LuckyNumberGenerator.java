package org.igorr.quickstarts.helloworld.web.testing;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LuckyNumberGenerator {

    private static final Logger LOG = LogManager.getLogger(LuckyNumberGenerator.class);
    private static final int RESULT_ZERO = 0;


    public int getLuckyNumber(String name) {
        saveIntoDatabase(name);
        if (name == null) {
            return getDefaultLuckyNumber();
        }
        return getComputedLuckyNumber(name.length());
    }

    private int getComputedLuckyNumber(int length) {
        return length;
    }

    private int getDefaultLuckyNumber() {
        return RESULT_ZERO;
    }

    private void saveIntoDatabase(String name) {
        LOG.info("saveIntoDatabase: " + name);
    }


}
