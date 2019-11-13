package sopra.formation;

import java.util.ArrayList;
import java.util.List;

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
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
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
