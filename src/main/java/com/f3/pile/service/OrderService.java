package com.f3.pile.service;

import com.f3.pile.domain.Order;
import com.f3.pile.domain.Project;
import com.f3.pile.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> listByProject(Project project) { return orderRepository.findByProject(project); }

    public Order findById(Integer id) {
        return orderRepository.findOne(id);
    }

    public Order saveOrder(Order order) {return orderRepository.save(order); }
}
