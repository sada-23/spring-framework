package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *
 * 🦋 Spring MVC Architecture: Model, View, Controller
 * • The client sends an HTTP request to the web server.
 * • The dispatcher servlet uses the handler mapping to find out what controller action to call.
 * • The dispatcher servlet calls the controller’s action.
 * • After executing the action associated with the HTTP request, the controller returns the view name (and data to view)
 *   the dispatcher servlet needs to render into the HTTP response.
 * • The response sent back to the client.
 *
 *
 * • @Controller annotation indicates that the annotated class is controller.
 * • The controller actions are methods associated with specific HTTP requests.
 * • It is specialization of @Component and is autodetected through classpath scanning.
 * • It is typically used in combination with annotated handler methods based on the @RequestMapping annotation.
 *
 * • @RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
 * • It can be applied to class level and/or method level.
 *
 *
 * · Ex: When we send a request to the http://localhost:8080/home in browser, the dispatcher server will look for all the
 *   classes that are annotated with @Controller annotation and then go inside the class to find a method that is annotated
 *   with @RequestMapping("/home")
 *
 */
@Controller //Annotate the class with the @Controller stereotype annotation
public class HomeController {

    @RequestMapping("/home") // - Use @RequestMapping annotation to associate the action with an HTTP request path
    public String home(){
        return "home.html"; // - Return the HTML document name that contains the details we want the browser to display
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }

    // - If we don't provide an endpoint, it takes the default option @RequestMapping("/"), which is one slash
    @RequestMapping
    public String home3(){
        return "welcome.html";
    }

}
