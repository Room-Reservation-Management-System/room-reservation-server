package com.RoomReservationSystem.RoomReservationServer.services.admin.rooms;

import com.RoomReservationSystem.RoomReservationServer.dto.RoomDto;
import com.RoomReservationSystem.RoomReservationServer.dto.RoomsResponseDto;
import com.RoomReservationSystem.RoomReservationServer.entity.Room;
import com.RoomReservationSystem.RoomReservationServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService{
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

    public RoomsResponseDto getAllRooms(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 1);
        Page<Room> roomPage = roomRepository.findAll(pageable);

        RoomsResponseDto roomsResponseDto = new RoomsResponseDto();
        roomsResponseDto.setPageNumber(roomPage.getPageable().getPageNumber());
        roomsResponseDto.setTotalPages(roomPage.getTotalPages());
        roomsResponseDto.setRoomDtoList(roomPage.stream().map(Room::getRoomDto).collect(Collectors.toList()));

        return roomsResponseDto;
    }
}
