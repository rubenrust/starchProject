package sopra.formation;

public class Commentaire {
	
private Long id;
private Integer version;
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
