package pepSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.UF;

@Repository
public interface UFRepository extends JpaRepository<UF, Integer>{

}
