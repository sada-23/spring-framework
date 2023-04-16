package com.company.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
 * 🦋 Getting Data on the HTTP Request
 * · HTTP request parameter: represents a simple way to send values from client to server in a key-value pair format.
 *   They are also called query parameters.
 * · Path variable: sending data through the request path itself.
 * · HTTP request header: similarly to the request parameters, the request headers are sent through the HTTP header.
 * · The HTTP request body
 *
 * • @RequestParam annotation tells Spring it needs to get the value from the HTTP request parameter with the same
 *   name as the method’s parameter name.
 *   Ex: car/info?make=Honda - @RequestParam String make ( make is a key, and it should match in both places)
 * • A request parameter is mandatory by default. If the client does not provide a value for the request parameter,
 *   the server sends back a response with the status HTTP 400 Bad Request.
 *
 * • @PathVariable annotation is used to mark the controller’s action parameter to get the path variable’s value.
 *
 *
 */
@Controller
@RequestMapping("/car")
public class CarController$ {

    //    @RequestMapping("/info") // http://localhost:8080/car/info?make=Honda (Bringing our query param ("honda" ) from browser to java code.)
//    public String carInfo(@RequestParam String make, Model model){
//
//        model.addAttribute("make", make);
//
//        System.out.println(make);
//        return "/car/car-info";
//    }

    @RequestMapping("/info") // http://localhost:8080/car/info?make=Honda&year=2015
    public String carInfo(@RequestParam String make, @RequestParam Integer year ,Model model){

        // We're capturing the attributeName "make" and "year" which come from the browser, and we are passing them into the view.
        model.addAttribute("make", make);
        model.addAttribute("year", year);

        System.out.println(make + " " + year);
        return "/car/car-info";
    }


    /*
     *
     * 🦋 Query parameters can be optional:
     * · car/info2 -> @RequestParam(value = "make",required = false): - if no value provided it will return nothing
     * · car/info2 -> @RequestParam(value = "make",required = false,defaultValue = "Tesla"): - if no value provided will return default value ("Tesla")
     * · car/info2?make=Nissan -> @RequestParam(value = "make",required = false,defaultValue = "Tesla"): - if value provided will return value ("Nissan")
     *
     */
    @RequestMapping("/info2") // http://localhost:8080/car/info2 (Bringing our Path params from browser to java code)
    public String carInfo2(@RequestParam (value = "make", required = false, defaultValue = "Tesla") String make, Model model){

        model.addAttribute("make", make);
        System.out.println(make);
        return "/car/car-info";
    }

    /*
     * 🦋 Path Variable:
     * · car/info/Toyota -> @RequestMapping("/info/{make}")
     * · car/info/Toyota/2015 -> @@RequestMapping("/info/{make}/{year}")
     *
     * · Path Variable can NOT be optional
     *
     */
    @RequestMapping("/info/{make}/{year}") // http://localhost:8080/car/info/honda/2012
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year,  Model model){

        model.addAttribute("make", make);
        System.out.println(make + " " + year);
        return "/car/car-info";
    }





}
