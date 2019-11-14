package sopra.formation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table
public class Groupe {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private Integer version;
	private String codeGroupe;
	private String nom;
	@OneToMany(mappedBy = "groupe")
	private List<Evenement> evenement = new ArrayList<Evenement>();
	public List<Evenement> getEvenement() {
		return evenement;
	}
	public void setEvenement(List<Evenement> evenement) {
		this.evenement = evenement;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public List<Gestion> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Gestion> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@ManyToOne
	@JoinColumn(name="entreprise_id")
	private Entreprise entreprise;
	@Transient
	private List<Gestion> utilisateurs= new ArrayList<Gestion>();
	
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
