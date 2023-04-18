package comp.company.controller;

import comp.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/*
 *
 * How to Retrieve Object Properties?
 * · When the form is loaded, Spring MVC will call getter methods.
 * · When the form is submitted, Spring MVC will call setter methods.
 *
 */

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @GetMapping("/register")
    public String showForm(Model model){

        model.addAttribute("mentor", new Mentor()); // - Empty object to capture inputted data from mentor-register.html view

        List<String> batchList = Arrays.asList("JD1", "JD2", "JD3", "JD4", "JD5", "JD6", "JD7");
        model.addAttribute("batchList", batchList);

        return "mentor/mentor-register";
    }

    /*
     *
     * · @ModelAttribute("attributeName") -> we pass name of the attribute that we like capture.
     *    Ex: @ModelAttribute("mentor") Mentor mentor -> we bring the mentor object from @GetMapping("register") annotated method.
     * · With this post method with submit the form and capturing the data
     *
     * · return "redirect:/mentor/register"; -> Data will be posted, but it will come back in an empty form. We redirect from one endpoint to another
     */
    @PostMapping("/confirm")
    public String showForm2( @ModelAttribute("mentor") Mentor mentor, Model model){

        System.out.println(mentor.toString());

        return "mentor/mentor-confirmation";
//        return "redirect:/mentor/register";
    }




}
