package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
    @GetMapping("/customers")
    public ModelAndView createFormCustomer(){
        Iterable<Customer> customers=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("create/customer")
    public ModelAndView createCustomerForm(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
//        modelAndView.addObject("provinces",provinces());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView createCustomer(@ModelAttribute(name = "customer") Customer customer){
         customerService.save(customer);
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @GetMapping("edit/customer/{id}")
    public ModelAndView editCustomerForm(@PathVariable Long id){
        Optional<Customer>customer=customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView=new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("/error-404");
            return modelAndView;
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customer")Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView=new ModelAndView("/customer/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @GetMapping("delete/customer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.remove(id);
        return "redirect:/customers";
    }
}
