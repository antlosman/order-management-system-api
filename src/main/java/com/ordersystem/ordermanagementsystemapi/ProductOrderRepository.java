package com.ordersystem.ordermanagementsystemapi;

import org.springframework.data.repository.CrudRepository;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Long> {
}
