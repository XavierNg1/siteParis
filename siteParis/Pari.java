package siteParis;

import java.util.Collection;


public class Pari {

	/**
	 * @uml.property  name="type"
	 */
	private String type;

	/**
	 * Getter of the property <tt>type</tt>
	 * @return  Returns the type.
	 * @uml.property  name="type"
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter of the property <tt>type</tt>
	 * @param type  The type to set.
	 * @uml.property  name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/** 
	 * @uml.property name="montant"
	 */
	private int montant;

	/** 
	 * Getter of the property <tt>montant</tt>
	 * @return  Returns the montant.
	 * @uml.property  name="montant"
	 */
	public int getMontant() {
		return montant;
	}

	/**
		 */
		public Pari(String type, int montant){
		}

		/** 
		 * Setter of the property <tt>montant</tt>
		 * @param montant  The montant to set.
		 * @uml.property  name="montant"
		 */
		public void setMontant(int montant) {
			this.montant = montant;
		}

			
			/**
			 */
			public boolean equals(Pari pari){
				return false;	
			}

			/** 
			 * @uml.property name="joueurs"
			 * @uml.associationEnd multiplicity="(0 -1)" inverse="paris:siteParis.Joueur"
			 * @uml.association name="listeParis"
			 */
			private Collection joueurs = new java.util.ArrayList();

			/** 
			 * Getter of the property <tt>joueurs</tt>
			 * @return  Returns the joueurs.
			 * @uml.property  name="joueurs"
			 */
			public Collection getJoueurs() {
				return joueurs;
			}

			/** 
			 * Setter of the property <tt>joueurs</tt>
			 * @param joueurs  The joueurs to set.
			 * @uml.property  name="joueurs"
			 */
			public void setJoueurs(Collection joueurs) {
				this.joueurs = joueurs;
			}

			/**
			 * @uml.property  name="competiteur"
			 * @uml.associationEnd  multiplicity="(1 1)" inverse="pari:siteParis.Competiteur"
			 * @uml.association  name="vainqueurEspere"
			 */
			private Competiteur competiteur = new siteParis.Competiteur();

			/**
			 * Getter of the property <tt>competiteur</tt>
			 * @return  Returns the competiteur.
			 * @uml.property  name="competiteur"
			 */
			public Competiteur getCompetiteur() {
				return competiteur;
			}

			/**
			 * Setter of the property <tt>competiteur</tt>
			 * @param competiteur  The competiteur to set.
			 * @uml.property  name="competiteur"
			 */
			public void setCompetiteur(Competiteur competiteur) {
				this.competiteur = competiteur;
			}

			/**
			 * @uml.property  name="competition"
			 * @uml.associationEnd  inverse="pari:siteParis.Competition"
			 */
			private Competition competition;

			/**
			 * Getter of the property <tt>competition</tt>
			 * @return  Returns the competition.
			 * @uml.property  name="competition"
			 */
			public Competition getCompetition() {
				return competition;
			}

			/**
			 * Setter of the property <tt>competition</tt>
			 * @param competition  The competition to set.
			 * @uml.property  name="competition"
			 */
			public void setCompetition(Competition competition) {
				this.competition = competition;
			}

}
