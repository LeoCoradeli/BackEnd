package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.DadosClinicos;

@Repository
public interface DadosClinicosRepository extends JpaRepository<DadosClinicos, Integer>{

}
