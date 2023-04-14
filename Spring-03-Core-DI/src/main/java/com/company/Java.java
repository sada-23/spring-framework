package com.company;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *
 * · Dependency Injection is a fundamental aspect of the Spring framework, where the Spring container "injects"
 * objects into other objects or “dependencies”.
 * · DI is an application of the IoC principle. The IoC principle implies that the framework controls the application in execution.
 * · Starting with Spring version 4.3, when there is only one constructor in the class, @Autowired annotation can be omitted.
 *
 * · @Autowired : Spring container "injects" objects into other objects or “dependencies”
 *       · Constructor Injection: Injecting the values through the constructor
 *       · Field Injection (Not recommended): Injecting one object to another object
 *
 */

@Component
@AllArgsConstructor
public class Java {

    OfficeHours officeHours; // OfficeHours dependency

//    //  1. Field Injection (Not recommended)
//    @Autowired // -> Spring Inject (wiring) OfficeHours object to Java object
//    OfficeHours officeHours;


//    // 2. Constructor Injection
//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : " + (20 + officeHours.getHours()));
    }
}
