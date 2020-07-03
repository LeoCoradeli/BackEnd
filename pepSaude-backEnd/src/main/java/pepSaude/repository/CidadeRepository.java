package pepSaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	Optional<Cidade> findByNome(String nome);
}
