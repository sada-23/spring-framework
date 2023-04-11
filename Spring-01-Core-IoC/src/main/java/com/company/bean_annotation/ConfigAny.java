package com.company.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * · Stereotype annotations (@Component, @ComponentScan) can NOT be used with the classes that we can not change.
 *   For ex: We can't edit String or Integer etc. classes, so we always follow the @Bean structure with these classes
 *
 */
@Configuration
public class ConfigAny {
    @Bean
    String str(){
        return "Developer";
    }

    @Bean
    Integer number(){
        return 100;
    }
}
