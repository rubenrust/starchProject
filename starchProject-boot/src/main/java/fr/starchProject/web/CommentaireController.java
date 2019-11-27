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

import sopra.formation.model.Stagiaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/stagiaire")
public class CommentaireController {
	@Autowired
	private ICommentaireRepository commentaireRepo;

	@GetMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public List<Commentaire> list() {
		List<Commentaire> commentaires = commentaireRepo.findAllStagiaire();
		return commentaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Commentaire find(@PathVariable Long id) {
		Commentaire commentaire = (Commentaire) commentaireRepo.find(id).get();

		return commentaire;
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewStagiaireDetail.class)
	public Commentaire findDetail(@PathVariable Long id) {
		Commentaire commentaire = (Commentaire) commentaireRepo.findWithFiliere(id);

		return commentaire;
	}

	@PostMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public Commentaire create(@RequestBody Commentaire commentaire) {
		return commentaireRepo.save(commentaire);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Commentaire update(@RequestBody Commentaire commentaire, @PathVariable Long id) {
		return commentaireRepo.save(commentaire);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		commentaireRepo.deleteById(id);
	}
}
