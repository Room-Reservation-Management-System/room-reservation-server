package com.RoomReservationSystem.RoomReservationServer.services.admin.rooms;

import com.RoomReservationSystem.RoomReservationServer.dto.RoomDto;
import com.RoomReservationSystem.RoomReservationServer.entity.Room;
import com.RoomReservationSystem.RoomReservationServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;

    public boolean postRoom(RoomDto roomDto){
        try{
            Room room = new Room();

            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setType(roomDto.getType());
            room.setAvailable(true);
            System.out.println(room);
            roomRepository.save(room);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
