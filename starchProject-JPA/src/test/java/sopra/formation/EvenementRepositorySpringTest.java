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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class EvenementRepositorySpringTest {

	@Autowired
	private IEvenementRepository evenementRepo;
	
	@Test
	public void testEvenement() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		int startNumber = evenementRepo.findAll().size();
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setDeadline(sdf.parse("07-06-2018"));
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals((Integer) 25, evenementEscapeFind.getNbParticipantMax());
		Assert.assertEquals("escape game", evenementEscapeFind.getTitre());
		Assert.assertEquals((Integer) 15, evenementEscapeFind.getPrix());
		
		int middleNumber = evenementRepo.findAll().size();
		
		Assert.assertEquals(1, middleNumber-startNumber);
		
		evenementRepo.delete(evenementEscapeFind);
		
		evenementEscapeFind = evenementRepo.find(evenementEscapeFind.getId());
		
		Assert.assertNull(evenementEscapeFind);
	}
}
