abstract class GenerateurDeCartes {

	protected String nom;

	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne une référence de type Carte à une carte choisie aléatoirement parmi celles du thème.
	 * @return Carte
	 */
	abstract Carte genereUneCarte();

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * @param int
	 */
	abstract int nombreDeCartesDifferentes();

	/**
	 * Génére un tableau de n cartes selon le thème, si possible toutes différentes, en faisant des
	 * appels répétés à genereUneCarte.
	 * @param int n Nombre de cartes
	 * @return Carte[]
	 */
	public Carte[] genereCartes(int n) {
		return new Carte[5];
	}

	/**
	 * Génére 2n cartes par paires identiques, selon le thème, et les mélangera (cette méthode
	 * devrait faire appel à genereCartes , et aux méthodes duplique et Carte.melangeCartes)
	 * @param int n Nombre de paires
	 * @return Carte[]
	 */
	public Carte[] generePairesDeCartesMelangees(int n) {
		return new Carte[5];
	}

}