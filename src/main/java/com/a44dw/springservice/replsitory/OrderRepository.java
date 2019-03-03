package com.a44dw.springservice.replsitory;

import com.a44dw.springservice.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {}
