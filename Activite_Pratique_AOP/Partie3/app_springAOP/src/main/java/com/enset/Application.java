package com.enset;

import com.enset.service.IMetier;
import com.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        IMetier metier = context.getBean(IMetier.class);

        System.out.println("Classe injectée : " + metier.getClass().getName()); // Affichera un proxy CGLIB ou JDK

        System.out.println("\n--- Test avec le rôle USER ---");
        SecurityContext.authenticate("root", "1234", new String[]{"USER"});

        try {
            metier.process();
            metier.compute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         System.out.println("\n--- Test avec le rôle ADMIN ---");
        SecurityContext.authenticate("root", "1234", new String[]{"ADMIN", "USER"});

        try {
            metier.process();
            metier.compute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Configuration
    @ComponentScan(basePackages = {"com.enset"})
    class MyConfig{

    }
}
