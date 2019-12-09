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

import fr.starchProject.model.Participation;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IParticipationRepository;

@RestController
@RequestMapping("/participation")
@CrossOrigin("*")
public class ParticipationController {

	
	@Autowired
	private IParticipationRepository participationRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvenement.class)
	public List<Participation> list() {
		List<Participation> participations = participationRepo.findAll();
		return participations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Participation find(@PathVariable Long id) {
		Participation participation = (Participation) participationRepo.findById(id).get();
		return participation;
	}

	@PostMapping("")
	@JsonView(Views.ViewEvenement.class)
	public Participation create(@RequestBody Participation participation) {
		System.out.println(participation);
		
		return participationRepo.save(participation);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Participation update(@RequestBody Participation participation, @PathVariable Long id) {
		return participationRepo.save(participation);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		participationRepo.deleteById(id);
	}
	
	

}
