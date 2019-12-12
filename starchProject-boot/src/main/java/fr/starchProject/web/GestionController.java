


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

import fr.starchProject.model.Gestion;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IGestionRepository;

@RestController
@RequestMapping("/gestion")
@CrossOrigin("*")
public class GestionController {

	
	
	@Autowired
	private IGestionRepository gestionRepo;

	@GetMapping("")
	@JsonView(Views.ViewGestion.class)
	public List<Gestion> list() {
		List<Gestion> gestions = gestionRepo.findAll();
		return gestions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewGestion.class)
	public Gestion find(@PathVariable Long id) {
		Gestion gestion = (Gestion) gestionRepo.findById(id).get();
		return gestion;
	}

	@PostMapping("")
	@JsonView(Views.ViewGestion.class)
	public Gestion create(@RequestBody Gestion gestion) {
		return gestionRepo.save(gestion);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewGestion.class)
	public Gestion update(@RequestBody Gestion gestion, @PathVariable Long id) {
		return gestionRepo.save(gestion);
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewGestion.class)
	public void delete(@PathVariable Long id) {
		gestionRepo.deleteById(id);
	}
	
	

}
