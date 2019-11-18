package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IGestionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class GestionRepositorySpringTest {

	@Autowired
	private IGestionRepository gestionRepo;

	@Test
	public void testGestion() {
		
		int startNumber = gestionRepo.findAll().size();
		
		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);
		
		
		gestionRuben = gestionRepo.save(gestionRuben);
		Gestion gestionRubenFind = gestionRepo.find(gestionRuben.getId());
		
		Assert.assertEquals(TypeGestion.Membre, gestionRuben.getGestion());

		int middleNumber = gestionRepo.findAll().size();

		gestionRepo.delete(gestionRuben);
		gestionRubenFind = gestionRepo.find(gestionRuben.getId());
		Assert.assertNull(gestionRubenFind);
		
	}
}
