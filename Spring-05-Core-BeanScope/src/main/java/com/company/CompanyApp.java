package com.company;

import com.company.config.ProjectConfig;
import com.company.model.Comment;
import com.company.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("John");
        comment.setText("Spring Framework");


        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class); // container initializes
        /*
         * 🦋 Singleton:
         * · Singleton scope is default in Spring. Both objects' locations are the same.
         * · When we call beans more than one time and want to get a different object each time, we can go to the bean
         *   class, and we can use @Scope("prototype") annotation. Then it will return different objects.
         *
         */


//        CommentService cs1 = context.getBean(CommentService.class);
//        CommentService cs2 = context.getBean(CommentService.class);
//
//        System.out.println(cs1); // Object 1  - com.cvs.service.CommentService@51c668e3
//        System.out.println(cs2); // Object 2  - com.cvs.service.CommentService@51c668e3
//        System.out.println(cs1==cs2);// true - But if we apply @Scope("prototype") annotation it will return false

    }
}