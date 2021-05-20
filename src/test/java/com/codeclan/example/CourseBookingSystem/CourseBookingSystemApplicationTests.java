package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCustomersByCourseName(){
		List<Customer> found = customerRepository.findCustomersByBookingsCourseNameIgnoreCase("Tech For Dummies");
		assertEquals(1, found.size());
	}

	@Test
	public void canGetCoursesByCustomerName(){
		List<Course> found = courseRepository.findCoursesByBookingsCustomersNameIgnoreCase("Jess J");
		assertEquals(2, found.size());
	}
}
