package com.company.controller;


import com.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * · When the method has the same endpoint as the other methods in the controllers, bring the @RequestMapping("")
 *   annotation to class level and name it with the unique name. So it will be /mentor/list instead of "list".
 * · Ex: We have the same @RequestMapping("/list") annotated methods in MentorController and AnotherController classes.
 *   We can add @RequestMapping("/mentor") and @RequestMapping("/another") annotations at class level so this way we can
 *   change the end point to avoid, getting an exception. Class level endpoint will be concatenated with method level endpoint
 *
 *
 * · src/main/resources/static - if the view is static Spring will look into static package
 * · src/main/resources/templates - if the view is dynamic Spring will look into templates package
 *
 */

@Controller
@RequestMapping("/mentor")
public class MentorController$ {

    @RequestMapping("/list") // http://localhost:8080/mentor/list
    public String showTable(Model model){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Anna", "Sandwich", 35, "Female"));
        mentorList.add(new Mentor("John", "Davis", 30, "Male"));
        mentorList.add(new Mentor("Ellen", "River", 33, "Female"));
        mentorList.add(new Mentor("Jessica", "Forest", 50, "Female"));

        model.addAttribute("mentors", mentorList);



        return "mentor/mentor-list"; // it returns the view.
    }
}
