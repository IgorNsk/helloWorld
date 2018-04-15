package org.igorr.quickstarts.helloworld.common.logging.logger;

/**
 * Created by db2inst on 10.09.16.
 */
public abstract class LogFactory {


    protected LogFactory(){

    }

    public abstract Log getInstance(Class var1);

    public static Log getLog(Class clazz) {
        return MockLogger.getInstance();
    }

}
