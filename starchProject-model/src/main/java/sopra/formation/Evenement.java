package sopra.formation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table
public class Evenement {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String titre;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer nbParticipantMax;
	private Integer prix;
	@Temporal(TemporalType.DATE)
	private Date deadline;
	@Enumerated(EnumType.STRING)
	private Recurrence recurrence;
	@Enumerated(EnumType.STRING)
	private TypeEvenement typeEvenement;
	@Enumerated(EnumType.STRING)
	private NomEvenement nomEvenement;
	@Transient
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	@Transient
	private List<Participation> participations = new ArrayList<Participation>();
	@Transient
	private EvenementStarch evenementStarch;
	@Transient
	private LieuxEvenement lieuxevenement;
	@Transient
	private Entreprise entreprise;
	@Transient
	private Groupe groupe;

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public Evenement() {
		super();
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
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
