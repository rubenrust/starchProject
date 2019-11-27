//package fr.starchProject.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//import fr.starchProject.model.EvenementStarch;
//import fr.starchProject.repository.IEvenementStarchRepository;
//import sopra.formation.model.Evaluation;
//import sopra.formation.model.Views;
//import sopra.formation.repository.IEvaluationRepository;
//
//@RestController
//@RequestMapping("/evenementStarch")
//public class EvenementStarchController {
//	@Autowired
//	private IEvenementStarchRepository evenementStarchRepo;
//
//	@GetMapping("")
//	@JsonView(Views.ViewEvenementStarch.class)
//	public List<EvenementStarch> list() {
//		List<EvenementStarch> evenementStarchs = evenementStarchRepo.findAll();
//
//		return evenementStarchs;
//	}
//
//	@GetMapping("/{id}")
//	@JsonView(Views.ViewEvenementStarchDetail.class)
//	public EvenementStarch find(@PathVariable Long id) {
//		EvenementStarch evenementStarch = evenementStarchRepo.findById(id).get();
//
//		return evenementStarch;
//	}
//
//	@PostMapping("")
//	public EvenementStarch create(@RequestBody EvenementStarch evenementStarch) {
//		return evenementStarchRepo.save(evenementStarch);
//	}
//
//	@PutMapping("/{id}")
//	public EvenementStarch update(@RequestBody EvenementStarch evenementStarch, @PathVariable Long id) {
//		return evenementStarchRepo.save(evenementStarch);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		evenementStarchRepo.deleteById(id);
//	}
//}

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

import fr.starchProject.model.EvenementStarch;
import fr.starchProject.model.Views;
import fr.starchProject.repository.IEvenementStarchRepository;

@RestController
@RequestMapping("/evenementStarch")
public class EvenementStarchController {
	@Autowired
	private IEvenementStarchRepository evenementStarchRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvenementStarch.class)
	public List<EvenementStarch> list() {
		List<EvenementStarch> evenementStarchs = evenementStarchRepo.findAll();

		return evenementStarchs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEvenementStarchDetail.class)
	public EvenementStarch find(@PathVariable Long id) {
		EvenementStarch evenementStarch = evenementStarchRepo.findById(id).get();

		return evenementStarch;
	}
	

	@PostMapping("")
	public EvenementStarch create(@RequestBody EvenementStarch evenementStarch) {
		return evenementStarchRepo.save(evenementStarch);
	}

	@PutMapping("/{id}")
	public EvenementStarch update(@RequestBody EvenementStarch evenementStarch, @PathVariable Long id) {
		return evenementStarchRepo.save(evenementStarch);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		evenementStarchRepo.deleteById(id);
	}
}
