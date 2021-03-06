package org.igorr.quickstarts.helloworld.beans;

import org.igorr.quickstarts.helloworld.beans.services.messages.MessageService;
import org.igorr.quickstarts.helloworld.beans.services.starter.BeanWithDependency;
import org.igorr.quickstarts.helloworld.beans.services.starter.GreetingService;
import org.igorr.quickstarts.helloworld.beans.services.util.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.igorr.quickstarts.helloworld.beans.services")
public class AnotherConfiguration {

    @Autowired
    GreetingService greetingService;

    @Autowired
    MessageService showService;

//    @Bean(name={"foo"})
//    public ApiService fooApi(){
//        return new FooApiServiceImpl();
//    }

    @Autowired
    @Qualifier("foo")
    ApiService fooApi;

    @Autowired
    @Qualifier("bar")
    ApiService barApi;

    @Bean
    BeanWithDependency beanWithDependency() {
        // bla-bla-bla
        return new BeanWithDependency();
    }
}
