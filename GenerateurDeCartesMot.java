import java.util.Random;

class GenerateurDeCartesMot extends GenerateurDeCartes {

	protected String nom = "Mot";

	protected String[] mots;

	public GenerateurDeCartesMot(String nom, String[] mots) {
		this.nom = nom;
		this.mots = mots;
	}

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
	 * @param int
	 */
	public int nombreDeCartesDifferentes() {
		return 5;
	}

}