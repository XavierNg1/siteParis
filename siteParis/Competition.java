package siteParis;

import java.util.Collection;
import java.sql.Date;


public class Competition {

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
	 * @uml.property  name="dateCloture"
	 */
	private Date dateCloture;

	/**
	 * Getter of the property <tt>dateCloture</tt>
	 * @return  Returns the dateCloture.
	 * @uml.property  name="dateCloture"
	 */
	public Date getDateCloture() {
		return dateCloture;
	}

	/**
	 * Setter of the property <tt>dateCloture</tt>
	 * @param dateCloture  The dateCloture to set.
	 * @uml.property  name="dateCloture"
	 */
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

		
		/**
		 */
		public Competition(boolean nom)	throws CompetitionExistanteException, CompetitionException {
		}

			
			/**
			 */
			public boolean equals(CompetitionException competition){
				return false;	
			}

			/**
			 * @uml.property  name="siteDeParisMetier"
			 * @uml.associationEnd  multiplicity="(1 1)" inverse="competition:siteParis.SiteDeParisMetier"
			 * @uml.association  name="listeCompetition"
			 */
			private SiteDeParisMetier siteDeParisMetier = new siteParis.SiteDeParisMetier();

			/**
			 * Getter of the property <tt>siteDeParisMetier</tt>
			 * @return  Returns the siteDeParisMetier.
			 * @uml.property  name="siteDeParisMetier"
			 */
			public SiteDeParisMetier getSiteDeParisMetier() {
				return siteDeParisMetier;
			}

			/**
			 * Setter of the property <tt>siteDeParisMetier</tt>
			 * @param siteDeParisMetier  The siteDeParisMetier to set.
			 * @uml.property  name="siteDeParisMetier"
			 */
			public void setSiteDeParisMetier(SiteDeParisMetier siteDeParisMetier) {
				this.siteDeParisMetier = siteDeParisMetier;
			}

			/** 
			 * @uml.property name="competiteur"
			 * @uml.associationEnd inverse="competition:siteParis.Competiteur"
			 * @uml.association name="vainqueur"
			 */
			private Competiteur competiteur;

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
			 * @uml.property  name="competiteurs"
			 * @uml.associationEnd  multiplicity="(0 -1)" inverse="competition:siteParis.Competiteur"
			 * @uml.association  name="listeCompetiteurs"
			 */
			private Collection competiteurs;

			/**
			 * Getter of the property <tt>competiteurs</tt>
			 * @return  Returns the competiteurs.
			 * @uml.property  name="competiteurs"
			 */
			public Collection getCompetiteurs() {
				return competiteurs;
			}

			/**
			 * Setter of the property <tt>competiteurs</tt>
			 * @param competiteurs  The competiteurs to set.
			 * @uml.property  name="competiteurs"
			 */
			public void setCompetiteurs(Collection competiteurs) {
				this.competiteurs = competiteurs;
			}

				
				/**
				 */
				public Competition(){
				}

}
