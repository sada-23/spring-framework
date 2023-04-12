package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    /*
     * 🦋 There are 2 ways to establish the relationship between beans:
     *   · Direct Wiring : The relationship is implemented by directly calling one of the @Bean annotated methods into
     *     another @Bean annotated method. Spring creates relationships between objects.
     *   · Autowiring : Let the spring provide a value in parameters we define for the @Bean annotated method.
     *
     * 🦋 If one object (bean) already exists in the container, spring allows other objects to use the same object.
     *
     *
     */

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    // Direct Wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car()); // Direct Wiring: Calling the car() method into person method
//        return p;
//    }


    // Auto Wiring
    @Bean
    Person person(Car car){ // we provide car bean into the parameter.
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car); // Autowiring: Passing the car parameter into setCar(car) method
        return p;
    }




}
