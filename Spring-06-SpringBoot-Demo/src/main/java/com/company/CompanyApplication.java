package com.company;

import com.company.model.Comment;
import com.company.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * · @SpringBootApplication is a composite of:
 *     · @SpringBootConfiguration
 *     · @Configuration
 *     · @EnableAutoConfiguration
 *     · @ComponentScan
 *     · @Component
 *
 */

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {


        Comment comment = new Comment();
        comment.setAuthor("John");
        comment.setText("Spring Framework");

         ApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
//        SpringApplication.run(CompanyApplication.class, args); // creates the container

        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);




    }

}
