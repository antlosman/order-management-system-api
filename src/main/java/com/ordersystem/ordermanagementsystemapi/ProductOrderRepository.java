package com.ordersystem.ordermanagementsystemapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
