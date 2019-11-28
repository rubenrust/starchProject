package fr.starchProject;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Adresse;
import fr.starchProject.model.Entreprise;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.repository.IEntrepriseRepository;
import fr.starchProject.repository.IUtilisateurRepository;

@SpringBootTest
public class UtilisateurRepositorySpringTest {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	@Autowired
	private IEntrepriseRepository entrepriseRepo;

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
		Utilisateur rubenFind = utilisateurRepo.findById(ruben.getId()).get();

		assertEquals((String) "rust.ruben@gmail.com", ruben.getEmail());
		assertEquals((String) "rubenrust", ruben.getIdentifiant());
		assertEquals((String) "rust", ruben.getNom());
		assertEquals((String) "ruben", ruben.getPrenom());
		assertEquals((String) "0632227403", ruben.getTelephone());

		int middleNumber = utilisateurRepo.findAll().size();

		utilisateurRepo.delete(ruben);
		rubenFind = utilisateurRepo.findById(ruben.getId()).get();
		assertNull(rubenFind);
	}

	@Test
	public void testUtilisateurwithEntreprise() {
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

		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");
		ruben.setEntreprise(sopra);

		ruben = utilisateurRepo.save(ruben);

		Utilisateur rubenFind = utilisateurRepo.findById(ruben.getId()).get();

		assertEquals("sopra steria", ruben.getEntreprise().getNom());
	}

}
