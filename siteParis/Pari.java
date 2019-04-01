package siteParis;

import java.util.Collection;


public class Pari {

	/**
	 * @uml.property  name="type"
	 */
	private long montant;
	private Joueur parieur;
	private Competiteur vainqueurEspere;
	private Competition competition;

	/** 
	 * Getter of the property <tt>montant</tt>
	 * @return  Returns the montant.
	 * @uml.property  name="montant"
	 */
	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

	public Joueur getParieur() {
		return parieur;
	}

	public void setParieur(Joueur parieur) {
		this.parieur = parieur;
	}

	public Competiteur getVainqueurEspere() {
		return vainqueurEspere;
	}

	public void setVainqueurEspere(Competiteur vainqueur) {
		this.vainqueurEspere = vainqueur;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * Constructeur de la classe
	 */
	public Pari(Joueur parieur, int montant, Competiteur vainqueurEspere, Competition competition) {
		this.parieur = parieur;
		this.montant = montant;
		this.vainqueurEspere = vainqueurEspere;
		this.competition = competition;
	}

	/**
	 * Methode equals de la classe Pari
	 * @return Retourne un boolean pour nous dire si deux paris sont egaux
	 */
	public boolean equals(Pari pari){
		if (this.parieur == pari.getParieur()) {
			if (this.montant == pari.getMontant()) {
				if (this.competition == pari.getCompetition()) {
					if (this.vainqueurEspere == pari.getVainqueurEspere())
						return true;
					return false;
				}
				return false;
			}
			return false;
		}
		return false;	
	}

	public Pari() {

	}
}
