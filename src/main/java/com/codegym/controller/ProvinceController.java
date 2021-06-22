package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/province")
    public ModelAndView listProvince(){
        Iterable<Province>provinces=provinceService.findAll();
        ModelAndView modelAndView=new ModelAndView("/province/list");
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }
}
