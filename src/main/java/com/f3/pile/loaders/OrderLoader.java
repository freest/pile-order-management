package com.f3.pile.loaders;

import com.f3.pile.domain.Order;
import com.f3.pile.domain.Project;
import com.f3.pile.repositories.OrderRepository;
import com.f3.pile.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component
@DependsOn("projectLoader")
public class OrderLoader  implements ApplicationListener<ContextRefreshedEvent> {
    private OrderRepository orderRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Project project = projectRepository.findAll().iterator().next();
        try {
            Order order = new Order();
            order.setName("1-1-1");
            order.setProject(project);
            order.setForeman(project.getForeman());
            order.setStartDate(sdf.parse("25.12.2015"));
            order.setEndDate(sdf.parse("4.1.2016"));
            orderRepository.save(order);

            order = new Order();
            order.setName("1-2-1");
            order.setProject(project);
            order.setForeman(project.getForeman());
            order.setStartDate(sdf.parse("5.1.2016"));
            order.setEndDate(sdf.parse("14.1.2016"));
            orderRepository.save(order);

            order = new Order();
            order.setName("1-3-1");
            order.setProject(project);
            order.setForeman(project.getForeman());
            order.setStartDate(sdf.parse("15.1.2016"));
            order.setEndDate(sdf.parse("24.1.2016"));
            orderRepository.save(order);
        } catch (Exception e) {}
    }
}
