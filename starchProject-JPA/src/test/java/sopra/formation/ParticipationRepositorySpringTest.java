package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IParticipationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class ParticipationRepositorySpringTest {

	@Autowired
	private IParticipationRepository participationRepo;

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

}
