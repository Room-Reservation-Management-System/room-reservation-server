package com.RoomReservationSystem.RoomReservationServer.services.customer.booking;

import com.RoomReservationSystem.RoomReservationServer.dto.ReservationDto;
import com.RoomReservationSystem.RoomReservationServer.entity.Reservation;
import com.RoomReservationSystem.RoomReservationServer.entity.Room;
import com.RoomReservationSystem.RoomReservationServer.entity.User;
import com.RoomReservationSystem.RoomReservationServer.enums.ReservationStatus;
import com.RoomReservationSystem.RoomReservationServer.repository.ReservationRepository;
import com.RoomReservationSystem.RoomReservationServer.repository.RoomRepository;
import com.RoomReservationSystem.RoomReservationServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public boolean postReservation(ReservationDto reservationDto) {
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());
        Optional<Room> optionalRoom = roomRepository.findById(reservationDto.getRoomId());

        if (optionalUser.isPresent() && optionalRoom.isPresent()) {
            Reservation reservation = new Reservation();
            reservation.setRoom(optionalRoom.get());
            reservation.setUser(optionalUser.get());
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);

            Long days = ChronoUnit.DAYS.between(reservationDto.getCheckInDate(), reservationDto.getCheckOutDate());
            reservation.setPrice(optionalRoom.get().getPrice() * days);
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
}
