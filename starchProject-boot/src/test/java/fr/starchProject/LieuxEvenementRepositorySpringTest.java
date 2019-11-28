package fr.starchProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Adresse;
import fr.starchProject.model.Favoris;
import fr.starchProject.model.LieuxEvenement;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.repository.IFavorisRepository;
import fr.starchProject.repository.ILieuxEvenementRepository;

@SpringBootTest
public class LieuxEvenementRepositorySpringTest {

	@Autowired
	private ILieuxEvenementRepository lieuxEvenementRepo;
	@Autowired
	private IFavorisRepository favorisRepo;

	@Test
	public void testLieuxEvenement() {

		int startNumber = lieuxEvenementRepo.findAll().size();

		Adresse adresseEscapeGame = new Adresse();
		adresseEscapeGame.setRue("28 rue dupuis");
		adresseEscapeGame.setVille("Bordeaux");
		adresseEscapeGame.setCodePostal("33000");

		Adresse adresseFootSalle = new Adresse();
		adresseFootSalle.setRue("26 rue dejean");
		adresseFootSalle.setVille("Merignac");
		adresseFootSalle.setCodePostal("33400");

		LieuxEvenement escapeGame = new LieuxEvenement();
		escapeGame.setAdresse(adresseEscapeGame);
		escapeGame.setDescription("escape game à bordeaux");

		LieuxEvenement footSalle = new LieuxEvenement();
		footSalle.setAdresse(adresseFootSalle);
		footSalle.setDescription("foot en salle à merignac");

		escapeGame = lieuxEvenementRepo.save(escapeGame);
		LieuxEvenement escapeGameFind = lieuxEvenementRepo.findById(escapeGame.getId()).get();

		footSalle = lieuxEvenementRepo.save(footSalle);
		LieuxEvenement footSalleFind = lieuxEvenementRepo.findById(footSalle.getId()).get();

		assertEquals((String) "escape game à bordeaux", escapeGame.getDescription());
		assertEquals((String) "28 rue dupuis", adresseEscapeGame.getRue());
		assertEquals((String) "Bordeaux", adresseEscapeGame.getVille());
		assertEquals((String) "33000", adresseEscapeGame.getCodePostal());

		assertEquals((String) "foot en salle à merignac", footSalle.getDescription());
		assertEquals((String) "26 rue dejean", adresseFootSalle.getRue());
		assertEquals((String) "Merignac", adresseFootSalle.getVille());
		assertEquals((String) "33400", adresseFootSalle.getCodePostal());

		int middleNumber = lieuxEvenementRepo.findAll().size();

		assertEquals(2, middleNumber - startNumber);

		lieuxEvenementRepo.delete(escapeGame);
		escapeGameFind = lieuxEvenementRepo.findById(escapeGame.getId()).get();
		assertNull(escapeGameFind);

		lieuxEvenementRepo.delete(footSalle);
		footSalleFind = lieuxEvenementRepo.findById(footSalle.getId()).get();
		assertNull(footSalleFind);

	}

	@Test
	public void testLieuxEvenementWithFavoris() {

		Favoris escape = new Favoris();
		escape.setNomActivite(NomEvenement.Escape_game);

		escape = favorisRepo.save(escape);

		Adresse adresseEscapeGame = new Adresse();
		adresseEscapeGame.setRue("28 rue dupuis");
		adresseEscapeGame.setVille("Bordeaux");
		adresseEscapeGame.setCodePostal("33000");

		LieuxEvenement escapeGame = new LieuxEvenement();
		escapeGame.setAdresse(adresseEscapeGame);
		escapeGame.setDescription("escape game à bordeaux");

		escapeGame.setFavoris(escape);

		escapeGame = lieuxEvenementRepo.save(escapeGame);

		LieuxEvenement escapeGameFind = lieuxEvenementRepo.findById(escapeGame.getId()).get();

		assertEquals(NomEvenement.Escape_game, escapeGameFind.getFavoris().getNomActivite());

	}

}
