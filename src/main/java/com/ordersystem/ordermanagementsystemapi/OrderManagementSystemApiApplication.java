package com.ordersystem.ordermanagementsystemapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderManagementSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementSystemApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer maria = new Customer("Maria Jones", "maria@gmail.com", "655655");
            customerRepository.save(maria);
        };
    }

}
