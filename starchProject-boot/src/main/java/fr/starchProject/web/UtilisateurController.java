package fr.starchProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import fr.starchProject.model.Favoris;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IFavorisRepository;
import fr.starchProject.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	IUtilisateurRepository utilisateurRepo;
	
	@Autowired
	IFavorisRepository favorisRepo;
	
	@Autowired
	IEvenementRepository evenementRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> list(){
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		
		return utilisateurs;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurRepo.findById(id).get();
		
		return utilisateur;
	}
	
	@PostMapping("")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return utilisateurRepo.save(utilisateur);
	}
	
	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		return utilisateurRepo.save(utilisateur);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		utilisateurRepo.deleteById(id);
	}
	
	
	
	@GetMapping("/{id}/groupe")
	public List<Utilisateur> findAllByGroupeId(@PathVariable Long id){
		List<Utilisateur> utilisateurs = utilisateurRepo.findAllByGroupeId(id);
		
		return utilisateurs;
	}
	
	@GetMapping("/{id}/favoris")
	public Favoris findByUtilisateurId(@PathVariable Long id) {
		Favoris favoris = favorisRepo.findByUtilisateurId(id);
		
		return favoris;
	}
	
	@GetMapping("/{id}/evenements")
	List<Evenement> findAllByUtilisateurId(@Param("id") Long id){
		List<Evenement> evenements = evenementRepo.findAllByUtilisateurId(id);
		
		return evenements;
	}
}
