package com.example.azanoshop.repository;

import com.example.azanoshop.entity.Order;
import com.example.azanoshop.entity.myenum.OrderSimpleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
    @Query(nativeQuery = true, value = "select  * from orders where user_id = :userId and is_shopping_cart = 1")
    Order getShoppingCart(@Param("userId") int userId);
    Page<Order> findAllByStatusEquals(OrderSimpleStatus status, Pageable pageable);

}
