package com.a44dw.springservice.controller;

import com.a44dw.springservice.model.Client;
import com.a44dw.springservice.model.Order;
import com.a44dw.springservice.replsitory.ClientRepository;
import com.a44dw.springservice.replsitory.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderController(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String showOrdersList(Map<String, Object> model) {
        Collection<Order> orderResults = (Collection<Order>) orderRepository.findAll();

        model.put("orders", orderResults);

        return "ordersList";
    }

    @GetMapping("/new")
    public String initNewOrderForm(Map<String, Object> model) {
        Order order = new Order();
        model.put("order", order);
        model.put("clients", clientRepository.findAll());
        return "editOrder";
    }

    @GetMapping("/update/{id}")
    public String initUpdateOrderForm(@PathVariable("id") int id, Model model) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) {
            model.addAttribute(optionalOrder.get());
            model.addAttribute("clients", clientRepository.findAll());
            return "editOrder";
        }
        return "redirect:/orders";
    }

    @PostMapping({"/new", "/update/{id}"})
    public String processOrderForm(@Valid Order order, BindingResult result, @PathVariable(value = "id", required = false) Integer id) {
        if(result.hasErrors()) {
            return "editOrder";
        }
        if(id != null)
            order.setId(id);
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String processDelete(@PathVariable("id") int id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }

}
