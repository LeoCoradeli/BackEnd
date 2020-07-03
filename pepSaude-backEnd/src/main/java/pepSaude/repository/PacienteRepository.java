package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
