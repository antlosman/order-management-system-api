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
    CommandLineRunner commandLineRunner(
            CustomerRepository customerRepository,
            ProductRepository productRepository,
            OrderLineRepository orderLineRepository) {
        return args -> {

//            orderLineRepository.findById(2L).ifPresent(System.out::println);
//            productRepository.findById(4L).ifPresent(System.out::println);



//            Scanner scanner = new Scanner(System.in);
//
//
//            System.out.println("Make you choice!");
//            System.out.println("1 - create a new customer");
//            System.out.println("2 - create a new product");
//            System.out.println("3 - create a new order line");
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1" -> {
//                    Customer customer = new Customer().createNewCustomer(scanner);
//                    customerRepository.save(customer);
//                }
//                case "2" -> {
//                    Product product = new Product().createNewProduct(scanner);
//                    productRepository.save(product);
//                }
//                case "3" -> {
//                    OrderLine orderLine = new OrderLine().createNewOrderLine(scanner);
//                    orderLineRepository.save(orderLine);
//
//                }
//            }


        };



    }
}
