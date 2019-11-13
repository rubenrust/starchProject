package sopra.formation;

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
public class Favoris {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	private NomEvenement nomActivite;
	@Enumerated(EnumType.STRING)
	private LieuxEvenement nomLieu;
	@Transient
	private Utilisateur utilisateur;

	public Favoris() {
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

	public NomEvenement getNomActivite() {
		return nomActivite;
	}

	public void setNomActivite(NomEvenement nomActivite) {
		this.nomActivite = nomActivite;
	}

	public LieuxEvenement getNomLieu() {
		return nomLieu;
	}

	public void setNomLieu(LieuxEvenement nomLieu) {
		this.nomLieu = nomLieu;
	}
	
	
}
