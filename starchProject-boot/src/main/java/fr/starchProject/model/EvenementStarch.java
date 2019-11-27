package fr.starchProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table
public class EvenementStarch {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String titre;
	@JsonView(Views.ViewCommon.class)
	private Integer nbParticipantMax;
	@JsonView(Views.ViewCommon.class)
	private Integer prixStarch;
	@JsonView(Views.ViewCommon.class)
	private String description;
	@OneToMany(mappedBy = "evenementStarch")
	@JsonView(Views.ViewEvenementStarchDetail.class)
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewEvenementStarchDetail.class)
	private TypeEvenement typeEvenement;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewEvenementStarchDetail.class)
	private NomEvenement nomEvenement;
	@Embedded
	@JsonView(Views.ViewCommon.class)
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
