package sopra.formation;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

public class Participation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Transient
	private TypeParticipation type;
	
	public Participation() {
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
	public TypeParticipation getType() {
		return type;
	}
	public void setType(TypeParticipation type) {
		this.type = type;
	}
	
}
