package co.scastillos.easyParkingBack.service;

import co.scastillos.easyParkingBack.dto.UsuarioDto;
import co.scastillos.easyParkingBack.dto.nuevoUsuarioDto;
import co.scastillos.easyParkingBack.entity.Usuario;
import co.scastillos.easyParkingBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiece {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void agregar(nuevoUsuarioDto usuario) {

        Usuario nuevoUsuario = Usuario.builder()
                .cedula(usuario.cedula())
                .nombre(usuario.nombre())
                .apellido(usuario.apellido())
                .direccion(usuario.direccion())
                .telefono(usuario.telefono())
                .build();

        usuarioRepository.save(nuevoUsuario);
    }

//    public UsuarioDto actualizar(UsuarioDto usuarioDto){
//
//
//    }


}
