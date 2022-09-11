package com.ordersystem.ordermanagementsystemapi;


import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "OrderLine")
@Table(name = "order_line")
public class OrderLine {

    @Id
    @SequenceGenerator(name = "order_line_sequence", sequenceName = "order_line_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "order_line_sequence")

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "product_id_fk"))
    private Product product;



    // TODO: 09.09.2022 instead of creating a new Product possibility to add a Product from DB
    public OrderLine createNewOrderLine(Scanner scanner) {
        Product product = new Product().createNewProduct(scanner);
        System.out.print("Type order line quantity: ");
        int quantity = scanner.nextInt();
        return new OrderLine(quantity, product);
    }

//    public OrderLine createNewOrderLine(Scanner scanner) {
//        Product product = new Product();
//        System.out.print("Enter product id: ");
//        Long productId = scanner.nextLong();
//        product.setId(productId);
//        System.out.print("Type order line quantity: ");
//        int quantity = scanner.nextInt();
//        OrderLine orderLine = new OrderLine();
//        orderLine.setProduct(product);
//        orderLine.setQuantity(quantity);
//        return orderLine;
//    }

    public OrderLine(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public OrderLine() {
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
