package fr.starchProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Entreprise;
import fr.starchProject.model.Groupe;
import fr.starchProject.repository.IEntrepriseRepository;
import fr.starchProject.repository.IGroupeRepository;

@SpringBootTest
public class GroupeRepositorySpringTest {

	@Autowired
	private IGroupeRepository groupeRepo;
	@Autowired
	private IEntrepriseRepository entrepriseRepo;

	@Test
	public void testGroupe() {

		int startNumber = groupeRepo.findAll().size();

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);
		Groupe groupeTotoFind = groupeRepo.findById(groupeToto.getId()).get();

		assertEquals((String) "254785", groupeToto.getCodeGroupe());
		assertEquals((String) "Toto", groupeToto.getNom());

		int middleNumber = groupeRepo.findAll().size();

		assertEquals(1, middleNumber - startNumber);

		groupeRepo.delete(groupeToto);

		groupeTotoFind = groupeRepo.findById(groupeToto.getId()).get();

		assertNull(groupeTotoFind);

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

		Groupe groupeTotoFind = groupeRepo.findById(groupeToto.getId()).get();

		assertEquals("4715564558855", groupeToto.getEntreprise().getSiret());

	}

}
