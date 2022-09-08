package com.ordersystem.ordermanagementsystemapi;

import javax.persistence.*;
import java.util.Scanner;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Customer")
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(name = "customer_email_unique", columnNames = "email")})
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "customer_sequence")

    @Column(name = "registration_code", updatable = false)
    private Long registrationCode;
    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    @Column(name = "telephone", nullable = false, columnDefinition = "TEXT")
    private String telephone;

    public Customer(String fullName, String email, String telephone) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }

    public Customer createNewCustomer(Scanner scanner) {
        System.out.print("Type customer name: ");
        String fullName = scanner.nextLine();
        System.out.print("Type customer email: ");
        String email = scanner.nextLine();
        System.out.print("type customer telephone: ");
        String telephone = scanner.nextLine();
        return new Customer(fullName, email, telephone);
    }


    public Customer() {

    }

    public Long getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(Long registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "registrationCode=" + registrationCode +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
