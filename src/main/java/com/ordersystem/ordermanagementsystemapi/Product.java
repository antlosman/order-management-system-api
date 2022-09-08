package com.ordersystem.ordermanagementsystemapi;

import javax.persistence.*;

import java.util.Scanner;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")

    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "product_name", nullable = false, columnDefinition = "TEXT")
    private String productName;
    @Column(name = "sku_code", nullable = false)
    private Integer skuCode;
    @Column(name = "unit_price", nullable = false)
    private Integer  unitPrice;

    public Product() {

    }

    public Product(String productName, Integer skuCode, Integer unitPrice) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.unitPrice = unitPrice;
    }

    public Product createNewProduct(Scanner scanner) {
        System.out.print("Type product name: ");
        String productName = scanner.nextLine();
        System.out.print("Type skuCode number: ");
        int skuCode = scanner.nextInt();
        System.out.print("Type price number: ");
        int price = scanner.nextInt();
        return new Product(productName, skuCode, price);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", skuCode=" + skuCode +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
