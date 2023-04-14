package stereotype_annotations.Model;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Microservice {

    public void getHours(){
        System.out.println("Total Hours: " + 40);
    }

}
