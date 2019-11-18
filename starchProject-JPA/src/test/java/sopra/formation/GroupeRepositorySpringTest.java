package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IGroupeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class GroupeRepositorySpringTest {

	@Autowired
	private IGroupeRepository groupeRepo;

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

		groupeRepo.delete(groupeToto);

		groupeTotoFind = groupeRepo.find(groupeToto.getId());

		Assert.assertNull(groupeTotoFind);

	}

}
