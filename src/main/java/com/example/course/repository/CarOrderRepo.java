package com.example.course.repository;

import com.example.course.entity.CarOrder;
//import com.example.course.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface CarOrderRepo extends CrudRepository<CarOrder, Long> {

}
