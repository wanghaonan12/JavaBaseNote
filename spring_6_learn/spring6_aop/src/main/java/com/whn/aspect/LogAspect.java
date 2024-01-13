package com.whn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Wanghn
 * @date 2024/1/11 10:10
 */
// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LogAspect {


    /**
     * 参数说明：
     * execution：固定格式
     * public double： 匹配的 权限修饰符 返回值类型 可以使用 * 表示任意权限修饰符和返回值类型
     * com.whn.service.impl.ConsumerImpl：全类名
     * calculate：方法名 可以使用 * 表示任意方法名
     * (double, double)：列表参数 可以使用 (..) 表示任意参数列表
     * @param joinPoint
     */

    @Before("execution(public double com.whn.service.impl.ConsumerImpl.calculate(double, double))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
    }

    /**
     * 声明重用切入点
     */
    @Pointcut("execution(* com.whn.service.impl.ConsumerImpl.*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName);
    }

    /**
     * 使用@AfterReturning中的属性returning，用来将通知方法的某个形参，接收目标方法的返回值
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* com.whn.service.impl.ConsumerImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }

    /**
     * 使用@AfterThrowing中的属性throwing，用来将通知方法的某个形参，接收目标方法的异常
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.whn.service.impl.ConsumerImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }

    /**
     * 使用@Around注解标识，使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.whn.service.impl.ConsumerImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");
            //目标对象（连接点）方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }

}
