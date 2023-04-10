package com.company.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
 * · @Primary -> is a Default choice of the Spring. Spring will choose primary if there are multiple options, and we do
 *             not need to  specify a name such as @Bean(name = "p1")
 * · @Bean(name = "p1") - if we have multiple options, we also can use name the @Bean and pass it in App class:
 *                        Fox ex: PartTimeMentor pt = container.getBean("p1",PartTimeMentor.class);
 */
@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){ // will return instance of the FullTimeMentor class
        return new FullTimeMentor();
    }

    //    @Bean(name = "p1")
    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }

    //    @Bean(name = "p2")
    @Bean
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }

}
