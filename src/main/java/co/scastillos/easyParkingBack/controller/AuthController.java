package co.scastillos.easyParkingBack.controller;


import co.scastillos.easyParkingBack.domain.usuario.AuthResponse;
import co.scastillos.easyParkingBack.domain.usuario.LoginUserDto;
import co.scastillos.easyParkingBack.infra.security.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserDetailsServiceImpl userDatailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginUserDto loginUsuario){
        return new ResponseEntity<>(this.userDatailsService.loginUser(loginUsuario), HttpStatus.OK);
    }

    @GetMapping("/hola")
    public ResponseEntity<String> hola(){
        return ResponseEntity.ok("hola");
    }



}
