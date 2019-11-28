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
import fr.starchProject.model.Gestion;
import fr.starchProject.model.Groupe;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IGestionRepository;
import fr.starchProject.repository.IGroupeRepository;

@RestController
@RequestMapping("/groupe")
public class GroupeController {

	@Autowired
	private IGroupeRepository groupeRepo;
	@Autowired
	private IEvenementRepository evenementRepo;
	@Autowired
	private IGestionRepository gestionRepo;

	@GetMapping("")
	@JsonView(Views.ViewGroupe.class)
	public List<Groupe> list() {
		List<Groupe> groupes = groupeRepo.findAll();

		return groupes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewGroupe.class)
	public Groupe find(@PathVariable Long id) {
		Groupe groupe = groupeRepo.findById(id).get();
		return groupe;
	}

	@GetMapping("/{id}/evenements")
	@JsonView(Views.ViewEvenementEntreprise.class)
	public List<Evenement> findEvenements(@PathVariable Long id) {
		List<Evenement> evenements = evenementRepo.findEvenementsByGroupe(id);
		return evenements;
	}


	@GetMapping("/{id}/gestion")
	@JsonView(Views.ViewGestionEntreprise.class)
	public List<Gestion> findwithGestion(@PathVariable Long id) {
		List<Gestion> gestion = gestionRepo.findGestionWithGroupe(id);
		return gestion;
	}

	@PostMapping("")
	public Groupe create(@RequestBody Groupe groupe) {
		return groupeRepo.save(groupe);
	}

	@PutMapping("/{id}")
	public Groupe update(@RequestBody Groupe groupe, @PathVariable Long id) {
		return groupeRepo.save(groupe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		groupeRepo.deleteById(id);
	}

}
