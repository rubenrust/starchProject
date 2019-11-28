package fr.starchProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Gestion;
import fr.starchProject.model.Groupe;
import fr.starchProject.model.TypeGestion;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.repository.IGestionRepository;
import fr.starchProject.repository.IGroupeRepository;
import fr.starchProject.repository.IUtilisateurRepository;

@SpringBootTest
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
		Gestion gestionRubenFind = gestionRepo.findById(gestionRuben.getId()).get();

		assertEquals(TypeGestion.Membre, gestionRuben.getGestion());

		int middleNumber = gestionRepo.findAll().size();

		assertEquals(1, middleNumber - startNumber);

		gestionRepo.delete(gestionRuben);
		gestionRubenFind = gestionRepo.findById(gestionRuben.getId()).get();
		assertNull(gestionRubenFind);

	}

	@Test
	public void testGestionWithGroupe() {

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);

		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);

		gestionRuben.setGroupe(groupeToto);

		gestionRuben = gestionRepo.save(gestionRuben);

		Gestion gestionFind = gestionRepo.findById(gestionRuben.getId()).get();

		assertEquals("254785", gestionFind.getGroupe().getCodeGroupe());

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
		
		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);

		gestionRuben.setUtilisateur(ruben);

		gestionRuben = gestionRepo.save(gestionRuben);

		Gestion gestionFind = gestionRepo.findById(gestionRuben.getId()).get();

		assertEquals("rust", gestionFind.getUtilisateur().getNom());

	}

}
