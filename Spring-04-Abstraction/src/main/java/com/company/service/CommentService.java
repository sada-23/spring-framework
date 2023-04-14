package com.company.service;

import com.company.model.Comment;
import com.company.proxy.CommentNotificationProxy;
import com.company.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * · Service : refers to the objects implementing use cases (business Logic).
 * · Repository : refers to the objects working directly with a database.
 * · Proxy : refers to the objects whose responsibilities are to establish communication with something outside the app.
 * · Model/Entity : refers to objects that model the data the app uses.
 *
 * · Interfaces are abstract. Never use stereotype annotations on interfaces.
 * · POJO classes not get @Component annotation because we don't use it as dependencies
 * · We need to add the object to the Spring container if it either has a dependency we need to inject from the context
 *   or if it is a dependency itself.
 *
 * · When we add dependencies to the classes, we use interfaces as dependencies. Because class has implementation, and
 *   it might change in the future but interface will not.
 * · It is good practice to declare private final dependencies because it does not change and create a constructor
 *   right away and initialize our dependencies.
 *
 */

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /*
     *
     * CommentPushNotificationProxy & EmailCommentNotificationProxy are both classes implemented from the same interface
     * · There might be 2 or more implementations, but spring will always inject one of them.
     *    1. Use the @Primary annotation to mark one of them as default.
     *    2. Use the @Qualifier annotation to name the bean and then instruct Spring to inject that bean by name.
     *       · Use @Qualifier annotation in the constructor and provide default Bean Names. Ex: @Qualifier("commentPushNotificationProxy")
     *       · Create a custom name using @Qualifier("") annotation in the respective classes and use it in the constructor. Ex: @Qualifier("EMAIL")
     *
     */

    @Autowired
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
