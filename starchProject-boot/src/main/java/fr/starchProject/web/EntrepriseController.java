package fr.starchProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.starchProject.model.Entreprise;
import fr.starchProject.model.Evenement;
import fr.starchProject.model.Groupe;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IEntrepriseRepository;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IGroupeRepository;


@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
	
	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	@Autowired
	private IEvenementRepository evenementRepo;
	@Autowired
	private IGroupeRepository groupeRepo;
	
	
	@GetMapping("")
	@JsonView(Views.ViewEntreprise.class)
	public List<Entreprise> list() {
		List<Entreprise> entreprises = entrepriseRepo.findAll();

		return entreprises;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewEntreprise.class)
	public Entreprise find(@PathVariable Long id) {
		Entreprise entreprise = entrepriseRepo.findById(id).get();
		return entreprise;
	}
	
	 @GetMapping("/{id}/evenements")
	    @JsonView(Views.ViewEvenementDetail.class)
	    public List<Evenement> findEntreprises(@PathVariable Long id) {
	        List<Evenement> evenements = evenementRepo.findAllByEntreprise(id);
	        return evenements;
	    }

	@GetMapping("/{id}/groupes")
	@JsonView(Views.ViewEntrepriseGroupe.class)
	public List<Groupe> findGroupewithEntreprise(@PathVariable Long id) {
		List<Groupe> groupes = groupeRepo.findGroupewithEntreprise(id);
		return groupes;
	}
	
//	@GetMapping("/{id}/detail3")
//	@JsonView(Views.ViewEntrepriseUtilisateur.class)
//	public Entreprise findwithUtilisateur(@PathVariable Long id) {
//		Entreprise entreprise = entrepriseRepo.findWithUtilisateur(id);
//		return entreprise;
//	}

	@PostMapping("")
	public Entreprise create(@RequestBody Entreprise entreprise) {
		return entrepriseRepo.save(entreprise);
	}

	@PutMapping("/{id}")
	public Entreprise update(@RequestBody Entreprise entreprise, @PathVariable Long id) {
		return entrepriseRepo.save(entreprise);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entrepriseRepo.deleteById(id);
	}


}
