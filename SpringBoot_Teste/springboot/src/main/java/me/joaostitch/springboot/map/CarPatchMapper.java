package me.joaostitch.springboot.map;

import me.joaostitch.springboot.domain.Car;
import me.joaostitch.springboot.dto.CarDTOPatchBody;

public enum CarPatchMapper {
    INSTANCE;
    public Car toCar(CarDTOPatchBody carDTOPatchBody){
        if (carDTOPatchBody==null) return null;
        Car car = new Car();
        car.setModel(carDTOPatchBody.getModel());
        car.setColor(carDTOPatchBody.getColor());
        car.setYear(carDTOPatchBody.getYear());
        car.setReplaceable(carDTOPatchBody.getReplaceable());
        car.setAvailable(carDTOPatchBody.getAvailable());
        return car;
    }
}
