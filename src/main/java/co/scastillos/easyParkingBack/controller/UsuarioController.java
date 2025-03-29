package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.dto.UsuarioDto;
import co.scastillos.easyParkingBack.dto.nuevoUsuarioDto;
import co.scastillos.easyParkingBack.entity.Usuario;
import co.scastillos.easyParkingBack.service.UsuarioServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioServiece usuarioServiece;

    @PostMapping("/nuevo")
    public ResponseEntity<Void> agregar(@RequestBody nuevoUsuarioDto usuario){
        usuarioServiece.agregar(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PutMapping("/actualizar")
//    public ResponseEntity<UsuarioDto> actualizar(@RequestBody UsuarioDto usuarioDto){
//        Usuario usuario = usuarioServiece.
//
//
//
//    }



}
