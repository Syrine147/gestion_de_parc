package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.ReservationRepository;
import com.example.demo.MODEL.Reservation;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // ajouter reservation
    public Reservation ajouterReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    // afficher toutes les reservations
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    // chercher reservation par id
    public Reservation getReservationById(String id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    
    public Reservation updateReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    
    public void deleteReservation(String id){
        reservationRepository.deleteById(id);
    }
}
