package com.ailbb.aws.aop;

import com.ailbb.ajj.$;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

 
@Component
@Aspect //该注解标示该类为切面类
public class AilbbAop {
    //标注该方法体为前置通知，当目标方法执行成功后执行该方法体
    @Before(value="execution(* com.ailbb.aws..*.*(..)) && @annotation(aot)")
    public void authority(JoinPoint jp, AilbbAopType aot) throws Exception {
        $.info("AOP前置通知。");
	}

    //标注该方法体为后置通知，当目标方法执行成功后执行该方法体
    @AfterReturning(value="execution(* com.ailbb.aws..*.*(..)) && @annotation(aot)")
    public void addLogSuccess(JoinPoint jp, AilbbAopType aot){
        $.info("AOP后置通知。");
	}

    //标注该方法体为异常通知，当目标方法出现异常时，执行该方法体   
	@AfterThrowing(pointcut="within(com.ailbb.aws..*) && @annotation(aot)", throwing="ex")
    public void addLogException(JoinPoint jp, AilbbAopType aot, Exception ex) {
        $.info("AOP异常通知。");
	}
}