package fr.starchProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Adresse;
import fr.starchProject.model.EvenementStarch;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.TypeEvenement;
import fr.starchProject.repository.IEvenementStarchRepository;

@SpringBootTest
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
		
		EvenementStarch laserGameFind = evenementStarchRepo.findById(laserGame.getId()).get();
		
		assertEquals("laser game de fou", laserGameFind.getTitre());
		assertEquals(TypeEvenement.Corporate, laserGameFind.getTypeEvenement());
		
		int middleNumber = evenementStarchRepo.findAll().size();
		
		assertEquals(1, middleNumber-startNumber);
		
		evenementStarchRepo.delete(laserGameFind);
		
		laserGameFind = evenementStarchRepo.findById(laserGameFind.getId()).get();
		
		assertNull(laserGameFind);
		
	}
}
