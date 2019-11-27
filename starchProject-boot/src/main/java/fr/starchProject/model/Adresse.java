package fr.starchProject.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@JsonView(Views.ViewCommon.class)
	private String rue;
	@JsonView(Views.ViewCommon.class)
	private String complement;
	@JsonView(Views.ViewCommon.class)
	private String codePostal;
	@JsonView(Views.ViewCommon.class)
	private String ville;

	public Adresse() {
		super();
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
