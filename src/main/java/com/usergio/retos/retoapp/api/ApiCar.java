package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Car;
import com.usergio.retos.retoapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin("*")
public class ApiCar {
    @Autowired
    private CarService service;
    @GetMapping("/all")
    public List<Car> getAll()
             {return service.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity saveCar(@RequestBody Car car){
        service.save(car);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateGama(@RequestBody Car car){
        service.updateCar(car);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable long id){
        service.deleteCar(id);
        return ResponseEntity.status(204).build();
    }
}//hago la prueba en postman el url es local h ost:8080/api/Gama/save
