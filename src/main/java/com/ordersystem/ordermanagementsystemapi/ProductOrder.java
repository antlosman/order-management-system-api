package com.ordersystem.ordermanagementsystemapi;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ProductOrder")
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_id_sequence"
    )

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "submission_date", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime submissionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "customer_registration_code",
            referencedColumnName = "registration_code",
            foreignKey = @ForeignKey(name = "customer_registration_code_fk"))

    private Customer customer;

    //**********************************************************************
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "order_line_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "order_line_id_fk")
    )
    private List<OrderLine> orderLines = new ArrayList<>();

    public void addOrderLine(OrderLine orderLine) {
        if (!orderLines.contains(orderLine)) {
            orderLines.add(orderLine);
        }
    }

    public void removeOrderLine(OrderLine orderLine) {
        if (this.orderLines.contains(orderLine)) {
            this.orderLines.remove(orderLine);
        }
    }
    //**********************************************************************


    public ProductOrder() {
    }

    public ProductOrder(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public ProductOrder(LocalDateTime submissionDate, Customer customer) {
        this.submissionDate = submissionDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", submissionDate=" + submissionDate +
                ", customer=" + customer +
                '}';
    }
}
