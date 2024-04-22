package me.joaostitch.springboot.map;

import me.joaostitch.springboot.domain.Car;
import me.joaostitch.springboot.dto.CarDTOPostBody;
import me.joaostitch.springboot.dto.CarDTOPutBody;

public enum CarPostMapper {
    INSTANCE;
    public Car toCar(CarDTOPostBody carDTOPostBody){
        if (carDTOPostBody==null) return null;
        Car car = new Car();
        car.setModel(carDTOPostBody.getModel());
        car.setColor(carDTOPostBody.getColor());
        car.setYear(carDTOPostBody.getYear());
        car.setReplaceable(carDTOPostBody.getReplaceable());
        return car;
    }
}
