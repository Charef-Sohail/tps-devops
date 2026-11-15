package com.enset;

import com.enset.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {"com.enset"})
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        IMetier metier = context.getBean(IMetier.class);

        System.out.println("Classe injectée : " + metier.getClass().getName()); // Affichera un proxy CGLIB ou JDK

        metier.process();
        System.out.println(metier.compute());
    }
}
