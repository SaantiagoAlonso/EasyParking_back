package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.domain.usuario.RegisterUserDto;
import co.scastillos.easyParkingBack.domain.usuario.UpdateUserDto;
import co.scastillos.easyParkingBack.domain.usuario.UserResponseDto;
import co.scastillos.easyParkingBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> createNewUser(@RequestBody RegisterUserDto user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UpdateUserDto user){
        return ResponseEntity.ok(userService.updateUser(user));
    }




}
