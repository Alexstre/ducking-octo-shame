/**
 * Classe GenerateurDeCartesMultiples
 * @author Alex Marcotte
 * @since Mars 2015
 * @see GenerateurDeCartes
 */
class GenerateurDeCartesMultiple extends GenerateurDeCartes {

	protected String nom = "Multiple";
	protected GenerateurDeCartes[] generateurs;

	public GenerateurDeCartesMultiple(String nom, GenerateurDeCartes[] generateurs) {
		this.nom = nom;
		this.generateurs = generateurs;
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
		return 5;
	}

}