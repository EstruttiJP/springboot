package me.joaostitch.springboot.service;

import me.joaostitch.springboot.domain.Car;
import me.joaostitch.springboot.dto.CarDTOPatchBody;
import me.joaostitch.springboot.dto.CarDTOPostBody;
import me.joaostitch.springboot.dto.CarDTOPutBody;
import me.joaostitch.springboot.map.CarPatchMapper;
import me.joaostitch.springboot.map.CarPostMapper;
import me.joaostitch.springboot.map.CarPutMapper;
import me.joaostitch.springboot.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> findAll(){
        return carRepository.findAll();
    }
    public Car save(CarDTOPostBody carDTOPostBody){
        return carRepository.save(CarPostMapper.INSTANCE.toCar(carDTOPostBody));
    }
    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Car replace(CarDTOPutBody carDTOPutBody){
        Car car = findById(carDTOPutBody.getId());
        if (!car.getReplaceable()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car with "+car.getId()+" is not replaceable");
        }
        Car newCar = CarPutMapper.INSTANCE.toCar(carDTOPutBody);
        newCar.setReplaceable(car.getReplaceable());
        return carRepository.save(newCar);
    }
    public void delete(Long id){
        carRepository.delete(findById(id));
    }
    public Car updatePartially(Long id, CarDTOPatchBody carDTOPatchBody) throws IllegalAccessException {
        Car car = findById(id);
        Car newCar = CarPatchMapper.INSTANCE.toCar(carDTOPatchBody);

        for (Field field : Car.class.getDeclaredFields()){
            field.setAccessible(true);
                if (field.get(newCar)!=null && !field.get(newCar).equals(field.get(car))){
                    field.set(car, field.get(newCar));
                }
        }

        return carRepository.save(car);
    }
}
