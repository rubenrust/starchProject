package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class UtilisateurRepositorySpringTest {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Test
	public void testUtilisateur() {

		int startNumber = utilisateurRepo.findAll().size();

		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");

		ruben = utilisateurRepo.save(ruben);
		Utilisateur rubenFind = utilisateurRepo.find(ruben.getId());

		Assert.assertEquals((String) "rust.ruben@gmail.com", ruben.getEmail());
		Assert.assertEquals((String) "rubenrust", ruben.getIdentifiant());
		Assert.assertEquals((String) "rust", ruben.getNom());
		Assert.assertEquals((String) "ruben", ruben.getPrenom());
		Assert.assertEquals((String) "0632227403", ruben.getTelephone());

		int middleNumber = utilisateurRepo.findAll().size();

		utilisateurRepo.delete(ruben);
		rubenFind = utilisateurRepo.find(ruben.getId());
		Assert.assertNull(rubenFind);
	}

}
