package co.scastillos.easyParkingBack.service;

import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpace;
import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpaceRepository;
import co.scastillos.easyParkingBack.domain.reserva.CreateReservationDto;
import co.scastillos.easyParkingBack.domain.reserva.Reservation;
import co.scastillos.easyParkingBack.domain.reserva.ReservationRepository;
import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.usuario.UserRepository;
import co.scastillos.easyParkingBack.domain.vehiculo.Vehicle;
import co.scastillos.easyParkingBack.domain.vehiculo.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Transactional
    public void createReservation(CreateReservationDto reservation) {

        User user = userRepository.findByDocumentId(reservation.documentId()).get();
        Vehicle vehicle = vehicleRepository.findByLicensePlate(reservation.licensePlate()).get();
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(reservation.idParkingSpace()).get();

        if(parkingSpace.getStatus().equals("free")){
            Reservation newReservation = Reservation.builder()
                    .arrivalTime(new Date())
                    .parkingSpace(parkingSpace)
                    .vehicle(vehicle)
                    .user(user)
                    .build();
            reservationRepository.save(newReservation);

            parkingSpace.setStatus("noFree");
            parkingSpaceRepository.save(parkingSpace);

        }

    }
}