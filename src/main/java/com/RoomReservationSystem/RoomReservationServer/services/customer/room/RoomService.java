package com.RoomReservationSystem.RoomReservationServer.services.customer.room;

import com.RoomReservationSystem.RoomReservationServer.dto.RoomsResponseDto;

public interface RoomService {
    RoomsResponseDto getAvailableRooms(int pageNumber);
}
