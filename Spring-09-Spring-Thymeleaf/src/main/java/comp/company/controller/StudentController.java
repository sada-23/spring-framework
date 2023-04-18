package comp.company.controller;

import comp.company.model.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *
 * 🦋 Request Mapping Annotation
 * • Spring 4.3 introduced five new and more specific annotations for each HTTP request type
 *    • @GetMapping • @PostMapping • @PutMapping • @DeleteMapping • @PatchMapping
 *
 * · Before Spring 4.3, the method type should be provided inside the method parameters.
 *    · Ex: @RequestMapping(value = "/register", method = RequestMethod.GET)
 *
 *
 */

@Controller
@RequestMapping("/student")
public class StudentController {

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public  String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());


        return "student/register";
    }

//    @RequestMapping("/welcome")
    @GetMapping("/welcome")
    public String info(){
        return "student/welcome";
    }

}
