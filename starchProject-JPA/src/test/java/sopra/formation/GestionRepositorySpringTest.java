package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IGestionRepository;
import sopra.formation.repository.IGroupeRepository;
import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class GestionRepositorySpringTest {

	@Autowired
	private IGestionRepository gestionRepo;
	@Autowired
	private IGroupeRepository groupeRepo;
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Test
	public void testGestion() {

		int startNumber = gestionRepo.findAll().size();

		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);

		gestionRuben = gestionRepo.save(gestionRuben);
		Gestion gestionRubenFind = gestionRepo.find(gestionRuben.getId());

		Assert.assertEquals(TypeGestion.Membre, gestionRuben.getGestion());

		int middleNumber = gestionRepo.findAll().size();

		Assert.assertEquals(1, middleNumber - startNumber);

		gestionRepo.delete(gestionRuben);
		gestionRubenFind = gestionRepo.find(gestionRuben.getId());
		Assert.assertNull(gestionRubenFind);

	}

	@Test
	public void testGestionWithGroupe() {

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);
		Groupe groupeTotoFind = groupeRepo.find(groupeToto.getId());

		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);

		gestionRuben.setGroupe(groupeToto);

		gestionRuben = gestionRepo.save(gestionRuben);

		Gestion gestionFind = gestionRepo.find(gestionRuben.getId());

		Assert.assertEquals("254785", gestionRuben.getGroupe().getCodeGroupe());

	}

	@Test
	public void testGestionWithUtilisateur() {

		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");
		
		ruben = utilisateurRepo.save(ruben);
		Utilisateur rubenFind = utilisateurRepo.find(ruben.getId());
		
		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);

		gestionRuben.setUtilisateur(ruben);

		gestionRuben = gestionRepo.save(gestionRuben);

		Gestion gestionFind = gestionRepo.find(gestionRuben.getId());

		Assert.assertEquals("rust", gestionRuben.getUtilisateur().getNom());

	}

}
