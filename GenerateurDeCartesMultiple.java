class GenerateurDeCartesMultiple extends GenerateurDeCartes {

	protected String nom = "Multiple";

	/**
	 * Retourne une référence de type Carte à une carte choisie aléatoirement parmi celles du thème.
	 * @return Carte
	 */
	public Carte genereUneCarte() {
		return new CarteCouleur(true);
	}

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * @param int
	 */
	public int nombreDeCartesDifferentes() {
		return 5;
	}

}