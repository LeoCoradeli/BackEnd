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

import pepSaude.model.DadosClinicos;
import pepSaude.repository.DadosClinicosRepository;

@RestController
@RequestMapping("/")
public class DadosClinicosController {

	@Autowired
	private DadosClinicosRepository dadosClinicosRepository;

	@GetMapping("dadosclinicos")
	public List<DadosClinicos> consultarTodos() {
		return dadosClinicosRepository.findAll();
	}

	@GetMapping("dadosclinicos/{id}")
	public Optional<DadosClinicos> consultar(@PathVariable Integer id) {
		return dadosClinicosRepository.findById(id);
	}

	@PostMapping("dadosclinicos")
	public DadosClinicos dadosClinicos(@RequestBody DadosClinicos dadosClinicosCadastrar) throws BadRequest {

		DadosClinicos dadosClinicosCadastrado = dadosClinicosRepository.save(dadosClinicosCadastrar);
		return dadosClinicosCadastrado;

	}

}
