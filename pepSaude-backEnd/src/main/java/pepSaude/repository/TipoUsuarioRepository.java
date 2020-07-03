package pepSaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
	Optional<TipoUsuario> findByTipo(String tipo);
}
