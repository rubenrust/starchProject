package fr.starchProject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IFavorisRepository;
import sopra.formation.repository.ILieuxEvenementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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
		LieuxEvenement escapeGameFind = lieuxEvenementRepo.find(escapeGame.getId());

		footSalle = lieuxEvenementRepo.save(footSalle);
		LieuxEvenement footSalleFind = lieuxEvenementRepo.find(footSalle.getId());

		Assert.assertEquals((String) "escape game à bordeaux", escapeGame.getDescription());
		Assert.assertEquals((String) "28 rue dupuis", adresseEscapeGame.getRue());
		Assert.assertEquals((String) "Bordeaux", adresseEscapeGame.getVille());
		Assert.assertEquals((String) "33000", adresseEscapeGame.getCodePostal());

		Assert.assertEquals((String) "foot en salle à merignac", footSalle.getDescription());
		Assert.assertEquals((String) "26 rue dejean", adresseFootSalle.getRue());
		Assert.assertEquals((String) "Merignac", adresseFootSalle.getVille());
		Assert.assertEquals((String) "33400", adresseFootSalle.getCodePostal());

		int middleNumber = lieuxEvenementRepo.findAll().size();

		Assert.assertEquals(2, middleNumber - startNumber);

		lieuxEvenementRepo.delete(escapeGame);
		escapeGameFind = lieuxEvenementRepo.find(escapeGame.getId());
		Assert.assertNull(escapeGameFind);

		lieuxEvenementRepo.delete(footSalle);
		footSalleFind = lieuxEvenementRepo.find(footSalle.getId());
		Assert.assertNull(footSalleFind);

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

		LieuxEvenement escapeGameFind = lieuxEvenementRepo.find(escapeGame.getId());

		Assert.assertEquals(NomEvenement.Escape_game, escapeGameFind.getFavoris().getNomActivite());

	}

}
