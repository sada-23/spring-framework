package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.Config.ConfigApp;
import stereotype_annotations.Model.DataStructure;
import stereotype_annotations.Model.Microservice;

public class PracticeApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        DataStructure dataStructure = context.getBean(DataStructure.class);
        dataStructure.getHours();

        Microservice microservice = context.getBean(Microservice.class);
        microservice.getHours();



    }
}
