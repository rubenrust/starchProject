package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.ICommentaireRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class CommentaireRepositorySpringTest {

	@Autowired
	private ICommentaireRepository commentaireRepo;
	
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
}
