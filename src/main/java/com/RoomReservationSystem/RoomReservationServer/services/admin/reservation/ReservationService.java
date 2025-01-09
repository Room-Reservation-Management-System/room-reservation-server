package com.RoomReservationSystem.RoomReservationServer.services.admin.reservation;

import com.RoomReservationSystem.RoomReservationServer.dto.ReservationResponseDto;

public interface ReservationService {
    ReservationResponseDto getAllReservations(int pageNumber);
}
