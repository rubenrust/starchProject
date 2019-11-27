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

@Entity
@Table(name = "Entreprise")
public class Entreprise {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String nom;
	private String codeEntreprise;
	private String siret;
	private String tva;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "entreprise")
	private List<Groupe> groupes = new ArrayList<Groupe>();
	@OneToMany(mappedBy = "entreprise")
	private List<Evenement> evenements = new ArrayList<Evenement>();
	@OneToMany(mappedBy="entreprise")
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
