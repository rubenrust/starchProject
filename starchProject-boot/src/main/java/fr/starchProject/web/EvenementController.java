package fr.starchProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.starchProject.model.Commentaire;
import fr.starchProject.model.Evenement;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.model.Views;
import fr.starchProject.repository.ICommentaireRepository;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IUtilisateurRepository;
import fr.starchProject.repository.SearchCriteria;

@RestController
@RequestMapping("/evenement")
@CrossOrigin("*")
public class EvenementController {

	@Autowired
	private IEvenementRepository evenementRepo;

	@Autowired
	private ICommentaireRepository commentaireRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvenement.class)
	public List<Evenement> list() {
		List<Evenement> evenements = evenementRepo.findAll();
		return evenements;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Evenement find(@PathVariable Long id) {
		Evenement evenement = (Evenement) evenementRepo.findById(id).get();
		return evenement;
	}

	@GetMapping("/{id}/commentaires")
	@JsonView(Views.ViewEvenementDetail.class)
	public List<Commentaire> findCommentairesByEvenement(@PathVariable Long id) {
		List<Commentaire> commentaires = commentaireRepo.findAllByEvenement(id);

		return commentaires;
	}

	@PostMapping("")
	@JsonView(Views.ViewEvenement.class)
	public Evenement create(@RequestBody Evenement evenement) {
		System.out.println(evenement);
		
		return evenementRepo.save(evenement);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Evenement update(@RequestBody Evenement evenement, @PathVariable Long id) {
		return evenementRepo.save(evenement);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		evenementRepo.deleteById(id);
	}
	
	@GetMapping("/{id}/interesse")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findUtilisateursByEvenementAndInteresse(@PathVariable Long id){
		List<Utilisateur> utilisateurs = utilisateurRepo.findAllByEvenementAndInteresse(id);
		
		return utilisateurs;
	}
	
	@GetMapping("/{id}/participe")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findUtilisateursByEvenementAndParticipant(@PathVariable Long id){
		List<Utilisateur> utilisateurs = utilisateurRepo.findAllByEvenementAndParticipant(id);
		
		return utilisateurs;
	}
	
	@PostMapping("/search")
	@JsonView(Views.ViewEvenement.class)
	public List<Evenement> search(@RequestBody SearchCriteria searchCriteria) {
		List<Evenement> evenements = evenementRepo.search(searchCriteria);
		return evenements;
	}
}
