package fr.starchProject;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IEntreprisesRepository;
import sopra.formation.repository.IGroupeRepository;
import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class GroupeRepositorySpringTest {

	@Autowired
	private IGroupeRepository groupeRepo;
	@Autowired
	private IEntreprisesRepository entrepriseRepo;

	@Test
	public void testGroupe() {

		int startNumber = groupeRepo.findAll().size();

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);
		Groupe groupeTotoFind = groupeRepo.find(groupeToto.getId());

		Assert.assertEquals((String) "254785", groupeToto.getCodeGroupe());
		Assert.assertEquals((String) "Toto", groupeToto.getNom());

		int middleNumber = groupeRepo.findAll().size();
		
		Assert.assertEquals(1,middleNumber - startNumber);

		groupeRepo.delete(groupeToto);

		groupeTotoFind = groupeRepo.find(groupeToto.getId());

		Assert.assertNull(groupeTotoFind);

	}

	@Test
	public void testGroupeWithEntreprise() {

		Entreprise sopra = new Entreprise();
		sopra.setNom("sopra steria");
		sopra.setCodeEntreprise("241547");
		sopra.setSiret("4715564558855");
		sopra.setTva("4552662555");

		sopra = entrepriseRepo.save(sopra);

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto.setEntreprise(sopra);

		groupeToto = groupeRepo.save(groupeToto);

		Groupe groupeTotoFind = groupeRepo.find(groupeToto.getId());

		Assert.assertEquals("4715564558855", groupeToto.getEntreprise().getSiret());

	}

}
