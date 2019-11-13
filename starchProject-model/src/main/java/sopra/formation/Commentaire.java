package sopra.formation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Commentaire")
public class Commentaire {
@Id
@GeneratedValue
private Long id;
@Version
private int version;
@Transient
private Utilisateur utilisateur;
private String commentaire;
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
