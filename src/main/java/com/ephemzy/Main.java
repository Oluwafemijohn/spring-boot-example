package com.ephemzy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// This annotation stands for @Configuration, @EnableAutoConfiguration, @ComponentScan
// @Configuration: This annotation tells Spring that this class contains one or more
// @Bean methods and may be processed by the Spring container to generate
// bean definitions and service requests for those beans at runtime.
// @EnableAutoConfiguration: This annotation tells Spring Boot to start adding beans
// based on classpath settings, other beans, and various property settings.
// Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it
// automatically when it sees spring-webmvc on the classpath. This flags the application
// as a web application and activates key behaviors such as setting up a DispatcherServlet.
// @ComponentScan: This annotation tells Spring to look for other components, configurations,
// and services in the com/example package, letting it find the controllers.
@SpringBootApplication
@RestController
//In order to  make a class a controller, we need to add the @RestController annotation
public class Main {
    // What is tomcat
    //
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @GetMapping("/greet")
//    public String greets(){
//        return "Hello World";
//    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        var response = new GreetResponse(
                "Hello World femi"
                , List.of("Java", "Kotlin", "JavaScript", "Python", "PHP", "Swift")
                , new Person("Femi", "femi@gmail.com", 23, 100_000)
        );
        return response;
    }

    record GreetResponse(
            String greet,
            List<String> progLanguages,
            Person person
    ) { }
    record Person(
            String name,
            String email,
            int age,
            double savings
    ) { }
}
