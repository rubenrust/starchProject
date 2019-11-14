package sopra.formation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table
public class LieuxEvenement {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String nom;
	private String description;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "lieuxEvenement")
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@ManyToOne
	@JoinColumn(name="favoris_id")
	private Favoris favoris;
	
	public Favoris getFavoris() {
		return favoris;
	}
	public void setFavoris(Favoris favoris) {
		this.favoris = favoris;
	}
	public List<Evenement> getEvenements() {
		return evenements;
	}
	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}
	public LieuxEvenement() {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
