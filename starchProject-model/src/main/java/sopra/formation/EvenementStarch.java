package sopra.formation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;


@Entity
@Table
public class EvenementStarch {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String titre;
	private Integer nbParticipantMax;
	private Integer prixStarch;
	private String description;
	@Transient
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@Enumerated(EnumType.STRING)
	private TypeEvenement typeEvenement;
	@Enumerated(EnumType.STRING)
	private NomEvenement nomEvenement;
	@Embedded
	private Adresse adresse;
	
	
	
	public EvenementStarch() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Evenement> getEvenements() {
		return evenements;
	}
	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Integer getNbParticipantMax() {
		return nbParticipantMax;
	}
	public void setNbParticipantMax(Integer nbParticipantMax) {
		this.nbParticipantMax = nbParticipantMax;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TypeEvenement getTypeEvenement() {
		return typeEvenement;
	}
	public void setTypeEvenement(TypeEvenement typeEvenement) {
		this.typeEvenement = typeEvenement;
	}
	public NomEvenement getNomEvenement() {
		return nomEvenement;
	}
	public void setNomEvenement(NomEvenement nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Integer getPrixStarch() {
		return prixStarch;
	}
	public void setPrixStarch(Integer prixStarch) {
		this.prixStarch = prixStarch;
	}
	

}
