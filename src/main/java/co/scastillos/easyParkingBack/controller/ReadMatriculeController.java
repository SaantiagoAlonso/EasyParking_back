package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.configuration.webSocket.NotificationWebSocketController;
import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.vehiculo.LicencePlateDto;
import co.scastillos.easyParkingBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/readLicencePlate")
@CrossOrigin("http://localhost:5500")
public class ReadMatriculeController {


//    @PostMapping("/licencePlate")
//    public ResponseEntity<?> readLicencePlate(@RequestBody LicencePlateDto licence){
//        System.out.println(licence);
//        return ResponseEntity.ok(HttpStatus.ACCEPTED);
//    }


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationWebSocketController webSocketController;

    @PostMapping("/licencePlate")
    public ResponseEntity<?> readLicencePlate(@RequestBody LicencePlateDto licence) {
        String plate = licence.licencePlate();

        // Buscar usuario asociado
        User user = userService.findUserByLicensePlate(plate);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        // Preparar mensaje
        Map<String, Object> notification = new HashMap<>();
        notification.put("plate", plate);
        notification.put("userId", user.getId());
        notification.put("message", "Placa detectada: " + plate);

        // Enviar notificación vía WebSocket al cliente específico (si usas simp-user-dest)
        webSocketController.notifyUser("/topic/licensePlate", notification);

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }



}
