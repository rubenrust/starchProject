package sopra.formation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table
public class Commentaire {
@Id
@GeneratedValue
private Long id;
@Version
private Integer version;
@ManyToOne
@JoinColumn(name="utilisateur_id")
private Utilisateur utilisateur;
private String commentaire;
@ManyToOne
@JoinColumn(name="evenement_id")
private Evenement evenement;

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
