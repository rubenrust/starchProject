package fr.starchProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Utilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private String email;
	@JsonView(Views.ViewCommon.class)
	private String identifiant;
	@JsonView(Views.ViewCommon.class)
	private String mdp;
	@JsonView(Views.ViewCommon.class)
	private String telephone;
	@JsonView(Views.ViewCommon.class)
	private boolean admin;
	@ManyToOne
	@JoinColumn(name="entreprise_id")
	private Entreprise entreprise ;
	@OneToMany(mappedBy="utilisateur")
	private List<Gestion> gestion = new ArrayList<Gestion>() ;
	@OneToMany(mappedBy="utilisateur")
	private List<Participation> participation =new ArrayList<Participation>();
	@OneToMany(mappedBy="utilisateur")
	private  List<Favoris> favoris = new ArrayList<Favoris>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	
	public Utilisateur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getmdp() {
		return mdp;
	}

	public void setmdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}



	public List<Gestion> getGestion() {
		return gestion;
	}

	public void setGestion(List<Gestion> gestion) {
		this.gestion = gestion;
	}

	public List<Participation> getParticipation() {
		return participation;
	}

	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}
	
	
	
}
