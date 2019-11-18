package sopra.formation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IFavorisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class FavorisRepositorySpringTest {

	@Autowired
	private IFavorisRepository favorisRepo;

	@Test
	public void testUtilisateur() {

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

}
