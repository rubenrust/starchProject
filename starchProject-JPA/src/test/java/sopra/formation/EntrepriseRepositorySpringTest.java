package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IEntreprisesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class EntrepriseRepositorySpringTest {

	@Autowired
	private IEntreprisesRepository entrepriseRepo;
	
	@Test
	public void testEntreprise() {
		
		int startNumber = entrepriseRepo.findAll().size();
		
		Entreprise sopra = new Entreprise();
		sopra.setNom("sopra steria");
		sopra.setCodeEntreprise("241547");
		sopra.setSiret("4715564558855");
		sopra.setTva("4552662555");

		Adresse adresseSopra = new Adresse();
		adresseSopra.setRue("24 rue dure");
		adresseSopra.setVille("Merignac");
		adresseSopra.setCodePostal("33700");

		sopra.setAdresse(adresseSopra);
		
		sopra = entrepriseRepo.save(sopra);
		
		Entreprise sopraFind = entrepriseRepo.find(sopra.getId());
		
		Assert.assertEquals("sopra steria", sopraFind.getNom());
		Assert.assertEquals("241547", sopraFind.getCodeEntreprise());
		Assert.assertEquals("4715564558855", sopraFind.getSiret());
		Assert.assertEquals("4552662555", sopraFind.getTva());
		
		int middleNumber = entrepriseRepo.findAll().size();
		
		Assert.assertEquals(1, middleNumber-startNumber);
		
		entrepriseRepo.delete(sopraFind);
		
		sopraFind = entrepriseRepo.find(sopraFind.getId());
		
		Assert.assertNull(sopraFind);
		
	}
}
