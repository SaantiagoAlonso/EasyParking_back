package co.scastillos.easyParkingBack.domain.estacionamiento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ParkingSpaceRepositoryTest {

    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;


    @BeforeEach
    void setUp() {

        ParkingSpace space1 = ParkingSpace.builder()
                .status("free")
                .location("A-1")
                .size("small")
                .build();
        ParkingSpace space2 = ParkingSpace.builder()
                .status("noFree")
                .location("A-2")
                .size("medium")
                .build();
        ParkingSpace space3 = ParkingSpace.builder()
                .status("free")
                .location("A-3")
                .size("small")
                .build();
        ParkingSpace space4 = ParkingSpace.builder()
                .status("noFree")
                .location("A-4")
                .size("medium")
                .build();

        parkingSpaceRepository.save(space1);
        parkingSpaceRepository.save(space2);
        parkingSpaceRepository.save(space3);
        parkingSpaceRepository.save(space4);

    }


    @Test
    public void findAllSpaces(){
        List<ParkingSpace> parkingSpaceList = parkingSpaceRepository.findAll();
        assertEquals(parkingSpaceList.size(),4);

    }

    @Test
    public void listSpacesFree(){

        List<ParkingSpace> parkingSpaceList = parkingSpaceRepository.findAll();
        List<ParkingSpace> freeSpaces = parkingSpaceList.stream()
                .filter(space -> space.getStatus().equals("free")).toList();
        assertEquals(2, freeSpaces.size(), "El número de espacios libres no es el esperado");

    }


}