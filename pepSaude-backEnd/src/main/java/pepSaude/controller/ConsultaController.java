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

import pepSaude.model.Consulta;
import pepSaude.repository.ConsultaRepository;

@RestController
@RequestMapping("/")
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@GetMapping("consultas")
	public List<Consulta> consultarTodos() {
		return consultaRepository.findAll();
	}

	@GetMapping("consultas/{id}")
	public Optional<Consulta> consultar(@PathVariable Integer id) {
		return consultaRepository.findById(id);
	}

	@PostMapping("consultas")
	public Consulta consultar(@RequestBody Consulta consultaCadastrar) throws BadRequest {

		Consulta consultaCadastrada = consultaRepository.save(consultaCadastrar);
		return consultaCadastrada;

	}
}
