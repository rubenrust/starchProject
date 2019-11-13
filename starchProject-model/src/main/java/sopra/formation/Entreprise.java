package sopra.formation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Entreprise")
public class Entreprise {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private Integer version;
	private String nom;
	private String codeEntreprise;
	private String siret;
	private String tva;
	@Transient
	private Adresse adresse;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCodeEntreprise() {
		return codeEntreprise;
	}
	public void setCodeEntreprise(String codeEntreprise) {
		this.codeEntreprise = codeEntreprise;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Entreprise() {
		super();
	}
	
	

}
