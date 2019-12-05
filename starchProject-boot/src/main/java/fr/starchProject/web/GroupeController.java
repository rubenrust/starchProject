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

import fr.starchProject.model.Evenement;
import fr.starchProject.model.Groupe;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IGroupeRepository;
import fr.starchProject.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/groupe")
public class GroupeController {

	@Autowired
	private IGroupeRepository groupeRepo;
	@Autowired
	private IEvenementRepository evenementRepo;
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

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
	@JsonView(Views.ViewEvenementGroupe.class)
	public List<Evenement> findEvenementsByGroupeId(@PathVariable Long id) {
		List<Evenement> evenements = evenementRepo.findAllByGroupeId(id);
		return evenements;
	}


	@PostMapping("")
	@JsonView(Views.ViewGroupe.class)
	public Groupe create(@RequestBody Groupe groupe) {
		return groupeRepo.save(groupe);
	}
	
	

	@PutMapping("/{id}")
	@JsonView(Views.ViewGroupe.class)
	public Groupe update(@RequestBody Groupe groupe, @PathVariable Long id) {
		return groupeRepo.save(groupe);
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewGroupe.class)
	public void delete(@PathVariable Long id) {
		groupeRepo.deleteById(id);
	}
	

	@GetMapping("/{id}/utilisateurs")
	@JsonView(Views.ViewtUtilisateurGroupe.class)
	public List<Utilisateur> findUtilisateursByGroupeId(@PathVariable Long id){
		List<Utilisateur> utilisateurs = utilisateurRepo.findAllByGroupeId(id);
		
		return utilisateurs;
	}

}
