package fr.starchProject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Participation {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	@Enumerated(EnumType.STRING)
	private TypeParticipation type;
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.ViewParticipation.class)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="evenement_id")
	@JsonView(Views.ViewParticipation.class)
	private Evenement evenement;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	
	public Participation() {
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
	public TypeParticipation getType() {
		return type;
	}
	public void setType(TypeParticipation type) {
		this.type = type;
	}
	
}
