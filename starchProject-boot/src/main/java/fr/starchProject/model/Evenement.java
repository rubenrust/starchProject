package fr.starchProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Evenement {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String titre;
	@JsonView(Views.ViewCommon.class)
	@Temporal(TemporalType.DATE)
	private Date date;
	@JsonView(Views.ViewCommon.class)
	private Integer nbParticipantMax;
	@JsonView(Views.ViewCommon.class)
	private Integer prix;
	@JsonView(Views.ViewCommon.class)
	private Boolean statutOf;
	@JsonView(Views.ViewCommon.class)
	@Temporal(TemporalType.DATE)
	private Date deadline;
	@JsonView(Views.ViewCommon.class)
	@Enumerated(EnumType.STRING)
	private Recurrence recurrence;
	@JsonView(Views.ViewCommon.class)
	@Enumerated(EnumType.STRING)
	private TypeEvenement typeEvenement;
	@JsonView(Views.ViewCommon.class)
	@Enumerated(EnumType.STRING)
	private NomEvenement nomEvenement;
	@OneToMany(mappedBy = "evenement", fetch = FetchType.EAGER)
	@JsonView(Views.ViewEvenementDetail.class)
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	@OneToMany(mappedBy = "evenement")
	@JsonView(Views.ViewEvenementDetail.class)
	private List<Participation> participations = new ArrayList<Participation>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evenementStarch_id")
	@JsonView(Views.ViewEvenementDetail.class)
	private EvenementStarch evenementStarch;
	@ManyToOne
	@JoinColumn(name = "lieuxEvenement_id")
	@JsonView(Views.ViewEvenementDetail.class)
	private LieuxEvenement lieuxEvenement;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entreprise_id")
	@JsonView(Views.ViewEvenementDetail.class)
	private Entreprise entreprise;
	@ManyToOne
	@JoinColumn(name = "groupe_id")
	@JsonView(Views.ViewEvenementDetail.class)
	private Groupe groupe;

	public EvenementStarch getEvenementStarch() {
		return evenementStarch;
	}

	public void setEvenementStarch(EvenementStarch evenementStarch) {
		this.evenementStarch = evenementStarch;
	}

	public LieuxEvenement getLieuxEvenement() {
		return lieuxEvenement;
	}

	public void setLieuxEvenement(LieuxEvenement lieuxEvenement) {
		this.lieuxEvenement = lieuxEvenement;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

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
