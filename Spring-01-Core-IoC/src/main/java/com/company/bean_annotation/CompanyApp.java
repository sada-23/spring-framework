package com.company.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {

        /*
         * · Spring app (Spring-Context springframework) creates a container
         * · AnnotationConfigApplicationContext class looks for @Configuration classes that were provided in the parameter,
         *   and it will go through the @Configuration classes, finds objects with @Bean annotations, creates and stores
         *   the beans in the container
         * · getBean(); will return the bean object from the container
         *
         *
         *
         */

        // Creating container, an instance of the Spring Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();



        /*
         * @Bean(name = "p1") - if we have multiple options, we can specify a name of the bean we would like to be returned
         *                       on @Configuration class and pass it into parameter of getBean() method
         */
        //PartTimeMentor pt = container.getBean("p1",PartTimeMentor.class);// First parameter is the name of the instance to which we refer.

        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        pt.createAccount();

        String str = container.getBean(String.class);
        System.out.println(str);



    }
}
