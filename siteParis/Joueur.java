package siteParis;


import java.util.LinkedList;
import java.util.List;


public class Joueur {

	/**
	 * @uml.property  name="nom"
	 */
	private String nom;

	/**
	 * Getter of the property <tt>nom</tt>
	 * @return  Returns the nom.
	 * @uml.property  name="nom"
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter of the property <tt>nom</tt>
	 * @param nom  The nom to set.
	 * @uml.property  name="nom"
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @uml.property  name="prenom"
	 */
	private String prenom;

	/**
	 * Getter of the property <tt>prenom</tt>
	 * @return  Returns the prenom.
	 * @uml.property  name="prenom"
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter of the property <tt>prenom</tt>
	 * @param prenom  The prenom to set.
	 * @uml.property  name="prenom"
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

		
			
				
				
				public Joueur(String nom, String prenom, int compte)	throws JoueurException {
				}

				
					
					
					public boolean equals(Joueur o){
					
										return false;	
									 }

						
						/**
						 */
						public long desinscrireJoueur(){
							return 0;
						}

							
							/**
							 */
							public LinkedList consulterCompetition(){
								return null;
							}

								
									
									
										
										
										public Pari miserVainqueur(int montant, java.lang.String type){
										
																				return null;
																			 }

								/**
								 * @uml.property  name="compte"
								 */
								private long compte;

								/**
								 * Getter of the property <tt>compte</tt>
								 * @return  Returns the compte.
								 * @uml.property  name="compte"
								 */
								public long getCompte() {
									return compte;
								}

								/**
								 * Setter of the property <tt>compte</tt>
								 * @param compte  The compte to set.
								 * @uml.property  name="compte"
								 */
								public void setCompte(long compte) {
									this.compte = compte;
								}

								/** 
								 * @uml.property name="paris"
								 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="joueurs:siteParis.Pari"
								 * @uml.association name="listeParis"
								 */
								private List paris = new java.util.ArrayList();

								/** 
								 * Getter of the property <tt>paris</tt>
								 * @return  Returns the paris.
								 * @uml.property  name="paris"
								 */
								public List getParis() {
									return paris;
								}

								/** 
								 * Setter of the property <tt>paris</tt>
								 * @param paris  The paris to set.
								 * @uml.property  name="paris"
								 */
								public void setParis(List paris) {
									this.paris = paris;
								}

									
									/**
									 */
									public Joueur(){
									}

							
							/**
							 */

							
							/**
							 */


}
