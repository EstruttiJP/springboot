package me.joaostitch.springboot.controller;

import me.joaostitch.springboot.domain.Car;
import me.joaostitch.springboot.dto.CarDTO;
import me.joaostitch.springboot.dto.CarDTOPatchBody;
import me.joaostitch.springboot.dto.CarDTOPostBody;
import me.joaostitch.springboot.dto.CarDTOPutBody;
import me.joaostitch.springboot.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id){
        return new ResponseEntity<>(carService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Car> save(@RequestBody @Valid CarDTOPostBody carDTOPostBody){
        return new ResponseEntity<>(carService.save(carDTOPostBody), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Car> replace(@RequestBody CarDTOPutBody carDTOPutBody){
        return new ResponseEntity<>(carService.replace(carDTOPutBody), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Car> updatePartially(@PathVariable Long id, @RequestBody CarDTOPatchBody carDTOPatchBody) throws IllegalAccessException {
        return new ResponseEntity<>(carService.updatePartially(id, carDTOPatchBody), HttpStatus.OK);
    }
}
