package com.example.course.entity;


import jakarta.persistence.*;

@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private double price;

//    @OneToOne(mappedBy = "orderedCar", cascade = CascadeType.ALL)
//    private CarOrder carOrder;
//
//    public CarOrder getCarOrder() {
//        return carOrder;
//    }
//
//    public void setCarOrder(CarOrder carOrder) {
//        this.carOrder = carOrder;
//    }

    public String getName() {
        return name;
    }

    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
