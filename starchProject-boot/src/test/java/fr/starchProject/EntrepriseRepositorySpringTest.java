package fr.starchProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Adresse;
import fr.starchProject.model.Entreprise;
import fr.starchProject.repository.IEntrepriseRepository;

@SpringBootTest
public class EntrepriseRepositorySpringTest {

	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	
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
		
		Entreprise sopraFind = entrepriseRepo.findById(sopra.getId()).get();
		
		assertEquals("sopra steria", sopraFind.getNom());
		assertEquals("241547", sopraFind.getCodeEntreprise());
		assertEquals("4715564558855", sopraFind.getSiret());
		assertEquals("4552662555", sopraFind.getTva());
		
		int middleNumber = entrepriseRepo.findAll().size();
		
		assertEquals(1, middleNumber-startNumber);
		
		entrepriseRepo.delete(sopraFind);
		
		sopraFind = entrepriseRepo.findById(sopraFind.getId()).get();
		
		assertNull(sopraFind);
		
	}
}
