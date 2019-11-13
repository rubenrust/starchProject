package sopra.formation;

public class EvenementStarch {
	private Long id;
	private int version;
	private String titre;
	private Integer nbParticipantMax;
	private Integer prixStarch;
	private String description;
	private TypeEvenement typeEvenement;
	private NomEvenement nomEvenement;
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
