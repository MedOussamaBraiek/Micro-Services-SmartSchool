package school.micro.user;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import school.micro.user.models.Role;
import school.micro.user.models.User;
import school.micro.user.services.UserService;


@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
public class ReserveveloMicroUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserveveloMicroUserApplication.class, args);
	}

  @Bean
  CommandLineRunner runner(UserService userService){
      return args -> {
        userService.saveRole(new Role(null,"ROLE_USER"));    
        userService.saveRole(new Role(null,"ROLE_ADMIN"));

        userService.saveUser(new User(null,"admin","admin","admin","admin@gmail.com","admin",1,new ArrayList<>()));
        
        userService.saveUser(new User(null,"user","user","user","user@gmail.com","user",2,new ArrayList<>()));

        userService.assignRoleToUser("admin","ROLE_ADMIN");
        userService.assignRoleToUser("user","ROLE_USER");

      };
  }
  @Bean
  PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder() ;
  }

}
