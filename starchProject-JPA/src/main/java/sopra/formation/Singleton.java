package sopra.formation;

public class Singleton {

	private static Singleton instance = null;
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("starchProject");
	
	private Singleton() {
		
	}
	
	
}
