package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String course,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ){
        if (course != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }
        if (age != null && town != null){
            return new ResponseEntity<>(customerRepository.findCustomersByAgeGreaterThanEqualAndBookingsCourseTownIgnoreCase(age, town), HttpStatus.OK);
        }
        if (town != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseTownIgnoreCase(town), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

}
