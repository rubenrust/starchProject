package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.ICommentaireRepository;
import sopra.formation.repository.IEvenementRepository;
import sopra.formation.repository.IUtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class CommentaireRepositorySpringTest {

	@Autowired
	private ICommentaireRepository commentaireRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Autowired
	private IEvenementRepository evenementRepo;
	
	@Test
	public void testCommentaire() {
		
		int startNumber = commentaireRepo.findAll().size();
		
		Commentaire commentaireRuben = new Commentaire();
		commentaireRuben.setCommentaire("à quelle heure ?");

		Commentaire commentaireOriane = new Commentaire();
		commentaireOriane.setCommentaire("je peux venir accompagné ?");

		commentaireRuben = commentaireRepo.save(commentaireRuben);
		commentaireOriane = commentaireRepo.save(commentaireOriane);
		
		Commentaire commentaireRubenFind = commentaireRepo.find(commentaireRuben.getId());
		Commentaire commentaireOrianeFind = commentaireRepo.find(commentaireOriane.getId());
		
		Assert.assertEquals("à quelle heure ?", commentaireRubenFind.getCommentaire());
		Assert.assertEquals("je peux venir accompagné ?", commentaireOrianeFind.getCommentaire());
		
		int middleNumber = commentaireRepo.findAll().size();
		
		Assert.assertEquals(2, middleNumber - startNumber);
		
		commentaireRepo.delete(commentaireRubenFind);
		
		commentaireRubenFind = commentaireRepo.find(commentaireRubenFind.getId());
		
		Assert.assertNull(commentaireRubenFind);
		
	}
	
	@Test
	public void testCommentaireWithUtilisateur() {
		
		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");
		
		ruben = utilisateurRepo.save(ruben);
		
		Commentaire commentaireRuben = new Commentaire();
		commentaireRuben.setCommentaire("à quelle heure ?");
		
		commentaireRuben.setUtilisateur(ruben);
		
		commentaireRuben = commentaireRepo.save(commentaireRuben);
		
		Commentaire commentaireRubenFind = commentaireRepo.find(commentaireRuben.getId());
		
		Assert.assertEquals("rubenrust", commentaireRubenFind.getUtilisateur().getIdentifiant());
	}
	
	
//	@Test
//	public void testCommentaireWithEvenement() {
//		
//		Evenement evenementEscape = new Evenement();
//		evenementEscape.setNbParticipantMax(25);
//		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
//		evenementEscape.setTitre("escape game");
//		
//		evenementEscape = evenementRepo.save(evenementEscape);
//		
//		Commentaire commentaireRuben = new Commentaire();
//		commentaireRuben.setCommentaire("à quelle heure ?");
//		
//		commentaireRuben.setEvenement(evenementEscape);
//		
//		commentaireRuben = commentaireRepo.save(commentaireRuben);
//		
//		Commentaire commentaireRubenFind = commentaireRepo.find(commentaireRuben.getId());
//		
//		Assert.assertEquals("escape game", commentaireRubenFind.getEvenement().getTitre());
//	}
	
}
