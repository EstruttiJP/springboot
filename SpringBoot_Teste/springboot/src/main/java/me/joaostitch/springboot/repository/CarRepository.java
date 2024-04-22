package me.joaostitch.springboot.repository;

import me.joaostitch.springboot.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
