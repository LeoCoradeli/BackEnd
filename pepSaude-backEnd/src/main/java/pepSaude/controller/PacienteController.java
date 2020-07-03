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

import pepSaude.model.Paciente;
import pepSaude.repository.PacienteRepository;

@RestController
@RequestMapping("/")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping("pacientes")
	public List<Paciente> consultarTodos() {
		return pacienteRepository.findAll();
	}

	@GetMapping("pacientes/{id}")
	public Optional<Paciente> consultar(@PathVariable Integer id) {
		return pacienteRepository.findById(id);
	}

	@PostMapping("pacientes")
	public Paciente consultar(@RequestBody Paciente pacienteCadastrar) throws BadRequest {

		Paciente pacienteCadastrado = pacienteRepository.save(pacienteCadastrar);
		return pacienteCadastrado;

	}

}
