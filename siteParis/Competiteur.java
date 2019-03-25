package siteParis;

import java.util.Collection;


public class Competiteur {

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
		 */
		public Competiteur(String nom){
		}

			
			/**
			 */
			public boolean equals(Competiteur competiteur){
				return false;	
			}


			/** 
			 * @uml.property name="competition"
			 * @uml.associationEnd multiplicity="(1 1)" inverse="competiteur:siteParis.Competition"
			 * @uml.association name="vainqueur"
			 */
			private Competition competition1 = new siteParis.Competition();

			/**
			 * Getter of the property <tt>competition</tt>
			 * @return  Returns the competition1.
			 * @uml.property  name="competition"
			 */
			public Competition getCompetition() {
				return competition1;
			}

			/**
			 * Setter of the property <tt>competition</tt>
			 * @param competition  The competition1 to set.
			 * @uml.property  name="competition"
			 */
			public void setCompetition(Competition competition) {
				competition1 = competition;
			}

				
				/**
				 */
				public Competiteur(){
				}

}
