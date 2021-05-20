package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomersByBookingsCourseNameIgnoreCase(String course_name);
    List<Customer> findCustomersByBookingsCourseTownIgnoreCase(String course_town);
    List<Customer> findCustomersByAgeGreaterThanEqualAndBookingsCourseTownIgnoreCase(int age, String course_town);
}
