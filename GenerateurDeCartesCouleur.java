/**
 * Classe GenerateurDeCartesCouleur
 * @author Alex Marcotte
 * @since Mars 2015
 * @see GenerateurDeCartes
 */
class GenerateurDeCartesCouleur extends GenerateurDeCartes {

	public String nom = "Couleur";

	public GenerateurDeCartesCouleur(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode getNom retourne le nom du générateur
	 * @return string Le nom du générateur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne une référence de type Carte à une carte choisie aléatoirement parmi celles du thème.
	 * Par défaut, les cartes générées sont montrées au départ (pendant un délai initial)
	 * @return Carte
	 */
	public Carte genereUneCarte() {
		return new CarteCouleur(true);
	}

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * @return int
	 */
	public int nombreDeCartesDifferentes() {
		return 8;
	}

}