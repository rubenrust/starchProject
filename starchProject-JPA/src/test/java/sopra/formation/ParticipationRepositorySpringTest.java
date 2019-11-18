package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IEvenementRepository;
import sopra.formation.repository.IParticipationRepository;
import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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
		Participation participationRubenFind = participationRepo.find(participationRuben.getId());
		
		Assert.assertEquals(TypeParticipation.Participant, participationRuben.getType());

		int middleNumber = participationRepo.findAll().size();
		
		Assert.assertEquals(1,middleNumber - startNumber);

		participationRepo.delete(participationRuben);
		participationRubenFind = participationRepo.find(participationRuben.getId());
		Assert.assertNull(participationRubenFind);
		
		
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
		
		Participation participationRubenFind = participationRepo.find(participationRuben.getId());
		
		Assert.assertEquals("rubenrust", participationRubenFind.getUtilisateur().getIdentifiant());
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
		
		Participation participationRubenFind = participationRepo.find(participationRuben.getId());
		
		Assert.assertEquals("escape game", participationRubenFind.getEvenement().getTitre());
	}

}
