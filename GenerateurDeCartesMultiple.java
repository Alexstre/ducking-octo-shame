import java.util.Random;

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
		// On choisit d'abord un générateur au hasard puis on l'utilise pour générer une carte
		int index = new Random().nextInt(this.generateurs.length);
		return this.generateurs[index].genereUneCarte();
	}

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * Pour le générateur multiple, on regarde le nombre de cartes disponible pour chacun des
	 * générateur individuellement puis on somme le tout.
	 * @return int
	 */
	public int nombreDeCartesDifferentes() {
		int nb_de_cartes = 0;
		for (GenerateurDeCartes generateur: generateurs) {
			nb_de_cartes += generateur.nombreDeCartesDifferentes();
		}
		return nb_de_cartes;
	}

}