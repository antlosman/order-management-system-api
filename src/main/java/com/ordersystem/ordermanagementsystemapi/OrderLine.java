package com.ordersystem.ordermanagementsystemapi;


import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "OrderLine")
@Table(name = "order_line")
public class OrderLine {

    @Id
    @SequenceGenerator(name = "order_line_id_sequence", sequenceName = "order_line_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "order_line_id_sequence")

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "product_id_fk"))
    private Product product;

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
}
