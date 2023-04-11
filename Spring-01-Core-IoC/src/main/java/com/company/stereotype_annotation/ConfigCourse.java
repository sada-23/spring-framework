package com.company.stereotype_annotation;


/*
 * · When application starts Spring will look for:
 *    1. @Configuration annotated classes that provided in the AnnotationConfigApplicationContext(ConfigCourse.class)
 *    2. @ComponentScan annotation in the Configuration Classes
 *    3. @Component annotated classes belong to the package, then will create the beans
 *
 *
 * · @Configuration - When the application starts Spring will check @Configuration classes first
 * · @ComponentScan - Scan all the classes annotated with @Component annotations belong to the package
 * · @ComponentScan(basePackages = "com.company") - Scan all the @Component belong to "com.company" package
 * · @Component - Beans will be created from @Component annotated classes
 *
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class ConfigCourse {


}
