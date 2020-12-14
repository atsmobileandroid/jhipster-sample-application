package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.OrderItems;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OrderItems entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
