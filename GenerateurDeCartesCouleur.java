class GenerateurDeCartesCouleur extends GenerateurDeCartes {

	public String nom = "Couleur";

	public GenerateurDeCartesCouleur(String nom) {
		this.nom = nom;
	}

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
	 * @param int
	 */
	public int nombreDeCartesDifferentes() {
		return 8;
	}

}