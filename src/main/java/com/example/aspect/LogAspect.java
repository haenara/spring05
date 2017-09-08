package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.apachecommons.CommonsLog;

@Component
@Aspect
@CommonsLog
public class LogAspect {

   // expression.... within()... > weaving..
   @Before("within(com.example.dao.CountryDao)")
   public void beforeAdvice(JoinPoint jp) {
      log.info("@Before" + jp.getSignature());   //어떤 메서드가 실행되었는가?
      
   }
   
   @After("within(com.example.dao.CountryDao)")
   public void afterAdvice(JoinPoint jp) {
      log.info("@After" + jp.getSignature());   // 어떤 메서드가 실행되었는가?
   }
   
}