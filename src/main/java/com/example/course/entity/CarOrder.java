package com.example.course.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class CarOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "carId")
    private Car orderedCar;
    private LocalDateTime start;
    private LocalDateTime finish;
    private Double price;
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setOrderedCar(Car orderedCar) {
        this.orderedCar = orderedCar;
    }
    public Car getOrderedCar() {
        return orderedCar;
    }
    public CarOrder(Integer id, LocalDateTime start, LocalDateTime finish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
    }
    public CarOrder() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public LocalDateTime getFinish() {
        return finish;
    }
    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }
}
