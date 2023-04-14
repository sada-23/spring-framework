package bean_practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigOther {
    @Bean(name = "b1") // custom bean name
    String str1(){
        return "Welcome to world";
    }


//    @Primary
//    @Bean(name = "b2")
    @Bean // default bean name - str2
    String str2(){
        return "Spring Core Practice";
    }
}
