package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class TestWithJpa {

	public static void main(String[] args) throws ParseException {

		Adresse adresseEscapeGame = new Adresse();
		adresseEscapeGame.setRue("28 rue dupuis");
		adresseEscapeGame.setVille("Bordeaux");
		adresseEscapeGame.setCodePostal("33000");

		Adresse adresseFootSalle = new Adresse();
		adresseFootSalle.setRue("26 rue dejean");
		adresseFootSalle.setVille("Merignac");
		adresseFootSalle.setCodePostal("33400");

		ILieuxEvenementRepository lieuxRepo = Singleton.getInstance().getLieuxRepo();

		LieuxEvenement escapeGame = new LieuxEvenement();
		escapeGame.setAdresse(adresseEscapeGame);
		escapeGame.setDescription("foot en salle à bordeaux");

		LieuxEvenement footSalle = new LieuxEvenement();
		footSalle.setAdresse(adresseFootSalle);
		footSalle.setDescription("foot en salle à merignac");

		escapeGame = lieuxRepo.save(escapeGame);
		footSalle = lieuxRepo.save(footSalle);

		IEvenementStarchRepository evenementStarchRepo = Singleton.getInstance().getEvenementStarchRepo();

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

		IEntreprisesRepository entrepriseRepo = Singleton.getInstance().getEntrepriseRepo();

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

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");

		groupeToto = groupeRepo.save(groupeToto);

		IGroupeRepository groupeRepo = Singleton.getInstance().getGroupeRepo();

		Groupe groupeToto = new Groupe();
		groupeToto.setCodeGroupe("254785");
		groupeToto.setNom("Toto");
		groupeToto.setEntreprise(sopra);

		groupeToto = groupeRepo.save(groupeToto);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		IEvenementRepository evenementRepo = Singleton.getInstance().getEvenementRepo();

		Evenement evenementEscape = new Evenement();
		evenementEscape.setNbParticipantMax(25);
		evenementEscape.setNomEvenement(NomEvenement.Escape_game);
		evenementEscape.setTitre("escape game");
		evenementEscape.setDate(sdf.parse("09-06-2018"));
		evenementEscape.setLieuxEvenement(escapeGame);
		evenementEscape.setGroupe(groupeToto);

		Evenement evenementLaser = new Evenement();
		evenementLaser.setDate(sdf.parse("09-01-2017"));
		evenementLaser.setEvenementStarch(laserGame);
		evenementLaser.setEntreprise(sopra);

		evenementLaser = evenementRepo.save(evenementLaser);
		evenementEscape = evenementRepo.save(evenementEscape);
		evenementEscape.setEntreprise(sopra);

		ICommentaireRepository commentaireRepo = Singleton.getInstance().getCommentaireRepo();

		Commentaire commentaireRuben = new Commentaire();
		commentaireRuben.setCommentaire("à quelle heure ?");
		commentaireRuben.setEvenement(evenementLaser);

		Commentaire commentaireOriane = new Commentaire();
		commentaireOriane.setCommentaire("je peux venir accompagné ?");
		commentaireOriane.setEvenement(evenementEscape);

		commentaireRuben = commentaireRepo.save(commentaireRuben);
		commentaireOriane = commentaireRepo.save(commentaireOriane);

		IUtilisateurRepository utilisateurRepo = Singleton.getInstance().getUtilisateurRepo();

		Utilisateur ruben = new Utilisateur();
		ruben.setEmail("rust.ruben@gmail.com");
		ruben.setIdentifiant("rubenrust");
		ruben.setNom("rust");
		ruben.setPrenom("ruben");
		ruben.setTelephone("0632227403");
		ruben.setEntreprise(sopra);

		Utilisateur oriane = new Utilisateur();
		oriane.setEmail("oriane.galmar@gmail.com");
		oriane.setIdentifiant("orianegalmar");
		oriane.setNom("galmar");
		oriane.setPrenom("oriane");
		oriane.setTelephone("0621457485");
		oriane.setEntreprise(sopra);

		ruben = utilisateurRepo.save(ruben);
		oriane = utilisateurRepo.save(oriane);

		IParticipationRepository participationRepo = Singleton.getInstance().getParticipationRepo();

		Participation participationRuben = new Participation();
		participationRuben.setType(TypeParticipation.Participant);
		participationRuben.setEvenement(evenementLaser);
		participationRuben.setUtilisateur(ruben);

		Participation participationOriane = new Participation();
		participationOriane.setType(TypeParticipation.Organisateur);
		participationOriane.setEvenement(evenementEscape);
		participationOriane.setUtilisateur(oriane);

		participationRuben = participationRepo.save(participationRuben);
		participationOriane = participationRepo.save(participationOriane);

		IGestionRepository gestionRepo = Singleton.getInstance().getGestionRepo();

		Gestion gestionRuben = new Gestion();
		gestionRuben.setGestion(TypeGestion.Membre);
		gestionRuben.setGroupe(groupeToto);
		gestionRuben.setUtilisateur(ruben);

		Gestion gestionOriane = new Gestion();
		gestionOriane.setGestion(TypeGestion.Gestionnaire);
		gestionOriane.setGroupe(groupeToto);
		gestionOriane.setUtilisateur(oriane);

		gestionOriane = gestionRepo.save(gestionOriane);
		gestionRuben = gestionRepo.save(gestionRuben);

		IFavorisRepository favorisRepo = Singleton.getInstance().getFavorisRepo();

		Favoris favorisRuben = new Favoris();
		favorisRuben.setUtilisateur(ruben);
		favorisRuben.setNomActivite(NomEvenement.Escape_game);

		favorisRuben = favorisRepo.save(favorisRuben);

		escapeGame.setFavoris(favorisRuben);
		escapeGame = lieuxRepo.save(escapeGame);

		favorisRuben = favorisRepo.save(favorisRuben);
	}
}
