package fr.starchProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.starchProject.repository.IEvenementRepository;

@RestController
@RequestMapping("/evenement")
public class EvenementController {
	
	@Autowired
	private IEvenementRepository evenementRepo;
	

}
