package fr.starchProject.model;

public class Views {

	
	//Rajouter les vues
	public static class ViewCommon {
		
	}
	
	public static class ViewEntreprise extends ViewCommon{	
	}
	public static class ViewEntrepriseEvenement extends ViewEntreprise {
		
	}
	public static class ViewEntrepriseGroupe extends ViewEntreprise {
		
	}
	
	public static class ViewEntrepriseUtilisateur extends ViewEntreprise {
		
	}
	
	public static class ViewGroupe extends ViewCommon {
		
	}
	
	public static class ViewGestionEntreprise extends ViewCommon {
		
	}
	
	public static class ViewEvenementEntreprise extends  ViewGroupe {
		
	}
	
	public static class ViewEvenementGroupe  extends  ViewGroupe {
		
	}
	
	public static class ViewtUtilisateurGroupe extends  ViewGroupe {
		
	}
	
	public static class ViewEvenementStarch extends ViewCommon{
	}
	public static class ViewEvenementStarchDetail extends ViewEvenementStarch{
	}
	public static class ViewCommentaire extends ViewCommon{
	}
	public static class ViewCommentaireDetail extends ViewCommentaire{
	}
	
	public static class ViewFavoris extends ViewCommon {
	}
	

	public static class ViewUtilisateur extends ViewCommon {
	}
	
	public static class ViewParticipationUtilisateurEvenement extends ViewParticipation {
	}

	public static class ViewEvenement extends ViewCommon {
	}

	public static class ViewEvenementDetail extends ViewEvenement {
	}
	
	public static class ViewLieuxEvenement extends ViewCommon {
	}

	public static class ViewLieuxEvenementDetail extends ViewEvenement {
	}
	
	public static class ViewParticipation extends ViewCommon {
	}
}
