abstract class GenerateurDeCartes {

	protected String nom;

	abstract String getNom();

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
		Carte[] cartes = new Carte[n];
		for (int i = 0; i < n; i++) {
			cartes[i] = genereUneCarte(); 
		}
		return cartes;
	}

	/**
	 * Génére 2n cartes par paires identiques, selon le thème, et les mélangera (cette méthode
	 * devrait faire appel à genereCartes , et aux méthodes duplique et Carte.melangeCartes)
	 * @param int n Nombre de paires
	 * @return Carte[]
	 */
	public Carte[] generePairesDeCartesMelangees(int n) {
		// Débute par générer n cartes avec genereCartes
		Carte[] cartes = new Carte[2*n];
		int i = -1;
		for (Carte carte: genereCartes(n)) {
			cartes[++i] = carte;
			cartes[++i] = carte.duplique();
		}
		Carte.melangeCartes(cartes);
		return cartes;
	}

}