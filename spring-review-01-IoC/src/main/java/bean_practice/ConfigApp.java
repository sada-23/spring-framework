package bean_practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeEmployee fullTimeEmployee(){ // method returns the object
        return new FullTimeEmployee();
    }

    @Bean
    PartTimeEmployee partTimeEmployee(){
        return new PartTimeEmployee();
    }

}
