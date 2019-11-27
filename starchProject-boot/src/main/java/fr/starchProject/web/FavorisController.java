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

import fr.starchProject.model.Favoris;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IFavorisRepository;

@RestController
@RequestMapping("/favoris")
public class FavorisController {

	@Autowired
	IFavorisRepository favorisRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewFavoris.class)
	public List<Favoris> list(){
		List<Favoris> favoris = favorisRepo.findAll();
		
		return favoris;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Favoris find(@PathVariable Long id) {
		Favoris favoris = favorisRepo.findById(id).get();
		
		return favoris;
	}
	
	@PostMapping("")
	public Favoris create(@RequestBody Favoris favoris) {
		return favorisRepo.save(favoris);
	}
	
	@PutMapping("/{id}")
	public Favoris update(@RequestBody Favoris favoris, @PathVariable Long id) {
		return favorisRepo.save(favoris);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		favorisRepo.deleteById(id);
	}
}
