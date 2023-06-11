package com.example.aoptest.AOPtest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// MethodInterceptor를 이용한 프록시 구현
// MethodInterceptor :  프록시 객체의 콜백 기능 중 하나
public class MyAspect implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object target = null;

        System.out.println("와 출근을 했넹.");

        try {
            target = invocation.proceed();
        } catch(Exception e) {
            System.out.println("야호 야근이다");
        } finally {
            System.out.println("야호 칼퇴다");
        }

        return target;
    }
}
