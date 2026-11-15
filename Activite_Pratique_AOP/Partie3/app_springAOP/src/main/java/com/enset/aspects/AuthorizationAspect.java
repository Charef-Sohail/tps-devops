package com.enset.aspects;

import com.enset.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Around(value = "@annotation(securedByAspect)", argNames = "joinPoint, securedByAspect")
    public Object secure(ProceedingJoinPoint joinPoint, SecuredByAspect securedByAspect) throws Throwable {
        String[] requiredRoles = securedByAspect.roles();
        boolean authorized = false;

        for (String role : requiredRoles) {
            if (SecurityContext.hasRole(role)) {
                authorized = true;
                break;
            }
        }

        if (authorized) {
            return joinPoint.proceed();
        } else {
            throw new RuntimeException("403 FORBIDDEN : Vous n'avez pas le rôle requis pour " + joinPoint.getSignature().getName());
        }
    }
}
