package siteParis;


import java.util.LinkedList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;


/**
 * 
 * @author Bernard Prou et Julien Mallet
 * <br><br>
 * La classe qui contient toutes les méthodes "Métier" de la gestion du site de paris. 
 * <br><br>
 * Dans toutes les méthodes :
 * <ul>
 * <li>un paramètre de type <code>String</code> est invalide si il n'est pas instancié.</li>
 *  <li>pour la validité d'un password de gestionnaire et d'un password de joueur :
 * <ul>
 * <li>       lettres et chiffres sont les seuls caractères autorisés </li>
 * <li>       il doit avoir une longueur d'au moins 8 caractères </li>
 * </ul></li>       
 * <li>pour la validité d'un pseudo de joueur  :
 * <ul>
 * <li>        lettres et chiffres sont les seuls caractères autorisés  </li>
 * <li>       il doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un prénom de joueur et d'un nom de joueur :
 *  <ul>
 *  <li>       lettres et tiret sont les seuls caractères autorisés  </li>
 *  <li>      il  doit avoir une longueur d'au moins 1 caractère </li>
 * </ul></li>
 * <li>pour la validité d'une compétition  :       
 *  <ul>
 *  <li>       lettres, chiffres, point, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      elle  doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un compétiteur  :       
 *  <ul>
 *  <li>       lettres, chiffres, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      il doit avoir une longueur d'au moins 4 caractères.</li>
 * </ul></li></ul>
 */

public class SiteDeParisMetier {



	/**
	 * constructeur de <code>SiteDeParisMetier</code>. 
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire.   
	 * 
	 * @throws MetierException  levée 
	 * si le <code>passwordGestionnaire</code>  est invalide 
	 */
    
	private String passwordGestionnaire;
	private LinkedList<Joueur> listeJoueurs;
	private LinkedList<Competition> listeCompetitions;
    
	public SiteDeParisMetier(String passwordGestionnaire) throws MetierException {

		if (passwordGestionnaire == null)
			throw new MetierException("Le mot de passe doit etre instancie !");
		/** Verifie si le pswd fait bien au moins 8 caracteres alphanumeriques */
		if (!passwordGestionnaire.matches("[0-9A-Za-z]{8,}")) throw new MetierException();
      this.passwordGestionnaire = passwordGestionnaire; 
      this.listeJoueurs = new LinkedList<Joueur>();
      this.listeCompetitions = new LinkedList<Competition>();      
  }





	// Les méthodes du gestionnaire (avec mot de passe gestionnaire)



	/**
	 * inscrire un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée  
	 * si le <code>passwordGestionnaire</code> proposé est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurExistantException   levée si un joueur existe avec les mêmes noms et prénoms ou le même pseudo.
	 * @throws JoueurException levée si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le mot de passe (déterminé par le site) du nouveau joueur inscrit.
	 */


	public String inscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurExistantException, JoueurException {
		
		/** On teste si les arguments en parametres ne sont pas null */
		if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie");
		if (nom == null) throw new JoueurException("Le nom doit etre instancie !");
		if (prenom == null) throw new JoueurException("Le prenom doit etre instancie !");
		if (passwordGestionnaire == null) throw new MetierException("Veuillez entrer le mot de passe du gestionnaire");

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);
		
		/** On teste si les pseudo, nom et prenom ont le bon format. */
		if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		if (!nom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!prenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");

		/** On teste si le joueur existe deja. */
		if (listeJoueurs.size()!=0) {
			for(Joueur joueur : listeJoueurs) {
				if(joueur.getPseudo().equals(pseudo)) throw new JoueurExistantException("Ce pseudo existe deja");
         }
			}
      if (listeJoueurs.size()!=0) {
			for(Joueur joueur : listeJoueurs) {
				if((joueur.getNom().equals(nom)) && (joueur.getPrenom().equals(prenom))) throw new JoueurExistantException("Le nom et le prenom exist deja");
			}
		}
		/** On inscrit le joueur si tous les tests ont ete passe. */

		/** Generation du mot de passe */
		int length=8;
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"+pseudo; // Tu supprimes les lettres dont tu ne veux pas
		String password = "";
		for(int x=0;x<length;x++) {
			int y = (int)Math.floor(Math.random() * (62+ pseudo.length())); // Si tu supprimes des lettres tu diminues ce nb
			password += chars.charAt(y);
		}

		Joueur joueur = new Joueur(nom, prenom, pseudo, 0, password);

		/** On ajoute le joueur a la lsite des joueurs du site */
		listeJoueurs.add(joueur);
		return password;
	}

