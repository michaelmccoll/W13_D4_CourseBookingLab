package com.codeclan.example.CourseBookingSystem.component;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {

        Customer customer01 = new Customer("Jess J", "Edinburgh", 29);
        customerRepository.save(customer01);
        Customer customer02 = new Customer("Jack B", "Glasgow", 31);
        customerRepository.save(customer02);
        Customer customer03 = new Customer("Jamie S", "Newcastle", 23);
        customerRepository.save(customer03);
        Customer customer04 = new Customer("Jordan N", "London", 45);
        customerRepository.save(customer04);
        Customer customer05 = new Customer("James N", "Manchester", 36);
        customerRepository.save(customer05);

        Course course1 = new Course("Tech For Dummies","Edinburgh",5);
        courseRepository.save(course1);
        Course course2 = new Course("Art & Design","Glasgow",4);
        courseRepository.save(course2);
        Course course3 = new Course("English","Aberdeen",1);
        courseRepository.save(course3);
        Course course4 = new Course("Spanish","Edinburgh",5);
        courseRepository.save(course4);
        Course course5 = new Course("Music","Glasgow",5);
        courseRepository.save(course5);

        Booking booking01 = new Booking("01/06/21", course1);
        booking01.addCustomer(customer01);
        bookingRepository.save(booking01);
        Booking booking02 = new Booking("28/08/21", course2);
        booking02.addCustomer(customer02);
        booking02.addCustomer(customer03);
        bookingRepository.save(booking02);
        Booking booking03 = new Booking("19/07/21", course3);
        booking03.addCustomer(customer01);
        booking03.addCustomer(customer04);
        booking03.addCustomer(customer05);
        bookingRepository.save(booking03);

    }

}
