package fr.starchProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.repository.IEntreprisesRepository;
import sopra.formation.repository.IEvenementRepository;
import sopra.formation.repository.IEvenementStarchRepository;
import sopra.formation.repository.IGroupeRepository;
import sopra.formation.repository.ILieuxEvenementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class EvenementRepositorySpringTest {

	@Autowired
	private IEvenementRepository evenementRepo;
	
	@Autowired
	private IEvenementStarchRepository evenementStarchRepo;
	
	@Autowired
	private ILieuxEvenementRepository lieuxEvenementRepo;
	
	@Autowired
	private IEntreprisesRepository entrepriseRepo;
	
	@Autowired
	private IGroupeRepository groupeRepo;
	
	@Test
	public void testEvenement() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		int startNumber = evenementRepo.findAll().size();
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setDeadline(sdf.parse("07-06-2018"));
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals((Integer) 25, evenementEscapeFind.getNbParticipantMax());
		Assert.assertEquals("escape game", evenementEscapeFind.getTitre());
		Assert.assertEquals((Integer) 15, evenementEscapeFind.getPrix());
		
		int middleNumber = evenementRepo.findAll().size();
		
		Assert.assertEquals(1, middleNumber-startNumber);
		
		evenementRepo.delete(evenementEscapeFind);
		
		evenementEscapeFind = evenementRepo.find(evenementEscapeFind.getId());
		
		Assert.assertNull(evenementEscapeFind);
	}
	
	@Test
	public void testEvenementWithEvenementStarch() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		EvenementStarch laserGame = new EvenementStarch();
		laserGame.setTitre("laser game de fou");
		laserGame.setNbParticipantMax(20);
		laserGame.setPrixStarch(10);
		laserGame.setDescription("venez vous amuser");
		laserGame.setTypeEvenement(TypeEvenement.Corporate);
		laserGame.setNomEvenement(NomEvenement.Laser_game);

		Adresse adresseLaserGame = new Adresse();
		adresseLaserGame.setRue("25 rue dutertre");
		adresseLaserGame.setVille("merignac");
		adresseLaserGame.setCodePostal("33400");

		laserGame.setAdresse(adresseLaserGame);

		laserGame = evenementStarchRepo.save(laserGame);
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setDeadline(sdf.parse("07-06-2018"));
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape.setEvenementStarch(laserGame);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals("laser game de fou", evenementEscapeFind.getEvenementStarch().getTitre());
	}
	
	@Test
	public void testEvenementWithLieuxEvenement() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Adresse adresseEscapeGame = new Adresse();
		adresseEscapeGame.setRue("28 rue dupuis");
		adresseEscapeGame.setVille("Bordeaux");
		adresseEscapeGame.setCodePostal("33000");
		
		LieuxEvenement escapeGame = new LieuxEvenement();
		escapeGame.setAdresse(adresseEscapeGame);
		escapeGame.setDescription("foot en salle à bordeaux");
		
		escapeGame = lieuxEvenementRepo.save(escapeGame);
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setDeadline(sdf.parse("07-06-2018"));
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape.setLieuxEvenement(escapeGame);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals("foot en salle à bordeaux", evenementEscapeFind.getLieuxEvenement().getDescription());
	}
	
	@Test
	public void testEvenementWithEntreprise() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
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
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setDeadline(sdf.parse("07-06-2018"));
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape.setEntreprise(sopra);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals("sopra steria", evenementEscapeFind.getEntreprise().getNom());
	}
	
	@Test
	public void testEvenementWithGroupe(){
		
		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);
		
		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setPrix(15);
		evenementEscape.setRecurrence(Recurrence.Monthly);
		
		evenementEscape.setGroupe(groupeToto);
		
		evenementEscape = evenementRepo.save(evenementEscape);
		
		Evenement evenementEscapeFind = evenementRepo.find(evenementEscape.getId());
		
		Assert.assertEquals("Toto", evenementEscapeFind.getGroupe().getNom());
	}
}