	/**
	 * supprimer un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec le même <code>nom</code>, <code>prenom</code>  et <code>pseudo</code>.
	 * @throws JoueurException levée 
	 * si le joueur a des paris en cours,
	 * si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le nombre de jetons à rembourser  au joueur qui vient d'être désinscrit.
	 * 
	 */
	public long desinscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurInexistantException, JoueurException {

		/** On teste si les arguments en parametres ne sont pas null. */
		if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie");
		if (nom == null) throw new JoueurException("Le nom doit etre instancie !");
		if (prenom == null) throw new JoueurException("Le prenom doit etre instancie !");
		if (passwordGestionnaire == null) throw new MetierException("Veuillez entrer le mot de passe du gestionnaire");

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);

		/** On teste si les pseudo, nom et prenom ont le bon format. */
		if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		if (!nom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!prenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");

		/** On teste si le joueur existe bien dans la liste des joueurs. */
		int testSupp = 0;
		if (listeJoueurs.size() != 0) {
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getNom().equals(nom) && joueur.getPrenom().equals(prenom) && joueur.getPseudo().equals(pseudo)) {
					/** Si le joueur a des paris en cours on ne le supprime pas. */
					if (joueur.getListeParis().size() != 0) throw new JoueurException("Le joueur a supprime a des paris en cours."); 
   				else {
   					testSupp = 1;
   					listeJoueurs.remove(joueur);
   					return 0;
   				}
				} 
			}
		}
    if (testSupp == 0) throw new JoueurInexistantException("Le joueur a supprimer n'existe pas !");
    return 0;
	}



	/**
	 * ajouter une compétition.  
	 * 
	 * @param competition le nom de la compétition
	 * @param dateCloture   la date à partir de laquelle il ne sera plus possible de miser  
	 * @param competiteurs   les noms des différents compétiteurs de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException levée si le tableau des
	 * compétiteurs n'est pas instancié, si le
	 * <code>passwordGestionnaire</code> est invalide, si le
	 * <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionExistanteException levée si une compétition existe avec le même nom. 
	 * @throws CompetitionException levée si le nom de la
	 * compétition ou des compétiteurs sont invalides, si il y a
	 * moins de 2 compétiteurs, si un des competiteurs n'est pas instancié,
	 * si deux compétiteurs ont le même nom, si la date de clôture 
	 * n'est pas instanciée ou est dépassée.
	 */
	public void ajouterCompetition(String competition, DateFrancaise dateCloture, String [] competiteurs, String passwordGestionnaire) throws MetierException, CompetitionExistanteException, CompetitionException  {

		/** On teste si les arguments en parametres ne sont pas null. */
		if (competition == null) throw new CompetitionException ("Le nom de la competition doit etre instancie");
		if (dateCloture == null) throw new CompetitionException("La date de cloture doit etre instancie !");
		if (competiteurs == null) throw new MetierException("Les competiteurs doivent etre instancie !");
		if (passwordGestionnaire == null) throw new MetierException("Veuillez entrer le mot de passe du gestionnaire");

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);
		
		/** On teste si la date de cloture n'est pas deja depassee. */
		if (dateCloture.estDansLePasse()) throw new CompetitionException("La date de cloture est deja passe !");
      
      /** On teste si les noms des competiteurs sont valides. */
      for (String comp : competiteurs) {
			if (comp == null) throw new CompetitionException("Un nom de competiteur doit etre instancie !");
      }
      
		/** On teste si le nom de la competition et le nom des competiteurs sont valides. */
		if (!competition.matches("[0-9A-Za-z]{4,}")) throw new CompetitionException("Un nom de competition doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		for (String comp : competiteurs) {
			if (!comp.matches("[0-9A-Za-z]{4,}")) throw new CompetitionException("Un nom de competiteur doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		}
      
      /** Si le nombre des competiteurs est de 1, on signale une exception.*/
      if (competiteurs.length < 2) throw new CompetitionException("Il n'y a pas assez de competiteurs.");
      
      /** On teste si deux competiteurs n'ont pas le meme nom dans la liste. */
      Map<String, Integer> hm = new HashMap<String, Integer>(); 
		for (String i : competiteurs) { 
	            Integer j = hm.get(i); 
	            hm.put(i, (j == null) ? 1 : j + 1); 
	    } 
	  
	        // displaying the occurrence of elements in the arraylist https://www.geeksforgeeks.org/count-occurrences-elements-list-java/
	    for (Map.Entry<String, Integer> val : hm.entrySet()) { 
	        	if(val.getValue()==2)throw new CompetitionException();
	    }
		/** On recherche si la competition n'existe pas deja.
		 * Si oui, on signale une exception.
		 * Si non, on peut ajouter la competition.
		 */
		int testAjout = 0;
		if (listeCompetitions.size() != 0) {
			for (Competition comp : listeCompetitions) {
				if (comp.getNom().equals(competition)) {
          testAjout = 1;
					throw new CompetitionExistanteException("La competition existe deja !");
				}
			}
		}
		if (testAjout == 0) {
         LinkedList<Competiteur> competiteurslst = new LinkedList<Competiteur>();
         for (String comp : competiteurs) {
            competiteurslst.add(new Competiteur(comp));
         }
			Competition a = new Competition(competition,dateCloture,competiteurslst);
			listeCompetitions.add(a);
		};

	}


	/**
	 * solder une compétition vainqueur (compétition avec vainqueur).  
	 * 
	 * Chaque joueur ayant misé sur cette compétition
	 * en choisissant ce compétiteur est crédité d'un nombre de
	 * jetons égal à :
	 * 
	 * (le montant de sa mise * la somme des
	 * jetons misés pour cette compétition) / la somme des jetons
	 * misés sur ce compétiteur.
	 *
	 * Si aucun joueur n'a trouvé le
	 * bon compétiteur, des jetons sont crédités aux joueurs ayant
	 * misé sur cette compétition (conformément au montant de
	 * leurs mises). La compétition est "supprimée" si il ne reste
	 * plus de mises suite à ce solde.
	 * 
	 * @param competition   le nom de la compétition  
	 * @param vainqueur   le nom du vainqueur de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom.
	 * @throws CompetitionException levée 
	 * si le nom de la compétition ou du vainqueur est invalide, 
	 * si il n'existe pas de compétiteur du nom du vainqueur dans la compétition,
	 * si la date de clôture de la compétition est dans le futur.
	 * 
	 */	
	public void solderVainqueur(String competition, String vainqueur, String passwordGestionnaire) throws MetierException,  CompetitionInexistanteException, CompetitionException  {

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);

		/** On teste si les mot de passe, vainqueur et la competition ont le bon format. */
		if (!passwordGestionnaire.matches("[0-9A-Za-z]{8,}")) throw new MetierException("Le mot de passe doit contenir au moins 8 caracteres et ils doivent etre alphanumeriques");
		if (!vainqueur.matches("[0-9A-Za-z]{1,}")) throw new CompetitionException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!competition.matches("[0-9A-Za-z]{1,}")) throw new CompetitionException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");

		/** On recherche la competition. */
		int index = 0;
		Competition compSolde = new Competition();
		if (listeCompetitions.size() > 0) {
			int testComp = 0;
			for (int i = 0; i < listeCompetitions.size(); i++) {
				if (listeCompetitions.get(i).getNom().equals(competition)){
					/** On verifie la date de cloture. */
					if (!listeCompetitions.get(i).getDateCloture().estDansLePasse()) throw new CompetitionException("La date de cloture n'est pas encore arrive !");
					/** On recherche le competiteur. */
					testComp = 1;
					if (listeCompetitions.get(i).getCompetiteurs().size() > 0) {
						int testCompet = 0;
						for (Competiteur compet : listeCompetitions.get(i).getCompetiteurs()) {
							if (compet.getNom().equals(vainqueur)) {
								index = i;

								/** On cree la cagnotte de la competition. */
								long cagnotte = 0;
                        long cagnotteVainq = 0;
								for (Pari pariComp : listeCompetitions.get(i).getParis()) {
									cagnotte += pariComp.getMontant();
                  if (pariComp.getVainqueurEspere().equals(vainqueur)) cagnotteVainq += pariComp.getMontant();
								}
                        
								testCompet = 1;
								/** On recherche les joueurs ayant parie sur cette competition et sur le vainqueur. */
								int testGagnant = 0;
								if (listeJoueurs.size() > 0) {
										for (Joueur joueur : listeJoueurs) {
											/** On parcourt leur pari. */
											if (joueur.getListeParis().size() > 0) {
												for (Pari pari : joueur.getListeParis()) {
													if (pari.getCompetition().getNom().equals(competition)) {
														if (pari.getVainqueurEspere().equals(vainqueur)) {
															testGagnant = 1;
															long sommeGagnee = ( pari.getMontant() * cagnotte ) / cagnotteVainq;
															//cagnotte -= sommeGagnee;
															System.out.println(cagnotte);
															joueur.setCompte(joueur.getCompte() + sommeGagnee);
														}
													}
												}
											}
										} 
									/** Dans le cas ou personne n'a parie sur le vainqueur */
									if (testGagnant == 0) {
										if (listeJoueurs.size() > 0) {
												for (Joueur joueur : listeJoueurs) {
													/** On parcourt leur pari. */
													if (joueur.getListeParis().size() > 0) {
														for (Pari pari : joueur.getListeParis()) {
															if (pari.getCompetition().getNom().equals(competition)) {
																	//cagnotte -= pari.getMontant();
																	joueur.setCompte(joueur.getCompte() + pari.getMontant());
																}
															}
														}
													}
											} 
									}
								}
							}
						} if (testCompet == 0) throw new CompetitionException("Le nom du vainqueur n'existe pas dans la competition demande !");
					}
				}
			} if (testComp == 0) throw new CompetitionInexistanteException("La competition a solder n'existe pas !");
			else this.listeCompetitions.remove(listeCompetitions.get(index));
		}
	}



	/**
	 * créditer le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons   la somme en jetons à créditer  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 */
	public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {

		/** On teste si les arguments en parametres ne sont pas null. */
		if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie");
		if (nom == null) throw new JoueurException("Le nom doit etre instancie !");
		if (prenom == null) throw new JoueurException("Le prenom doit etre instancie !");
		if (passwordGestionnaire == null) throw new MetierException("Veuillez entrer le mot de passe du gestionnaire.");

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);

		/** On teste si la somme a rentrer n'est pas negative */
		if (sommeEnJetons < 0) throw new MetierException("Une somme a crediter doit etre superieure a 0 !");


		/** On teste si les pseudo, nom et prenom ont le bon format. */
		if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		if (!nom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!prenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");

		/** On recherche le joueur a crediter et on le credite. S'il n'existe pas on lance une exception.*/
		int testCred = 0;
		if (listeJoueurs.size() != 0) {
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getNom().equals(nom) && joueur.getPrenom().equals(prenom) && joueur.getPseudo().equals(pseudo)) {
					joueur.setCompte(joueur.getCompte() + sommeEnJetons);
					testCred = 1; 
				} 
			}
		}
    if (testCred == 0) throw new JoueurInexistantException("Le joueur a crediter n'existe pas !");

	}


	/**
	 * débiter le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons   la somme en jetons à débiter  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides 
	 * si le compte en jetons du joueur est insuffisant (il deviendrait négatif).
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 * 
	 */

	public void debiterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws  MetierException, JoueurInexistantException, JoueurException {
		/** On teste si les arguments en parametres ne sont pas null. */
		if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie");
		if (nom == null) throw new JoueurException("Le nom doit etre instancie !");
		if (prenom == null) throw new JoueurException("Le prenom doit etre instancie !");
		if (passwordGestionnaire == null) throw new MetierException("Veuillez entrer le mot de passe du gestionnaire.");

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);

		/** On teste si la somme a rentrer n'est pas negative */
		if (sommeEnJetons < 0) throw new MetierException("Une somme a crediter doit etre superieure a 0 !");


		/** On teste si les pseudo, nom et prenom ont le bon format. */
		if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		if (!nom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le nom doit contenir au moins 1 caractere et doit etre alphanumeriques");
		if (!prenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException("Le prenom doit contenir au moins 1 caractere et doit etre alphanumeriques");

		/** On recherche le joueur a dediter et on le credite. S'il n'existe pas on lance une exception.*/
		int testCred = 0;
		if (listeJoueurs.size() != 0) {
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getNom().equals(nom) && joueur.getPrenom().equals(prenom) && joueur.getPseudo().equals(pseudo)) {
					if (sommeEnJetons > joueur.getCompte()) throw new JoueurException("Le joueur n'a pas assez de jetons sur son compte !");
					else joueur.setCompte(joueur.getCompte() - sommeEnJetons);
					testCred = 1; 
				} 
			}
		}
		if (testCred == 0) throw new JoueurInexistantException("Le joueur a dediter n'existe pas !");
	}



	/** 
	 * consulter les  joueurs.
	 * 
	 * @param passwordGestionnaire  le password du gestionnaire du site de paris 

	 * @throws MetierException   levée  
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * 
	 * @return une liste de liste dont les éléments (de type <code>String</code>) représentent un joueur avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom du joueur  </li>
	 *  <li>       le prénom du joueur </li>
	 *  <li>       le pseudo du joueur  </li>
	 *  <li>       son compte en jetons restant disponibles </li>
	 *  <li>       le total de jetons engagés dans ses mises en cours. </li>
	 *  </ul>
	 */
	public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {

		/** On teste si c'est bien le mot de passe du gestionnaire.  */
		this.validitePasswordGestionnaire(passwordGestionnaire);
		
		/** On cree la liste. */
		LinkedList< LinkedList<String>> consult = new LinkedList< LinkedList<String>>();
		for (Joueur joueur : listeJoueurs) {
			LinkedList<String> description = new LinkedList<String>();
			description.add(joueur.getNom());
			description.add(joueur.getPrenom());
			description.add(joueur.getPseudo());
			description.add(String.valueOf(joueur.getCompte()));
      int somme = 0;
			for (Pari pari : joueur.getListeParis()) {
				somme += pari.getMontant();
			}
			description.add(String.valueOf(somme));
		   consult.add(description);
		}
		return consult;
	}








	// Les méthodes avec mot de passe utilisateur



	/**
	 * miserVainqueur  (parier sur une compétition, en désignant un vainqueur).
	 * Le compte du joueur est débité du nombre de jetons misés.
	 * 
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordJoueur  le password du joueur  
	 * @param miseEnJetons   la somme en jetons à miser  
	 * @param competition   le nom de la compétition  relative au pari effectué
	 * @param vainqueurEnvisage   le nom du compétiteur  sur lequel le joueur mise comme étant le  vainqueur de la compétition  
	 * 
	 * @throws MetierException levée si la somme en jetons est négative.
	 * @throws JoueurInexistantException levée si il n'y a pas de
	 * joueur avec les mêmes pseudos et password.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * @throws CompetitionException levée 
	 * si <code>competition</code> ou <code>vainqueurEnvisage</code> sont invalides,
	 * si il n'existe pas un compétiteur de  nom <code>vainqueurEnvisage</code> dans la compétition,
	 * si la compétition n'est plus ouverte (la date de clôture est dans le passé).
	 * @throws JoueurException   levée 
	 * si <code>pseudo</code> ou <code>password</code> sont invalides, 
	 * si le <code>compteEnJetons</code> du joueur est insuffisant (il deviendrait négatif).
	 */
    public void miserVainqueur(String pseudo, String passwordJoueur, long miseEnJetons, String competition, String vainqueurEnvisage) throws MetierException, JoueurInexistantException, CompetitionInexistanteException, CompetitionException, JoueurException  {

			/** On teste si la mise est positive. */
			if (miseEnJetons < 0) throw new MetierException("La mise doit etre positive !");

			/** On teste si les valeurs des parametres a rentrer ne sont pas null. */
			if (pseudo == null) throw new JoueurException ("Le pseudo doit etre instancie !");
			if (passwordJoueur == null) throw new JoueurException ("Le mot de passe doit etre instancie !");
			if (competition == null) throw new CompetitionException ("Le nom de competition doit etre instancie !");
			if (vainqueurEnvisage == null) throw new CompetitionException ("Le nom de competiteur doit etre instancie !");

			/** On teste si les pseudo, le mot de passe, le nom de la competition et le nom du competiteur ont le bon format. */
			if (!pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException("Un pseudo doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
			if (!passwordJoueur.matches("[0-9A-Za-z]{8,}")) throw new JoueurException("Le mot de passe doit contenir au moins 8 caractere et doit etre alphanumeriques");
			if (!vainqueurEnvisage.matches("[0-9A-Za-z]{4,}")) throw new CompetitionException("Le nom du competiteur doit contenir au moins 8 caractere et doit etre alphanumeriques");
			if (!competition.matches("[0-9A-Za-z]{4,}")) throw new CompetitionException("Le nom d'une competition doit contenir au moins 8 caractere et doit etre alphanumeriques");

			/** On cherche le joueur et la competition concerne */
			Joueur parieur = new Joueur();
			Competition competitionPari = new Competition();
			Competiteur competiteurPari = new Competiteur();
			Pari pariVainq = new Pari();

			/** -- Recherche de la competition -- */
			int testComp = 0;
			if (listeCompetitions.size() > 0) {
				for (Competition comp : listeCompetitions) {
					if (comp.getNom().equals(competition)) {
						/** On teste si la date de cloture est passe. */
						if (comp.getDateCloture().estDansLePasse()) throw new CompetitionException("La date de cloture est passe.");

						/** On cherche le nom du competiteur */
						int testCompet = 0;
						if (comp.getCompetiteurs().size() > 0) {
							for (Competiteur compet : comp.getCompetiteurs()) {
								if (compet.getNom().equals(vainqueurEnvisage)) {
									testComp = 1;
									testCompet = 1;
									competitionPari = comp;
									competiteurPari = compet;
								}
							}
						} if (testCompet == 0) throw new CompetitionException("Le competiteur a parie ne participe pas a la competition !");
					}
				} 
			} if (testComp == 0) throw new CompetitionInexistanteException("La competition a parier n'existe pas !");

			/** -- Recherche du joueur -- */
			int testJoueur = 0;
			if (listeJoueurs.size() > 0) {
				for (Joueur joueur : listeJoueurs) {
					if (joueur.getPseudo().equals(pseudo)) {

						/** On verifie si le password concorde. */
						if (joueur.getPasswordJoueur().equals(passwordJoueur)) {
							
							/** On verifie si le joueur a assez d'argent sur son compte. */
							if (joueur.getCompte() > miseEnJetons) {
								testJoueur = 1;
								this.debiterJoueur(joueur.getNom(), joueur.getPrenom(), joueur.getPseudo(), miseEnJetons, passwordGestionnaire);
								parieur = joueur;
								pariVainq.setParieur(parieur);
								pariVainq.setVainqueurEspere(competiteurPari);
								pariVainq.setCompetition(competitionPari);
								pariVainq.setMontant(miseEnJetons);
								joueur.addPari(pariVainq);
								competitionPari.addPari(pariVainq);
							} else throw new JoueurException("Le joueur n'a pas assez de jetons sur son compte !");
						} else throw new JoueurException("Le mot de passe ne correspond pas !");
					}
				}
			} if (testJoueur == 0) throw new JoueurInexistantException("Le joueur a recherche n'existe pas !"); 
	}


    

	// Les méthodes sans mot de passe


	/**
	 * connaître les compétitions en cours.
	 * 
	 * @return une liste de liste dont les éléments (de type <code>String</code>) représentent une compétition avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom de la compétition,  </li>
	 *  <li>       la date de clôture de la compétition. </li>
	 *  </ul>
	 */
	public LinkedList <LinkedList <String>> consulterCompetitions(){


		/** On cree la liste. */
		LinkedList< LinkedList<String>> consult = new LinkedList< LinkedList<String>>();
		for (Competition comp : listeCompetitions) {
			LinkedList<String> description = new LinkedList<String>();
			description.add(comp.getNom());
			description.add(comp.getDateCloture().toString());
			consult.add(description);
      }
		return consult;
	} 

	/**
	 * connaître  la liste des noms des compétiteurs d'une compétition.  
	 * 
	 * @param competition   le nom de la compétition  
	 * 
	 * @throws CompetitionException   levée  
	 * si le nom de la compétition est invalide.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * 
	 * @return la liste des compétiteurs de la  compétition.
	 */
	public LinkedList <String> consulterCompetiteurs(String competition) throws CompetitionException, CompetitionInexistanteException{

		/** On teste si le nom de la competition n'est pas null. */
		if (competition == null) throw new CompetitionException ("Le nom de la competition doit etre instancie");
		
		/** On teste la taille du nom de la competition. */
		if (!competition.matches("[0-9A-Za-z]{4,}")) throw new CompetitionException("Une competition doit contenir au moins 4 caracteres et ils doivent etre alphanumeriques");
		/** On teste si la competition existe */
    LinkedList<String> competiteurs = new LinkedList<String>();
		int testExist = 0;
		if (listeCompetitions.size() != 0) {
			for (Competition comp : listeCompetitions) {
				if (comp.getNom().equals(competition)) {
							testExist = 1;
							for (Competiteur compett : comp.getCompetiteurs()){
							  competiteurs.add(compett.getNom());
							}
						}
				} 
			}
		if (testExist == 0) throw new CompetitionInexistanteException("La competition n'existe pas !");
    return competiteurs;
	}

	/**
	 * vérifier la validité du password du gestionnaire.
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire à vérifier
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code> est invalide.  
	 */
	protected void validitePasswordGestionnaire(String passwordGestionnaire) throws MetierException {
	  if (passwordGestionnaire == null) throw new MetierException();
		if (!passwordGestionnaire.matches("[0-9A-Za-z]{8,}")) throw new MetierException();
    if (passwordGestionnaire.length()!=0) {
			if (!(this.passwordGestionnaire.equals(passwordGestionnaire))) throw new MetierException("Erreur Mot de passe Admin");
      };
	}


	/**
	 * @uml.property  name="passwordGestionnaire"
	 */

	/**
	 * Getter of the property <tt>passwordGestionnaire</tt>
	 * @return  Returns the passwordGestionnaire.
	 * @uml.property  name="passwordGestionnaire"
	 */
	public String getPasswordGestionnaire() {
		return passwordGestionnaire;
	}





	/**
	 * Setter of the property <tt>passwordGestionnaire</tt>
	 * @param passwordGestionnaire  The passwordGestionnaire to set.
	 * @uml.property  name="passwordGestionnaire"
	 */
	public void setPasswordGestionnaire(String passwordGestionnaire) {
		this.passwordGestionnaire = passwordGestionnaire;
	}

	/**
	 * @uml.property  name="competition"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="siteDeParisMetier:siteParis.Competition"
	 * @uml.association  name="listeCompetition"
	 */
	private Collection competition;






		
		/**
		 */
		public SiteDeParisMetier(){
		}



}


