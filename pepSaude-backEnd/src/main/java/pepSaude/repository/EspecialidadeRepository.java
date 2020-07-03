package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer>{

}
