package sopra.formation;

public class Favoris {

	private Long id;
	
	private int version;
	
	private NomEvenement nomActivite;
	
	private LieuxEvenement nomLieu;

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
