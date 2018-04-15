package org.igorr.quickstarts.helloworld.common.logging.logger;

/**
 * Created by db2inst on 07.09.16.
 */
public class MockLogger implements Log{

    public MockLogger(){

    }

    public static MockLogger getInstance(){
        return new MockLogger();
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public boolean isFatalEnabled() {
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void trace(Object var1) {
        System.out.println("trace: "+ var1);
    }

    @Override
    public void trace(Object var1, Throwable var2) {
        System.out.println("trace: "+ var1);
    }

    @Override
    public void debug(Object var1) {
        System.out.println("debug: "+ var1);
    }

    @Override
    public void debug(Object var1, Throwable var2) {
        System.out.println("debug: "+ var1);
    }

    @Override
    public void info(Object var1) {
        System.out.println("info: "+ var1);
    }

    @Override
    public void info(Object var1, Throwable var2) {
        System.out.println("info: "+ var1);
    }

    @Override
    public void warn(Object var1) {
        System.out.println("warn: "+ var1);
    }

    @Override
    public void warn(Object var1, Throwable var2) {
        System.out.println("warn: "+ var1);
    }

    @Override
    public void error(Object var1) {
        System.out.println("error: "+ var1);
    }

    @Override
    public void error(Object var1, Throwable var2) {
        System.out.println("error: "+ var1);
    }

    @Override
    public void fatal(Object var1) {
        System.out.println("fatal: "+ var1);
    }

    @Override
    public void fatal(Object var1, Throwable var2) {
        System.out.println("fatal: "+ var1);
    }


}
