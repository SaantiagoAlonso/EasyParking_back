package co.scastillos.easyParkingBack.domain.usuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserRepositoryTest {

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
    }

    @Test
    public void findByUsername(){
        UserDetails user = userRepository.findByUsername("santiago123");
        assertEquals(user.getUsername(),"santiago123");
        System.out.println(user.getUsername());
    }

    @Test
    public void findByDocumentId(){

        Optional<User> user = userRepository.findByDocumentId(12345678);
        assertEquals(user.get().getDocumentId(),12345678);
        System.out.println(user.get());
    }

    @Test
    public void findById(){
        Optional<User> user = userRepository.findById(1L);
        assertEquals(user.get().getName(),"santiago");
        System.out.println(user.get());
    }



}