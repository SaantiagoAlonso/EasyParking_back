package co.scastillos.easyParkingBack.service;

import co.scastillos.easyParkingBack.domain.usuario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void createUser(RegisterUserDto user) {

        User newUser = User.builder()
                .username(user.username())
                .password(passwordEncoder.encode(user.password()))
                .documentId(user.documentId())
                .name(user.name())
                .lastname(user.lastname())
                .address(user.address())
                .email(user.email())
                .phone(user.phone())
                .build();

        userRepository.save(newUser);

    }


    @Transactional
    public UserResponseDto updateUser(UpdateUserDto userDto) {

        User user = userRepository.findById(userDto.id()).get();
        if(userDto.documentId() != null){
            user.setDocumentId(userDto.documentId());
        }
        if(userDto.username() != null){
            user.setUsername(userDto.username());
        }
        if (userDto.name() != null){
            user.setName(userDto.name());
        }
        if(userDto.lastname() != null){
            user.setLastname(userDto.lastname());
        }
        if(userDto.password() != null){
            user.setPassword(passwordEncoder.encode(userDto.password()));
        }
        if (userDto.address() != null){
            user.setAddress(userDto.address());
        }
        if(userDto.email() != null){
            user.setEmail(userDto.email());
        }
        if (userDto.phone() != null){
            user.setPhone(userDto.phone());
        }
        userRepository.save(user);

        return new UserResponseDto(user);

    }
}
