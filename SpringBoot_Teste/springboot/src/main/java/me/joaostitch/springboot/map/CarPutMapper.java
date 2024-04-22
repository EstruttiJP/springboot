package me.joaostitch.springboot.map;

import me.joaostitch.springboot.domain.Car;
import me.joaostitch.springboot.dto.CarDTO;
import me.joaostitch.springboot.dto.CarDTOPutBody;

public enum CarPutMapper {
    INSTANCE;
    public Car toCar(CarDTOPutBody carDTOPutBody){
        if (carDTOPutBody==null) return null;
            Car car = new Car();
            car.setId(carDTOPutBody.getId());
            car.setModel(carDTOPutBody.getModel());
            car.setColor(carDTOPutBody.getColor());
            car.setYear(carDTOPutBody.getYear());
            return car;
    }
}
