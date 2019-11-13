package sopra.formation;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.ICommentaireRepository;
import sopra.formation.repository.IEntreprisesRepository;
import sopra.formation.repository.IEvenementRepository;
import sopra.formation.repository.IEvenementStarchRepository;
import sopra.formation.repository.IFavorisRepository;
import sopra.formation.repository.IGestionRepository;
import sopra.formation.repository.IGroupeRepository;
import sopra.formation.repository.ILieuxEvenementRepository;
import sopra.formation.repository.IParticipationRepository;
import sopra.formation.repository.IUtilisateurRepository;
import sopra.formation.repository.jpa.CommentaireRepositoryJpa;
import sopra.formation.repository.jpa.EntrepriseRepositoryJpa;
import sopra.formation.repository.jpa.EvenementRepositoryJpa;
import sopra.formation.repository.jpa.EvenementStarchRepositoryJpa;
import sopra.formation.repository.jpa.FavorisRepositoryJpa;
import sopra.formation.repository.jpa.GestionRepositoryJpa;
import sopra.formation.repository.jpa.GroupeRepositoryJpa;
import sopra.formation.repository.jpa.LieuxEvenementRepositoryJpa;
import sopra.formation.repository.jpa.ParticipationRepositoryJpa;
import sopra.formation.repository.jpa.UtilisateurRepositoryJpa;

public class Singleton {

	private static Singleton instance = null;
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("starchProject");
	
	private final IEntreprisesRepository entrepriseRepo = new EntrepriseRepositoryJpa();
	
	private final IEvenementRepository evenementRepo = new EvenementRepositoryJpa();
	
	private final IEvenementStarchRepository evenementStarchRepo = new EvenementStarchRepositoryJpa();
	
	private final IFavorisRepository favorisRepo = new FavorisRepositoryJpa();
	
	private final IGestionRepository gestionRepo = new GestionRepositoryJpa();
	
	private final IGroupeRepository groupeRepo = new GroupeRepositoryJpa();
	
	private final ILieuxEvenementRepository lieuxRepo = new LieuxEvenementRepositoryJpa();
	
	private final IParticipationRepository participationRepo = new ParticipationRepositoryJpa();
	
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	
	

	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		
		return instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IEntreprisesRepository getEntrepriseRepo() {
		return entrepriseRepo;
	}

	public IEvenementRepository getEvenementRepo() {
		return evenementRepo;
	}

	public IEvenementStarchRepository getEvenementStarchRepo() {
		return evenementStarchRepo;
	}

	public IFavorisRepository getFavorisRepo() {
		return favorisRepo;
	}

	public IGestionRepository getGestionRepo() {
		return gestionRepo;
	}

	public IGroupeRepository getGroupeRepo() {
		return groupeRepo;
	}

	public ILieuxEvenementRepository getLieuxRepo() {
		return lieuxRepo;
	}

	public IParticipationRepository getParticipationRepo() {
		return participationRepo;
	}

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}
	
}
