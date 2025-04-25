package co.scastillos.easyParkingBack.domain.vehiculo;

import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.usuario.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;


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

    }

    @Test
    public void findByLicensePlate() {
        Optional<Vehicle> vehicle = vehicleRepository.findByLicensePlate("ABC123");
        assertEquals(vehicle.get().getLicensePlate(),"ABC123");
        System.out.println(vehicle.get());

    }

    @Test
    public void findByIdAndOwnerVehicle(){
        Optional<Vehicle> vehicle = vehicleRepository.findById(1L);
        assertEquals(vehicle.get().getUser().getName(),"santiago");
        System.out.println(vehicle.get());
    }

}