package com.company.repository;
import com.company.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * · T => Type of the class
 * · ID => Primary Key data type
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}