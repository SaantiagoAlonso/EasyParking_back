package co.scastillos.easyParkingBack.domain.reserva;

import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpace;
import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpaceRepository;
import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.usuario.UserRepository;
import co.scastillos.easyParkingBack.domain.vehiculo.Vehicle;
import co.scastillos.easyParkingBack.domain.vehiculo.VehicleRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

    @BeforeEach
    void setUp() {

        User user = User.builder()
                .username("santiago123")
                .password("123")
                .name("santiago")
                .lastname("castillo")
                .documentId(12345678)
                .email("scastillos@ucentral.edu.co")
                .phone(3333)
                .build();

        userRepository.save(user);

        Vehicle vehicle = Vehicle.builder()
                .licensePlate("ABC123")
                .brand("Toyota")
                .model("23")
                .type("4x4")
                .color("black")
                .user(user)
                .build();

        vehicleRepository.save(vehicle);

        ParkingSpace space1 = ParkingSpace.builder()
                .status("free")
                .location("A-1")
                .size("small")
                .build();
        parkingSpaceRepository.save(space1);


        Reservation reservation = Reservation.builder()
                .arrivalTime(new Date())
                .user(user)
                .vehicle(vehicle)
                .parkingSpace(space1)
                .build();


        reservationRepository.save(reservation);

    }

    @Test
    public void reservationUserVerification(){

       Optional<Reservation> reservation = reservationRepository.findById(1L);
       assertEquals(reservation.get().getUser().getDocumentId(),12345678);

    }

    @Test
    public void reservationDateVerification(){

        Optional<Reservation> reservation = reservationRepository.findById(1L);
        Date dateSave = reservation.get().getArrivalTime();
        assertEquals(reservation.get().getArrivalTime(),dateSave);

    }

    @Test
    public void reservationVehicleVerification(){
        Optional<Reservation> reservation = reservationRepository.findById(1L);
        assertEquals(reservation.get().getVehicle().getLicensePlate(),"ABC123");

    }



}