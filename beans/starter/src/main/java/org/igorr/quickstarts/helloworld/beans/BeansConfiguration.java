package org.igorr.quickstarts.helloworld.beans;

import org.igorr.quickstarts.helloworld.beans.services.starter.CommandManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
//@ComponentScan(basePackages = "org.igorr.quickstarts.helloworld.beans")
@Import(AnotherConfiguration.class)
public class BeansConfiguration {

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager с
        // с новым объектом Command
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }

//    @Bean
//    BeanWithDependency beanWithDependency() {
//        return new BeanWithDependency(greetingService());
//    }

//    @Bean
//    GreetingService greetingService() {
//        return new GreetingServiceImpl();
//    }

//    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//    @Description("Текстовое описание бина greetingService")
//    GreetingService greetingService() {
//        return new GreetingServiceImpl();
//    }

//    @Bean(name = {"gServiceName", "gServiceAnotherNamed"})
//    @Scope("prototype")
//    GreetingService gService() {
//        return new GreetingServiceImpl();
//    }
}

