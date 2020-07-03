package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

}
