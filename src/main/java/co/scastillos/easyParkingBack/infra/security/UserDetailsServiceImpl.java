package co.scastillos.easyParkingBack.infra.security;

import co.scastillos.easyParkingBack.domain.usuario.AuthResponse;
import co.scastillos.easyParkingBack.domain.usuario.LoginUserDto;
import co.scastillos.easyParkingBack.domain.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public AuthResponse loginUser(LoginUserDto loginUsuario){
        String username = loginUsuario.username();
        String password = loginUsuario.password();

        Authentication authentication = this.authenticar(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String newToken = jwtUtils.crearToken(authentication);

        AuthResponse authReponse = new AuthResponse(username ,"user logeado correctamente",newToken,true);
        return authReponse;
    }

    private Authentication authenticar(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);
        if(userDetails == null){
            throw new BadCredentialsException("usuario o contraseña incorrecta");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException(" contraseña incorrecta");
        }

        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }







}
