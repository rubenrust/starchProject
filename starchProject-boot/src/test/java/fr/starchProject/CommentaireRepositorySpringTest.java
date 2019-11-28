package fr.starchProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.starchProject.model.Commentaire;
import fr.starchProject.model.Evenement;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.Utilisateur;
import fr.starchProject.repository.ICommentaireRepository;
import fr.starchProject.repository.IEvenementRepository;
import fr.starchProject.repository.IUtilisateurRepository;


@SpringBootTest
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
		
		Commentaire commentaireRubenFind = commentaireRepo.findById(commentaireRuben.getId()).get();
		Commentaire commentaireOrianeFind = commentaireRepo.findById(commentaireOriane.getId()).get();
		
		assertEquals("à quelle heure ?", commentaireRubenFind.getCommentaire());
		assertEquals("je peux venir accompagné ?", commentaireOrianeFind.getCommentaire());
		
		int middleNumber = commentaireRepo.findAll().size();
		
		assertEquals(2, middleNumber - startNumber);
		
		commentaireRepo.delete(commentaireRubenFind);
		
		commentaireRubenFind = commentaireRepo.findById(commentaireRubenFind.getId()).get();
		
		assertNull(commentaireRubenFind);
		
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
		
		Commentaire commentaireRubenFind = commentaireRepo.findById(commentaireRuben.getId()).get();
		
		assertEquals("rubenrust", commentaireRubenFind.getUtilisateur().getIdentifiant());
	}
	
	
	@Test
	public void testCommentaireWithEvenement() {
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Commentaire commentaireRuben = new Commentaire();
		commentaireRuben.setCommentaire("à quelle heure ?");
		
		commentaireRuben.setEvenement(evenementEscape);
		
		commentaireRuben = commentaireRepo.save(commentaireRuben);
		
		Commentaire commentaireRubenFind = commentaireRepo.findById(commentaireRuben.getId()).get();
		
		assertEquals("escape game", commentaireRubenFind.getEvenement().getTitre());
	}
	
}
