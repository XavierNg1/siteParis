package siteParis;


import java.util.LinkedList;
import java.util.List;


public class Joueur {

	/**
	 * @uml.property  name="nom"
	 */
	private String nom;
	private String prenom;
	private String pseudo;
	private String passwordJoueur;
	private long compte;
	private LinkedList<Pari> listeParis;

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

	/**
	 * Getter of the property <tt>pseudo</tt>
	 * @return  Returns the pseudo.
	 * @uml.property  name="pseudo"
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter of the property <tt>pseudo</tt>
	 * @param prenom  The pseudo to set.
	 * @uml.property  name="pseudo"
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter of the property <tt>passwordJoueur</tt>
	 * @return  Returns the passwordJoueur.
	 * @uml.property  name="passwordJoueur"
	 */
	public String getPasswordJoueur() {
		return passwordJoueur;
	}

	/**
	 * Setter of the property <tt>passwordJoueur</tt>
	 * @param prenom  The passwordJoueur to set.
	 * @uml.property  name="passwordJoueur"
	 */
	public void setPasswordJoueur(String passwordJoueur) {
		this.passwordJoueur = passwordJoueur;
	}

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
	 * Getter of the property <tt>paris</tt>
	 * @return  Returns the paris.
	 * @uml.property  name="paris"
	 */
	public LinkedList<Pari> getListeParis() {
		return listeParis;
	}

	/** 
	 * Setter of the property <tt>paris</tt>
	 * @param paris  The paris to set.
	 * @uml.property  name="paris"
	 */
	public void setParis(LinkedList<Pari> paris) {
		this.listeParis = paris;
	}


	public Joueur(String nom, String prenom, String pseudo,  long compte, String passwordJoueur)	throws JoueurException {
		
		/** On teste si les arguments en parametres ne sont pas null */
		if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie");
		if (nom == null) throw new JoueurException("Le nom doit etre instancie !");
		if (prenom == null) throw new JoueurException("Le prenom doit etre instancie !");

		/** On teste si les pseudo, nom et prenom ont le bon format */
		if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		if (!nom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!prenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		
		/** Construction */
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.compte = compte;
		this.passwordJoueur = passwordJoueur;
        this.listeParis = new LinkedList<Pari>();

	}

				
					
					
	public boolean equals(Joueur o){

	return false;	
	}

	public void addPari(Pari pari) {
		this.listeParis.add(pari);
	}

	public Joueur(){
	}

}
