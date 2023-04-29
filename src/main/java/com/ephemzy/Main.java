package com.ephemzy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // What is tomcat
    //
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }


    @PostMapping()
    public void addCustomer(@RequestBody  NewCustomerRequest request) {
        var customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

}
