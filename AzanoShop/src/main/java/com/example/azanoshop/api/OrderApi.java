package com.example.azanoshop.api;

import com.example.azanoshop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping(path = "api/v1/orders")
public class OrderApi {

    final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findByUserId(@Param("userId") int userId){
        log.info("UserId: " + userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findShoppingCartByUserId(userId)) ;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public ResponseEntity<?> CreateNew(@Param("userId") int userId, @Param("productId") String productId, @Param("qty") int qty){
        orderService.addShoppingCart(userId, productId, qty);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findShoppingCartByUserId(userId)) ;
    }
}
