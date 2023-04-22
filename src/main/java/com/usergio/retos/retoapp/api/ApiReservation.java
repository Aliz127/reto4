package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import com.usergio.retos.retoapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin
public class ApiReservation {
    @Autowired
    private ReservationService service;
    @GetMapping("/all")
    public List<Reservation> getALL(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable long id){
        return service.getFindById(id);
    }
    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Reservation reservation){
        service.save(reservation);
        return  ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Reservation reservation){
        service.updateReservation(reservation);
        return  ResponseEntity.status(201).build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation (@PathVariable long id){
        service.deleteReservation(id);
        return  ResponseEntity.status(204).build();
    }
}
