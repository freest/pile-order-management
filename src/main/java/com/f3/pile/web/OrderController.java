package com.f3.pile.web;

import com.f3.pile.domain.Order;
import com.f3.pile.service.DateService;
import com.f3.pile.service.EmployeeService;
import com.f3.pile.service.OrderService;
import com.f3.pile.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DateService dateService;

    @RequestMapping(value = "/order",params = "id")
    public ModelAndView building(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("order", orderService.findById(id));
        return modelAndView;
    }

    @RequestMapping("/createOrder")
    @ResponseBody
    public String createOrder(@RequestParam Map<String, String> data) {
        Order order = new Order();
        order.setName(data.get("name"));
        order.setProject(projectService.findById(Integer.valueOf(data.get("projectId"))));
        order.setForeman(employeeService.findById(Integer.valueOf(data.get("foremanId"))));
        order.setStartDate(dateService.parse(data.get("startDate")));
        order.setEndDate(dateService.parse(data.get("endDate")));
        orderService.saveOrder(order);
        return order.getId().toString();
    }
}
