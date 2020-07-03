package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.UnidadeAtendimento;

@Repository
public interface UnidadeAtendimentoRepository extends JpaRepository<UnidadeAtendimento, Integer>{

}
