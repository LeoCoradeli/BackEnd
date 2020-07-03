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

import pepSaude.model.Cidade;
import pepSaude.repository.CidadeRepository;

@RestController
@RequestMapping("/")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping("cidades")
	public List<Cidade> consultarTodos() {
		return cidadeRepository.findAll();
	}

	@GetMapping("cidades/{id}")
	public Optional<Cidade> consultar(@PathVariable Integer id) {
		return cidadeRepository.findById(id);
	}

	@GetMapping("cidades/nome={nome}")
	public Optional<Cidade> consultar(String nome) {
		return cidadeRepository.findByNome(nome);
	}

	@PostMapping("cidades")
	public Cidade consultar(@RequestBody Cidade cidadeCadastrar) throws BadRequest {
		Optional<Cidade> cidade = cidadeRepository.findByNome(cidadeCadastrar.getNome());

		if (cidade.isPresent()) {
			throw new Error("Cidade já cadastrada!");
		} else {
			Cidade cidadeCadastrada = cidadeRepository.save(cidadeCadastrar);
			return cidadeCadastrada;
		}
	}
	
}
