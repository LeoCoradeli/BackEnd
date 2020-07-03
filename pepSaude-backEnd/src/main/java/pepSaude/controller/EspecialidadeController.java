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

import pepSaude.model.Especialidade;
import pepSaude.repository.EspecialidadeRepository;


@RestController
@RequestMapping("/")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("especialidades")
	public List<Especialidade> consultarTodos() {
		return especialidadeRepository.findAll();
	}

	@GetMapping("especialidades/{id}")
	public Optional<Especialidade> consultar(@PathVariable Integer id) {
		return especialidadeRepository.findById(id);
	}

	@PostMapping("especialidades")
	public Especialidade consultar(@RequestBody Especialidade especialidadeCadastrar) throws BadRequest {

		Especialidade especialidadeCadastrada = especialidadeRepository.save(especialidadeCadastrar);
		return especialidadeCadastrada;

	}
	
}
