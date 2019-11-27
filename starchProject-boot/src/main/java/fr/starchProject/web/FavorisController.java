package fr.starchProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
