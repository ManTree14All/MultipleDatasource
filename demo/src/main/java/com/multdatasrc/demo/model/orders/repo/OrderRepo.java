package com.multdatasrc.demo.model.orders.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multdatasrc.demo.model.orders.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
