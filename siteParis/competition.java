package siteParis;

import java.util.LinkedList;

public class Competition {

    private String nom;
	private LinkedList<Competiteur> competiteurs;
	private LinkedList<Pari> paris;
	private DateFrancaise dateCloture;
    private Competiteur vainqueur;
    
    public Competition (String nom, DateFrancaise dateCloture, LinkedList<Competiteur> competiteurs) {

        this.nom = nom;
        this.competiteurs = competiteurs;
        this.dateCloture = dateCloture;
        this.paris = new LinkedList<Pari>();
        this.vainqueur = null;
    }

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
	 * Getter of the property <tt>dateCloture</tt>
	 * @return  Returns the dateCloture.
	 * @uml.property  name="dateCloture"
	 */
	public DateFrancaise getDateCloture() {
		return dateCloture;
	}

	/**
	 * Setter of the property <tt>dateCloture</tt>
	 * @param dateCloture  The dateCloture to set.
	 * @uml.property  name="dateCloture"
	 */
	public void setDateCloture(DateFrancaise dateCloture) {
		this.dateCloture = dateCloture;
	}

    /** 
     * Setter of the property <tt>competiteur</tt>
     * @param vainqueur  The winner to set.
     * @uml.property  name="winner"
     */
    public void setVainqueur (Competiteur vainqueur) {
        this.vainqueur = vainqueur;
    }

    /**
     * Getter of the property <tt>vainqueurs</tt>
     * @return  Returns the winners.
     * @uml.property  name="winner"
     */
    public Competiteur getVainqueur() {
        return vainqueur;
    }

    /**
     * Getter of the property <tt>competiteurs</tt>
     * @return  Returns the competiteurs.
     * @uml.property  name="competiteurs"
     */

    public LinkedList<Competiteur> getCompetiteurs() {
        return competiteurs;
    }

    /** 
     * Getter of the property <tt>competiteurs</tt>
     * @param competiteurs  The competiteurs to set.
     * @uml.property  name="competiteurs"
     */
    
    public void setCompetiteurs(LinkedList<Competiteur> competiteurs) {
        this.competiteurs = competiteurs;
    }

        /**
     * Getter of the property <tt>paris</tt>
     * @return  Returns the paris.
     * @uml.property  name="paris"
     */

    public LinkedList<Pari> getParis() {
        return paris;
    }

    /** 
     * Getter of the property <tt>paris</tt>
     * @param paris  The paris to set.
     * @uml.property  name="paris"
     */
    
    public void setParis(LinkedList<Pari> paris) {
        this.paris = paris;
    }

    /**
     * Adding a bet to a competition
     * @param pari The bet to add.
     */

    public void addPari(Pari pari) {
        this.paris.add(pari);
    }

    public Competition() {
        
    }

}
