package fr.starchProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "Entreprise")
public class Entreprise {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String codeEntreprise;
	@JsonView(Views.ViewCommon.class)
	private String siret;
	@JsonView(Views.ViewCommon.class)
	private String tva;
	@Embedded
	@JsonView(Views.ViewCommon.class)
	private Adresse adresse;
	@OneToMany(mappedBy = "entreprise")
	@JsonView(Views.ViewEntrepriseGroupe.class)
	private List<Groupe> groupes = new ArrayList<Groupe>();
	@OneToMany(mappedBy = "entreprise")
	@JsonView(Views.ViewEntrepriseEvenement.class)
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@OneToMany(mappedBy="entreprise")
	@JsonView(Views.ViewEntrepriseUtilisateur.class)
	private List<Utilisateur> collaborateurs = new ArrayList<Utilisateur>();


	
	
	public List<Evenement> getEvenements() {
		return evenements;
	}
	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}
	public List<Utilisateur> getColaborateurs() {
		return collaborateurs;
	}
	public void setColaborateurs(List<Utilisateur> colaborateurs) {
		this.collaborateurs = colaborateurs;
	}
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	public void setVersion(int version) {
		this.version = version;
	}
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
