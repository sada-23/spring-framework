package com.company.service;
import com.company.model.Comment;
import com.company.proxy.CommentNotificationProxy;
import com.company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 *
 * 🦋 Bean Scopes:
 * · In Spring, the scope of beans defines how the framework manages the object instances.
 *      · Spring bean scopes: · Singleton · Prototype
 *
 * ✦ Singleton:
 * · Singleton scope is default in Spring. It called singleton, because you always get the same instance when you refer to a specific bean.
 * · When we call beans more than one time and want to get a different object each time, we can go to the bean
 *   class, and we can use @Scope("prototype") annotation. Then it will return different objects.
 *
 * ✦ Prototype:
 * · It is called prototype, because every time you request a reference to a prototype-scoped bean, Spring creates a new object's instance.
 * · For prototype beans, Spring does not create and manage an object's instance directly. The framework manages the
 *   object’s type and creates a new instance every time someone requests a reference to the bean.
 * · We should use @Scope() annotation to change the bean’s scope. A new instance will be created each time we refer to it.
 *
 * 🦋 Eager and Lazy Instantiation
 * · When a container initializes (created), ALL Singleton BEANS are created automatically. It is DEFAULT behavior and called “eager instantiation”.
 * · We can use @Lazy annotation to prevent that. @Lazy will prevent creation of the beans until we refer to them.
 *
 *
 *
 */

@Scope("prototype")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy
@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    @Autowired
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("Hello"); // Test: When a container initializes, we will see "Hello" on the console if the @Lazy annotation is not used.
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
