package com.ordersystem.ordermanagementsystemapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class OrderManagementSystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementSystemApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            Scanner scanner = new Scanner(System.in);


            System.out.println("Make you choice!");
            System.out.println("1 - create a new customer");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    Customer customer = new Customer().createNewCustomer(scanner);
                    customerRepository.save(customer);
                }
            }





        };



    }
}
