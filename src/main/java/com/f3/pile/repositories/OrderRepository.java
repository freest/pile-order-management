package com.f3.pile.repositories;

import com.f3.pile.domain.Order;
import com.f3.pile.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Iterable<Order> findByProject(Project project);
}
