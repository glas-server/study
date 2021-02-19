package com.github.hoilayloi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * author halab
 */
@Aspect
@Component
public class AspectClass {

//    @Before("execution(* com.github.hoilayloi.filter.**.*(..))")
//    public void logMethodName(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName);
//    }
//
//    @AfterReturning(value = "execution(* com.github.hoilayloi.filter.**.*(..))", returning = "methodResult")
//    public void logMethodArgAndResult(JoinPoint joinPoint, Object methodResult) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("[ASPECT CLASS - AFTER RETURNING] Method Arguments: " + Arrays.asList(args));
//        System.out.println("[ASPECT CLASS - AFTER RETURNING] Method Result: " + methodResult);
//    }
//
//    @AfterThrowing(value = "execution(* com.github.hoilayloi.filter.**.*(..))", throwing = "ex")
//    public void logException(JoinPoint joinPoint, Exception ex) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("[ASPECT CLASS - AFTER THROWING] Exception when run method: " + className + "." + methodName);
//        System.out.println("[ASPECT CLASS - AFTER THROWING] Exception: " + ex.getMessage());
////        for(StackTraceElement element: ex.getStackTrace()) {
////            System.out.println("[ASPECT CLASS - AFTER THROWING] Exception: " + element.toString());
////        }
//    }
//
//    @After("execution(* com.github.hoilayloi.filter.**.*(..))")
//    public void logAfterMethodDone(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("[ASPECT CLASS - AFTER FINAL] Method execute done: " + className + "." + methodName);
//    }
//
//    @Around("execution(* com.github.hoilayloi.filter.**.*(..))")
//    public Object logExecuteTimeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object object = joinPoint.proceed();
//        long end = System.currentTimeMillis();
//        System.out.println("[ASPECT CLASS - AROUND] Process time: " + (end - start));
//        return object;
//    }



//    @Before("execution(* com.github.hoilayloi.filter.**.*(..))")
//    public void logMethodNameWithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName);
//    }

//    @Before("execution(* com.github.hoilayloi.filter.StringFilter.*(..))")
//    public void logExactlyMethodNameWithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName);
//    }

//    @Before("execution(* com.github.hoilayloi.filter.StringFilter.filter(java.util.Collection))")
//    public void logExactlyMethodNameAndArguments2WithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName + "with " + args.length + " arguments");
//    }
//
//    @Before("execution(* com.github.hoilayloi.filter.StringFilter.filter(java.util.Collection,java.util.function.Predicate))")
//    public void logExactlyMethodNameAndArguments1WithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName + "with " + args.length + " arguments");
//    }

//    @Before("within(com.github.hoilayloi.filter.StringFilter)")
//    public void logExactlyClassNameWithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName + "with " + args.length + " arguments");
//    }

//    @Before("within(com.github.hoilayloi.filter.CollectionFilter)")
//    @Before("target(com.github.hoilayloi.filter.CollectionFilter)")
//    public void logExactlyClassNameWithExecutionPointcutDesignator(JoinPoint joinPoint) {
//        String className = joinPoint.getSignature().getDeclaringType().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("[ASPECT CLASS - BEFORE] Before running method: " + className + "." + methodName + "with " + args.length + " arguments");
//    }

//    @Around("@annotation(ExecuteTimeLogged)")
//    public Object logExactlyMethodArgumentsWithArgsPointcutDesignator(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object object = joinPoint.proceed();
//        long end = System.currentTimeMillis();
//        System.out.println("[ASPECT CLASS - AROUND] Process time: " + (end - start));
//        return object;
//    }
}
