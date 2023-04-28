package com.company.repository;
import com.company.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * · T => Type of the class. Class of the entity that needs to be created, read, updated, deleted in a database
 * · ID => Type of the field of entity. Primary Key data type
 *
 * · @Repository : Sprint Stereotype annotation
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}