package fr.starchProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import fr.starchProject.model.Evenement;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.Participation;
import fr.starchProject.model.TypeParticipation;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IParticipationRepository;
import fr.starchProject.repository.IUtilisateurRepository;



@SpringBootTest
public class ParticipationRepositorySpringTest {

	@Autowired
	private IParticipationRepository participationRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Autowired
	private IEvenementRepository evenementRepo;

	@Test
	public void testParticipation() {

		
		int startNumber = participationRepo.findAll().size();
		
		Participation participationRuben = new Participation();
		participationRuben.setType(TypeParticipation.Participant);
		
		
		participationRuben = participationRepo.save(participationRuben);
		Participation participationRubenFind = participationRepo.findById(participationRuben.getId()).get();
		
		assertEquals(TypeParticipation.Participant, participationRuben.getType());

		int middleNumber = participationRepo.findAll().size();
		
		assertEquals(1,middleNumber - startNumber);

		participationRepo.delete(participationRuben);
		participationRubenFind = participationRepo.findById(participationRuben.getId()).get();
		assertNull(participationRubenFind);
		
		
	}
	
	@Test
	public void testParticipationWithUtilisateur() {
		
		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");
		
		ruben = utilisateurRepo.save(ruben);
		
		Participation participationRuben = new Participation();
		participationRuben.setType(TypeParticipation.Participant);
		
		participationRuben.setUtilisateur(ruben);
		
		participationRuben = participationRepo.save(participationRuben);
		
		Participation participationRubenFind = participationRepo.findById(participationRuben.getId()).get();
		
		assertEquals("rubenrust", participationRubenFind.getUtilisateur().getIdentifiant());
	}
	
	@Test
	public void testParticipationWithEvenement() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Participation participationRuben = new Participation();
		participationRuben.setType(TypeParticipation.Participant);
		
		participationRuben.setEvenement(evenementEscape);
		
		participationRuben = participationRepo.save(participationRuben);
		
		Participation participationRubenFind = participationRepo.findById(participationRuben.getId()).get();
		
		assertEquals("escape game", participationRubenFind.getEvenement().getTitre());
	}

}
