package com.company.controller;

import com.company.annotation.Loggable;
import com.company.dto.CourseDTO;
import com.company.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

//    Logger logger = LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {

        // logger is get the info from our Business logic

//        logger.info("Before -> Controller: {} - Method {} "," CourseController","getCourses()"); // curly braces is mandatory
        List<CourseDTO> list = courseService.getCourses();
//        logger.info("After -> Controller: {} - Method : {} - Output : {}"," CourseController","getCourses()", list.toString());
        return list;
    }

    @Loggable
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category)       ;
    }

    @Loggable
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId) {
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses() {
        courseService.deleteCourses();
    }

}
