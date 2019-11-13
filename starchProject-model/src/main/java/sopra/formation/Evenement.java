package sopra.formation;

import java.util.Date;

public class Evenement {
	private Long id;
	private int version;
	private String titre;
	private Date date;
	private Integer nbParticipantMax;
	private Integer prix;
	private Date deadline;
	private Recurrence recurrence;
	private TypeEvenement typeEvenement;
	private NomEvenement nomEvenement;
	
	
	
	
	public Evenement() {
		super();
	}
	
	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNbParticipantMax() {
		return nbParticipantMax;
	}
	public void setNbParticipantMax(Integer nbParticipantMax) {
		this.nbParticipantMax = nbParticipantMax;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Recurrence getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(Recurrence recurrence) {
		this.recurrence = recurrence;
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
