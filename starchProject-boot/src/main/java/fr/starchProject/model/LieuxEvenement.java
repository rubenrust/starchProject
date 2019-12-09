package fr.starchProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class LieuxEvenement {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nomLieu;
	@JsonView(Views.ViewCommon.class)
	private String description;
	@Embedded
	@JsonView(Views.ViewCommon.class)
	private Adresse adresse;
	@OneToMany(mappedBy = "lieuxEvenement")
	@JsonView(Views.ViewLieuxEvenementDetail.class)
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@OneToOne(mappedBy = "lieuxEvenement")
	@JsonView(Views.ViewLieuxEvenementDetail.class)
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

	public LieuxEvenement(Long id, int version, String nomLieu, String description) {
		super();
		this.id = id;
		this.version = version;
		this.nomLieu = nomLieu;
		this.description = description;
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

	public String getNomLieu() {
		return nomLieu;
	}

	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}

}
