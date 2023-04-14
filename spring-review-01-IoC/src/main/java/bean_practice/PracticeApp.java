package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeApp { // Runner
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigOther.class);

        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();



        String s1 = context.getBean("b1",String.class); // "b1" - custom bean name
        System.out.println(s1);
        String s2 = context.getBean("str2",String.class); // "str2" - default bean name
        System.out.println(s2);
    }
}
