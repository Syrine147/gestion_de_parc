package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Reservation;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

   
    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

   
    @GetMapping("/{id}")
    public Reservation getById(@PathVariable String id) {
        return reservationService.getReservationById(id);
    }

    
    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    
    @PutMapping("/{id}")
    public Reservation update(@PathVariable String id, @RequestBody Reservation updated) {
        return reservationService.updateReservation(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }
}
