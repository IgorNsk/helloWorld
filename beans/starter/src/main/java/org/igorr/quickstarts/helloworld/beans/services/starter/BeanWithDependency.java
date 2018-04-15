package org.igorr.quickstarts.helloworld.beans.services.starter;

public class BeanWithDependency {
    public BeanWithDependency() {
    }

    public BeanWithDependency(GreetingService greetingService) { /* что-то делаем*/ }

    public String printText() { return "Some text";}
}
