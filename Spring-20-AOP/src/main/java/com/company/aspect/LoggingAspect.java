package com.company.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import java.util.List;
/*
 * 🦋Core AOP Concepts:
 * · Aspect - Module of the code for cross-cutting concern (Logging, security). We use Aspect classes for related logic. Aspect class is not bean.
 * · Advice (When) - What action is taken and when it should be applied. @Before, @After etc.
 * · Join Point (What)- It's a particular point during execution of programs. Ex: method execution, constructor call etc.
 * · Pointcut (Where) - a predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut
 *    · Pointcut Designators:
 *        ✦ execution ✦ @within ✦ this ✦ target ✦ args ✦ @args ✦ @annotation ✦ bean(idOrNameOfBean)
 *
 */
@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


//    @Pointcut("execution(* com.company.controller.CourseController.*(..))") // All the methods inside the specified controller
//    private void pointcut(){}
//    @Before("pointcut()") // we pass the pointcut method name inside the Advice @Before annotation
//    public void log(){
//        logger.info("Logger info ------");
//    }
//
//
//
//
//    // we can create one method and combine pointcut and log methods
//    @Before("execution(* com.company.controller.CourseController.*(..))")
//    public void beforeAdvice(){
//        logger.info("Logger info ------");
//    }



//    @Pointcut("execution(* com.company.repository.CourseRepository.findById(*))")// (*) means it accept one parameter, any data type doesn't matter
//    private void anyProductRepositoryFindById(){}
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint){
//        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }





    //within - we use it when we combine two pointcuts
//    @Pointcut("within(com.company.controller..*)")
//    private void anyControllerOperation(){}
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation(){
//    }
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }



    //@annotation - is method level annotation
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation(){}
//
//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }
//



    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}
    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result") // it will return key and value of the
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }
    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }
    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception") // EX: After Throwing -> Method: CourseController.getCourseById(..) - Exception: No value present
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
    @After("anyGetCourseOperation()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
    }




    @Pointcut("@annotation(com.company.annotation.Loggable)")
    private void anyLoggableMethodOperation(){}

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before () -> Method : {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results =proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(),results.toString());
        return results;
    }

}
