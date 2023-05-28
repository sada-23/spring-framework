package com.company.controller;

import com.company.dto.CourseDTO;
import com.company.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * · @RequestBody: when we post something. It gets data from user and sends it to DB
 * · @RestController: @Controller + @ResponseBody.
 * · /v1 is an API version. We van create a version of the API in class level or in the application.properties
 */

@RestController // @Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;

    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);

    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }




}
