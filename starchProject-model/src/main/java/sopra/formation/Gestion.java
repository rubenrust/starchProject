package sopra.formation;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;


@Entity
@Table(name = "Gestion")
public class Gestion {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TypeGestion gestion;
	@Version
	private int version;
	@Transient
	private Utilisateur utilisateurs;
	@Transient
	private Groupe groupe;
	

	

	public Utilisateur getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public TypeGestion getGestion() {
		return gestion;
	}
	public void setGestion(TypeGestion gestion) {
		this.gestion = gestion;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Gestion() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
