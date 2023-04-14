package stereotype_annotations.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor
public class DataStructure {

    @NonNull // we can use this with @Data annotation
//    @Autowired // field injection - (not recommended)
    ExtraHours extraHours;

//    @Autowired // dependency constructor injection
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getHours(){
        System.out.println("Total Hours: " + (20 + extraHours.getHours()) );
    }
}
