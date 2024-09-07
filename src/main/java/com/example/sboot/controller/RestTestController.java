package com.example.sboot.controller;

import com.example.sboot.entity.Customer;
import com.example.sboot.entity.CustomerDTO;
import com.example.sboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class RestTestController {

    private final CustomerService customerService;

   /* @GetMapping("/lists")
    public List<Customer> lists(){
        List<Customer> cusList=customerService.getAllCustomer();
        return cusList;  // JSON 변환 ? -> 순환함조
    }*/
   @GetMapping("/lists")
   public List<CustomerDTO> lists(){
       //List<Customer> cusList=customerService.getAllCustomerWithReviews();
       return customerService.getAllCustomerWithReviews(); // JSON 변환 ? -> 순환함조
   }
}
