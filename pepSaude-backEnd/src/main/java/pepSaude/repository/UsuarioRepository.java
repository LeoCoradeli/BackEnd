package pepSaude.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pepSaude.model.Cidade;
import pepSaude.model.TipoUsuario;
import pepSaude.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmailAndSenha(String email, String senha);

	Optional<Usuario> findByEmail(String email);

	List<Usuario> findByNomeContainingIgnoreCase(String nome);

	Optional<Usuario> findByCpf(String nome);

	Optional<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario);

	Optional<Usuario> findByCidade(Cidade cidade);
}
