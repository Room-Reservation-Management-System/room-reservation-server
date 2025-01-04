package com.RoomReservationSystem.RoomReservationServer.services.admin.rooms;

import com.RoomReservationSystem.RoomReservationServer.dto.RoomDto;

public interface RoomService {
    boolean postRoom(RoomDto roomDto);
}
