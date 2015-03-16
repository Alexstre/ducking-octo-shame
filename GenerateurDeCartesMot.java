import java.util.Random;

/**
 * Classe GenerateurDeCartesMot
 * @author Alex Marcotte
 * @since Mars 2015
 * @see GenerateurDeCartes
 */
class GenerateurDeCartesMot extends GenerateurDeCartes {

	protected String nom = "Mot";

	protected String[] mots;

	public GenerateurDeCartesMot(String nom, String[] mots) {
		this.nom = nom;
		this.mots = mots;
	}

	/**
	 * Méthode getNom retourne le nom du générateur
	 * @return string Le nom du générateur
	 */
	public String getNom() {
		return this.nom;
	}

	public String[] getMots() {
		return this.mots;
	}

	/**
	 * Retourne une référence de type Carte à une carte choisie aléatoirement parmi celles du thème.
	 * @return Carte
	 */
	public Carte genereUneCarte() {
		int index = new Random().nextInt(this.mots.length);
		return new CarteMot(true, this.mots[index]);
	}

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * @return int
	 */
	public int nombreDeCartesDifferentes() {
		return mots.length;
	}

}