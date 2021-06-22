package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.GeneralService;

public interface ICustomerService extends GeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
