package com.example.azanoshop.service;

import com.example.azanoshop.entity.Order;
import com.example.azanoshop.entity.OrderDetail;
import com.example.azanoshop.entity.Product;
import com.example.azanoshop.entity.seach.FilterParameter;
import com.example.azanoshop.entity.seach.OrderSpecification;
import com.example.azanoshop.entity.seach.SearchCriteria;
import com.example.azanoshop.entity.seach.SearchCriteriaOperator;
import com.example.azanoshop.repository.OrderRepository;
import com.example.azanoshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    final OrderRepository orderRepository;
    final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order findShoppingCartByUserId(int userId){
        return orderRepository.getShoppingCart(userId);
    }

    public Order addShoppingCart(int userId, String productId, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(!optionalProduct.isPresent()){
            return null;
        }
        Order order = orderRepository.getShoppingCart(userId);
        Set<OrderDetail> orderDetails = order.getOrderDetails();
        boolean exist = false;
        for(OrderDetail entry : orderDetails)
        {
            if(entry.getProduct().getId().equals(productId)){
                entry.setQuantity(entry.getQuantity() + quantity);
                exist = true;
            }
        }
        if(!exist){
            OrderDetail orderDetail = new OrderDetail();
            orderDetails.add(orderDetail);
        }
        //save
        return order;
    }
}
