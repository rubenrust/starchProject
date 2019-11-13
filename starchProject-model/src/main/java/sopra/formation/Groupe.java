package sopra.formation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Groupe")
public class Groupe {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private Integer version;
	private String codeGroupe;
	private String nom;
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
	public String getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Groupe() {
		super();
	}
	
	
	
	
}
