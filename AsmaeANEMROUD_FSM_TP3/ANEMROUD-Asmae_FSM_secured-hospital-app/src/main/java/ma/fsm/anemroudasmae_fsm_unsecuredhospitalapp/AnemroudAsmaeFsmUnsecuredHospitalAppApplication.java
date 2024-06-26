package ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp;

import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.entities.Patient;
import ma.fsm.anemroudasmae_fsm_unsecuredhospitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class AnemroudAsmaeFsmUnsecuredHospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnemroudAsmaeFsmUnsecuredHospitalAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Mohamed",new Date(),false,42));
            patientRepository.save(new Patient(null,"Imane",new Date(),true,98));
            patientRepository.save(new Patient(null,"Yassine",new Date(),true,342));
            patientRepository.save(new Patient(null,"Laila",new Date(),false,123));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
