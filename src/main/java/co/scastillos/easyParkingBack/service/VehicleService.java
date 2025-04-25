package co.scastillos.easyParkingBack.service;

import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.usuario.UserRepository;
import co.scastillos.easyParkingBack.domain.vehiculo.Vehicle;
import co.scastillos.easyParkingBack.domain.vehiculo.VehicleDto;
import co.scastillos.easyParkingBack.domain.vehiculo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    public void registerVehicle(VehicleDto vehicle){

        //configurar errror en caso de no encontar usuario
        User user = userRepository.findByDocumentId(vehicle.documentId()).get();

        Vehicle newVehicle = Vehicle.builder()
                .licensePlate(vehicle.licensePlate())
                .brand(vehicle.brand())
                .model(vehicle.model())
                .color(vehicle.color())
                .type(vehicle.type())
                .user(user)
                .build();

        user.getVehicles().add(newVehicle);

        userRepository.save(user);
        vehicleRepository.save(newVehicle);


    }



}
