package stereotype_annotations.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ExtraHours {

    int getHours(){
        return 10;
    }
}
