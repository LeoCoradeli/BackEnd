package pepSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import pepSaude.model.TipoUsuario;
import pepSaude.model.Usuario;
import pepSaude.repository.UsuarioRepository;

@RestController
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("usuarios")
	public List<Usuario> consultarTodos() {
		return usuarioRepository.findAll();
	}

	@GetMapping("usuarios/{id}")
	public Optional<Usuario> consultar(Integer id) {
		return usuarioRepository.findById(id);
	}

	@GetMapping("usuarios/tipos")
	public Optional<Usuario> consultar(@RequestBody TipoUsuario tipoUsuario) throws BadRequest {
		Optional<Usuario> usuario = usuarioRepository.findByTipoUsuario(tipoUsuario);

		return usuario;
	}

	@GetMapping("usuarios/nome={nome}")
	public List<Usuario> consultar(@PathVariable String nome) {
		List<Usuario> usuarios = usuarioRepository.findByNomeContainingIgnoreCase(nome);

		return usuarios;
	}

	@PostMapping("usuarios")
	public Usuario login(@RequestBody Usuario usuarioCadastrar) throws BadRequest {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioCadastrar.getEmail());

		if (usuario.isPresent()) {
			throw new Error("Usuario já cadastrado!");
		} else {
			Usuario usuarioCadastrado = usuarioRepository.save(usuarioCadastrar);
			return usuarioCadastrado;
		}
	}

	@DeleteMapping("usuarios/{id}")
	public void deletar(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
	}

}
