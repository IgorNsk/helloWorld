package org.igorr.quickstarts.helloworld.beans.services.starter;

public class BeanWithDependency {

    private static final String SOME_TEXT = "Some text";

    public BeanWithDependency() {
        //
    }

    public BeanWithDependency(GreetingService greetingService) { /* что-то делаем*/ }

    public String printText() { return SOME_TEXT;}
}
