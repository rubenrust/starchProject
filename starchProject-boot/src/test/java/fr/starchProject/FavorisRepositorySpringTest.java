package fr.starchProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Favoris;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.repository.IFavorisRepository;
import fr.starchProject.repository.ILieuxEvenementRepository;
import fr.starchProject.repository.IUtilisateurRepository;

@SpringBootTest
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
		Favoris favorisRubenFind = favorisRepo.findById(favorisRuben.getId()).get();

		assertEquals(NomEvenement.Escape_game, favorisRuben.getNomActivite());

		int middleNumber = favorisRepo.findAll().size();

		favorisRepo.delete(favorisRuben);
		favorisRubenFind = favorisRepo.findById(favorisRuben.getId()).get();
		assertNull(favorisRubenFind);

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
	Favoris FavorisArnaudFind = favorisRepo.findById(favorisArnaud.getId()).get();
	assertEquals("MICHEL", FavorisArnaudFind.getUtilisateur().getNom());
	}
	
	
//	@Test
//	public void testFavorisWithNomLieux() {
//		
//		
//		LieuxEvenement escapeGame = new LieuxEvenement();
//		escapeGame.setDescription("Escape game de fou à Merignac");
//		LieuxEvenement footSalle = new LieuxEvenement();
//
//		escapeGame = lieuxEvenementRepo.save(escapeGame);
//		footSalle = lieuxEvenementRepo.save(footSalle);
//		
//		
//	
//	Favoris favorisArnaud = new Favoris();
//	favorisArnaud.setNomActivite(NomEvenement.Escape_game);
//
//	
//	favorisArnaud = favorisRepo.save(favorisArnaud);
//	Favoris FavorisArnaudFind = favorisRepo.findById(favorisArnaud.getId()).get();
//	Assert.assertEquals("", FavorisArnaudFind.getLieuxEvenement().get(0));
//	Assert.assertEquals("", FavorisArnaudFind.getLieuxEvenement().get(1));
//	
//}
}
