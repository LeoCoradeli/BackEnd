package pepSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import pepSaude.model.TipoUsuario;
import pepSaude.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("/")
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@GetMapping("tipos-usuario/{id}")
	public Optional<TipoUsuario> consultar(Integer id) {
		return tipoUsuarioRepository.findById(id);
	}

	@GetMapping("tipos-usuario")
	public List<TipoUsuario> consultarTodos() {
		return tipoUsuarioRepository.findAll();
	}

	@PostMapping("tipos-usuario")
	public TipoUsuario consultar(@RequestBody TipoUsuario tipoUsuarioCadastrar) throws BadRequest {
		Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findByTipo(tipoUsuarioCadastrar.getTipo());

		if (tipoUsuario.isPresent()) {
			throw new Error("tipo de usuário já cadastrado!");
		} else {
			TipoUsuario tipoUsuarioCadastrado = tipoUsuarioRepository.save(tipoUsuarioCadastrar);
			return tipoUsuarioCadastrado;
		}
	}
}
