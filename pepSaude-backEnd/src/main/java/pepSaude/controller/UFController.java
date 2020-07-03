package pepSaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pepSaude.model.UF;
import pepSaude.repository.UFRepository;

@RestController
@RequestMapping("/uf")
public class UFController {

	@Autowired
	private UFRepository salaRepository;
	
	@GetMapping("/consultar/:id")
	public Optional<UF> consultar(Integer id){
		return salaRepository.findById(id);
	}
	
	@GetMapping("/consultar")
	public List<UF> consultarTodos(){
		return salaRepository.findAll();
	}
}
