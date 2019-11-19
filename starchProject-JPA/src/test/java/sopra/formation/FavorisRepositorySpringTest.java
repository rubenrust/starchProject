package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IFavorisRepository;
import sopra.formation.repository.ILieuxEvenementRepository;
import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class FavorisRepositorySpringTest {

	@Autowired
	private IFavorisRepository favorisRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Autowired
	private ILieuxEvenementRepository lieuxEvenementRepo;
	
	@Test
	public void testFavoris() {

		int startNumber = favorisRepo.findAll().size();

		Favoris favorisRuben = new Favoris();
		favorisRuben.setNomActivite(NomEvenement.Escape_game);

		favorisRuben = favorisRepo.save(favorisRuben);
		Favoris favorisRubenFind = favorisRepo.find(favorisRuben.getId());

		Assert.assertEquals(NomEvenement.Escape_game, favorisRuben.getNomActivite());

		int middleNumber = favorisRepo.findAll().size();

		favorisRepo.delete(favorisRuben);
		favorisRubenFind = favorisRepo.find(favorisRuben.getId());
		Assert.assertNull(favorisRubenFind);

	}
	
	@Test
	public void testFavorisWithUtilisateur() {
	Utilisateur Arnaud = new Utilisateur();
	Arnaud.setPrenom("Arnaud");
	Arnaud.setNom("MICHEL");
	Arnaud.setIdentifiant("amichel");
	Arnaud.setTelephone("0609222017");
	Arnaud.setEmail("frfmichel@gmail.com");
	
	Arnaud = utilisateurRepo.save(Arnaud);
	
	Favoris favorisArnaud = new Favoris();
	favorisArnaud.setNomActivite(NomEvenement.Escape_game);
	favorisArnaud.setUtilisateur(Arnaud);
	
	favorisArnaud = favorisRepo.save(favorisArnaud);
	Favoris FavorisArnaudFind = favorisRepo.find(favorisArnaud.getId());
	Assert.assertEquals("", FavorisArnaudFind.getUtilisateur().getNom());
	}
	
	@Test
	public void testFavorisWithNomLieux() {
		
		
		LieuxEvenement escapeGame = new LieuxEvenement();
		escapeGame.setDescription("Escape game de fou à Merignac");
		LieuxEvenement footSalle = new LieuxEvenement();

		escapeGame = lieuxEvenementRepo.save(escapeGame);
		footSalle = lieuxEvenementRepo.save(footSalle);
		
		
	
	Favoris favorisArnaud = new Favoris();
	favorisArnaud.setNomActivite(NomEvenement.Escape_game);
//	favorisArnaud.setLieuxEvenement(0);
//	
	favorisArnaud = favorisRepo.save(favorisArnaud);
	Favoris FavorisArnaudFind = favorisRepo.find(favorisArnaud.getId());
	Assert.assertEquals("", FavorisArnaudFind.getLieuxEvenement().get(0));
	Assert.assertEquals("", FavorisArnaudFind.getLieuxEvenement().get(1));
	
}
}
