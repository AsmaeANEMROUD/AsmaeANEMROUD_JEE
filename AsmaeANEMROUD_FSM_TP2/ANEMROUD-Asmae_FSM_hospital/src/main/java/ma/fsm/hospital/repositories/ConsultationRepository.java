package ma.fsm.hospital.repositories;

import ma.fsm.hospital.entities.Consultation;
import ma.fsm.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
