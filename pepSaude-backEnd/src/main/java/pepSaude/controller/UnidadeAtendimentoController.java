package pepSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import pepSaude.model.UnidadeAtendimento;
import pepSaude.repository.UnidadeAtendimentoRepository;

@RestController
@RequestMapping("/")
public class UnidadeAtendimentoController {
	@Autowired
	private UnidadeAtendimentoRepository unidadeAtendimentoRepository;

	@GetMapping("unidadesatendimento")
	public List<UnidadeAtendimento> consultarTodos() {
		return unidadeAtendimentoRepository.findAll();
	}

	@GetMapping("unidadesatendimento/{id}")
	public Optional<UnidadeAtendimento> consultar(@PathVariable Integer id) {
		return unidadeAtendimentoRepository.findById(id);
	}

	@PostMapping("unidadesatendimento")
	public UnidadeAtendimento consultar(@RequestBody UnidadeAtendimento unidadeAtendimentoCadastrar) throws BadRequest {

		UnidadeAtendimento unidadeAtendimentoCadastrada = unidadeAtendimentoRepository
				.save(unidadeAtendimentoCadastrar);
		return unidadeAtendimentoCadastrada;

	}
}
