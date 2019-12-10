package fr.starchProject.repository;

import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.TypeEvenement;

public class SearchCriteria {
	private Long idEntreprise = null;
	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	private Long idGroupe = null;
	private TypeEvenement typeEvenement = null;
	private NomEvenement nomEvenement = null;

	public SearchCriteria() {
		super();
	}

	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
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

}
