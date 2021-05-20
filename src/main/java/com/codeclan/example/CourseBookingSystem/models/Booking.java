package com.codeclan.example.CourseBookingSystem.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date; //dd-mm-yy

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name="course_id", nullable = false)
    private Course course;

    @ManyToMany
    @JsonIgnoreProperties({"bookings"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "customer_bookings",
            joinColumns = { @JoinColumn(
                    name = "booking_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "customer_id",
                    nullable = false,
                    updatable = false)
            })
    private List<Customer> customers;

    public Booking(String date, Course course) {
        this.date = date;
        this.course = course;
        this.customers = new ArrayList<>();
    }

    public Booking(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
}
