package com.example.demo.service;

import com.example.demo.MODEL.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    
    public Reservation createReservation(Reservation reservation) {

        if (reservation == null)
            throw new IllegalArgumentException("Reservation est obligatoire");

        if (reservation.getId() != null)
            throw new IllegalArgumentException("Une nouvelle reservation ne doit pas avoir un ID");

        if (reservation.getLieuDepart() == null || reservation.getLieuDepart().isBlank())
            throw new IllegalArgumentException("Le lieu de départ est obligatoire");

        if (reservation.getLieuArrive() == null || reservation.getLieuArrive().isBlank())
            throw new IllegalArgumentException("Le lieu d'arrivée est obligatoire");

        if (reservation.getDateDepart() == null)
            throw new IllegalArgumentException("La date de départ est obligatoire");

        if (reservation.getDateArrive() == null)
            throw new IllegalArgumentException("La date d'arrivée est obligatoire");

        return reservationRepository.save(reservation);
    }

   
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }


    public Reservation getReservationById(Long id) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable avec l'ID : " + id));
    }

  
    public Reservation updateReservation(Long id, Reservation newReservation) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        Reservation r = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable avec l'ID : " + id));

        if (newReservation.getLieuDepart() == null || newReservation.getLieuDepart().isBlank())
            throw new IllegalArgumentException("Le lieu de départ est obligatoire");

        if (newReservation.getLieuArrive() == null || newReservation.getLieuArrive().isBlank())
            throw new IllegalArgumentException("Le lieu d'arrivée est obligatoire");

        r.setLieuDepart(newReservation.getLieuDepart());
        r.setLieuArrive(newReservation.getLieuArrive());
        r.setDateDepart(newReservation.getDateDepart());
        r.setDateArrive(newReservation.getDateArrive());
        r.setStatut(newReservation.getStatut());
        r.setEmploye(newReservation.getEmploye());
        r.setVehicule(newReservation.getVehicule());
        r.setHistorique(newReservation.getHistorique());

        return reservationRepository.save(r);
    }

    
    public void deleteReservation(Long id) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        if (!reservationRepository.existsById(id))
            throw new RuntimeException("Reservation introuvable avec l'ID : " + id);

        reservationRepository.deleteById(id);
    }
}