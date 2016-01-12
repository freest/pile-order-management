package com.f3.pile.web;

import com.f3.pile.domain.Order;
import com.f3.pile.service.DateService;
import com.f3.pile.service.EmployeeService;
import com.f3.pile.service.OrderService;
import com.f3.pile.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order",params = "id")
    public ModelAndView building(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("order", orderService.findById(id));
        return modelAndView;
    }

    @RequestMapping("/saveOrder")
    @ResponseBody
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
