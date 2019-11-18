package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IEvenementStarchRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class EvenementStarchRepositorySpringTest {

	@Autowired
	private IEvenementStarchRepository evenementStarchRepo;
	
	@Test
	public void testEvenementStarch() {
		
		int startNumber = evenementStarchRepo.findAll().size();
		
		EvenementStarch laserGame = new EvenementStarch();
		laserGame.setTitre("laser game de fou");
		laserGame.setNbParticipantMax(20);
		laserGame.setPrixStarch(10);
		laserGame.setDescription("venez vous amuser");
		laserGame.setTypeEvenement(TypeEvenement.Corporate);
		laserGame.setNomEvenement(NomEvenement.Laser_game);

		Adresse adresseLaserGame = new Adresse();
		adresseLaserGame.setRue("25 rue dutertre");
		adresseLaserGame.setVille("merignac");
		adresseLaserGame.setCodePostal("33400");

		laserGame.setAdresse(adresseLaserGame);
		
		laserGame = evenementStarchRepo.save(laserGame);
		
		EvenementStarch laserGameFind = evenementStarchRepo.find(laserGame.getId());
		
		Assert.assertEquals("laser game de fou", laserGameFind.getTitre());
		Assert.assertEquals(TypeEvenement.Corporate, laserGameFind.getTypeEvenement());
		
		int middleNumber = evenementStarchRepo.findAll().size();
		
		Assert.assertEquals(1, middleNumber-startNumber);
		
		evenementStarchRepo.delete(laserGameFind);
		
		laserGameFind = evenementStarchRepo.find(laserGameFind.getId());
		
		Assert.assertNull(laserGameFind);
		
	}
}
