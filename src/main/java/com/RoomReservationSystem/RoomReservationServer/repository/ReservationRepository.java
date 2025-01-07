package com.RoomReservationSystem.RoomReservationServer.repository;

import com.RoomReservationSystem.RoomReservationServer.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
