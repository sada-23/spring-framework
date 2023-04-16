package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 🦋 Template Engine
 * • A template engine is a dependency that allows us to easily get and display in the view variable data that the controller sends.
 * • Spring supports many view templates: • JSP (Java Server Pages)  • Thymeleaf  • Groovy  • Jade
 *
 * 🦋 Model
 * • The model is a container for application data.
 * • In controller, any data can be added (strings, objects, from database, etc...)
 * • View page can access data from model.
 *
 * Model Interface:
 * · Model addAllAttributes(Collection<?> attributeValues) - It copies all the attributes in the provided collection into this Map.
 * · Model addAllAttributes(Map<String, ?> attributes) - It copies all the attributes in the provided Map into this Map.
 * · Model addAttribute(Object attributeValue) - It adds the given attribute to this Map through a generated name
 * · Boolean containsAttribute(String attributeName) - It searches whether the model contains the attribute of the given name.
 * · Model mergeAttributes(Map<String, ?> attributes) - It copies all the attributes in the given Map into this Map, with the existing objects of the same name.
 *
 *
 *
 */

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name", "Company");
        model.addAttribute("course", "MVC");

        return "student/welcome"; // We don't add .html because it returns a thymeleaf template now.
    }


    @RequestMapping("/hello")
    public String homePage2(Model model){

        return "student/welcome";
    }



}
