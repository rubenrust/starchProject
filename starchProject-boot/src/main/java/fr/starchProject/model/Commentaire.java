package fr.starchProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Commentaire {
@Id
@GeneratedValue
@JsonView(Views.ViewCommon.class)
private Long id;
@Version
@JsonView(Views.ViewCommon.class)
private Integer version;
@JsonView(Views.ViewCommon.class)
private String commentaire;
@ManyToOne
@JoinColumn(name="utilisateur_id")
private Utilisateur utilisateur;
@ManyToOne
@JoinColumn(name="evenement_id")
private Evenement evenement;

public Evenement getEvenement() {
	return evenement;
}
public void setEvenement(Evenement evenement) {
	this.evenement = evenement;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Integer getVersion() {
	return version;
}
public void setVersion(Integer version) {
	this.version = version;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public String getCommentaire() {
	return commentaire;
}
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}
public Commentaire() {
	super();
}





}
