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
import fr.starchProject.model.Views;
import fr.starchProject.repository.ICommentaireRepository;


@RestController
@RequestMapping("/commentaire")
@CrossOrigin("*")
public class CommentaireController {
	@Autowired
	private ICommentaireRepository commentaireRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommentaire.class)
	public List<Commentaire> list() {
		List<Commentaire> commentaires = commentaireRepo.findAll();
		return commentaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommentaireDetail.class)
	public Commentaire find(@PathVariable Long id) {
		Commentaire commentaire = (Commentaire) commentaireRepo.findById(id).get();

		return commentaire;
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommentaire.class)
	public Commentaire create(@RequestBody Commentaire commentaire) {
		return commentaireRepo.save(commentaire);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommentaire.class)
	public Commentaire update(@RequestBody Commentaire commentaire, @PathVariable Long id) {
		return commentaireRepo.save(commentaire);
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCommentaire.class)
	public void delete(@PathVariable Long id) {
		commentaireRepo.deleteById(id);
	}
	
}
