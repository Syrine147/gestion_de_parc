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

    
    public Reservation ajouterReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

   
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    
    public Reservation getReservationById(String id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    
    public Reservation updateReservation(String id, Reservation newReservation){

    Reservation r = reservationRepository.findById(id).orElse(null);

    if( r!= null){

        r.setId(newReservation.getId());
        r.setDateArrive(newReservation.getDateArrive());
        r.setDateDepart(newReservation.getDateDepart());
        r.setLieuArrive(newReservation.getLieuArrive());
        r.setLieuDepart(newReservation.getLieuDepart());


        return reservationRepository.save(r);
    }

    return null;
}

    
    public void deleteReservation(String id){
        reservationRepository.deleteById(id);
    }
}
