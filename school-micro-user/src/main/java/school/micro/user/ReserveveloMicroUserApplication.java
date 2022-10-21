package school.micro.user;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import school.micro.user.models.Role;
import school.micro.user.models.User;
import school.micro.user.services.UserService;

@SpringBootApplication
public class ReserveveloMicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReserveveloMicroUserApplication.class, args);
    }
   
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }

}