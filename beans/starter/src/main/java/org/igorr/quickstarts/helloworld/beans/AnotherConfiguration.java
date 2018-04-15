package org.igorr.quickstarts.helloworld.beans;

import org.igorr.quickstarts.helloworld.beans.services.starter.BeanWithDependency;
import org.igorr.quickstarts.helloworld.beans.services.starter.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfiguration {

    @Autowired
    GreetingService greetingService;

    @Bean
    BeanWithDependency beanWithDependency() {
        return new BeanWithDependency();
    }
}
