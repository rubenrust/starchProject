package fr.starchProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.starchProject.model.Entreprise;
import fr.starchProject.repository.IEntrepriseRepository;


@RestController
@RequestMapping("/entreprise")
public class GroupeController {

	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	
	@GetMapping("")
//	@JsonView(Views.ViewEvaluation.class);
	public List<Entreprise> list() {
		List<Entreprise> entreprises = entrepriseRepo.findAll();

		return entreprises;
	}
	
	

}
