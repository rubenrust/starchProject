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

import fr.starchProject.model.LieuxEvenement;
import fr.starchProject.model.Views;
import fr.starchProject.repository.ILieuxEvenementRepository;

@RestController
@RequestMapping("/lieuxevenement")
@CrossOrigin("*")
public class LieuxEvenementController {

	@Autowired
	private ILieuxEvenementRepository lieuxRepo;

	@GetMapping("")
	@JsonView(Views.ViewLieuxEvenement.class)
	public List<LieuxEvenement> list() {
		List<LieuxEvenement> lieuxevenements = lieuxRepo.findAll();
		return lieuxevenements;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLieuxEvenement.class)
	public LieuxEvenement find(@PathVariable Long id) {
		LieuxEvenement lieuxevenement = (LieuxEvenement) lieuxRepo.findById(id).get();
		return lieuxevenement;
	}

	@PostMapping("")
	@JsonView(Views.ViewLieuxEvenement.class)
	public LieuxEvenement create(@RequestBody LieuxEvenement lieuxevenement) {
		return lieuxRepo.save(lieuxevenement);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLieuxEvenement.class)
	public LieuxEvenement update(@RequestBody LieuxEvenement lieuxevenement, @PathVariable Long id) {
		return lieuxRepo.save(lieuxevenement);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		lieuxRepo.deleteById(id);
	}
}
