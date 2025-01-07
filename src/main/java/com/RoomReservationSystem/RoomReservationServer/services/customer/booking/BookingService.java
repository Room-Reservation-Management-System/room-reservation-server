package com.RoomReservationSystem.RoomReservationServer.services.customer.booking;

import com.RoomReservationSystem.RoomReservationServer.dto.ReservationDto;

public interface BookingService {
    boolean postReservation(ReservationDto reservationDto);
}
