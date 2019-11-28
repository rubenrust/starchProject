package fr.starchProject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Favoris {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private NomEvenement nomActivite;
	@OneToOne
	@JoinColumn(name ="lieuxEvenement_id")
	@JsonView(Views.ViewCommon.class)
	private LieuxEvenement lieuxEvenement;
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.ViewCommon.class)
	private Utilisateur utilisateur;
	@JsonView(Views.ViewCommon.class)
	private TypeFavoris typeFavoris;
	
	public Favoris() {
		super();
	}

	public TypeFavoris getTypeFavoris() {
		return typeFavoris;
	}

	public void setTypeFavoris(TypeFavoris typeFavoris) {
		this.typeFavoris = typeFavoris;
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

	public LieuxEvenement getLieuxEvenement() {
		return lieuxEvenement;
	}

	public void setLieuxEvenement(LieuxEvenement lieuxEvenement) {
		this.lieuxEvenement = lieuxEvenement;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public NomEvenement getNomActivite() {
		return nomActivite;
	}

	public void setNomActivite(NomEvenement nomActivite) {
		this.nomActivite = nomActivite;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}




	
	
}
