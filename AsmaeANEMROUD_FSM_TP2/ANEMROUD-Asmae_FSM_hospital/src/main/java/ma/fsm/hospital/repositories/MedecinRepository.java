package ma.fsm.hospital.repositories;

import ma.fsm.hospital.entities.Medecin;
import ma.fsm.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
