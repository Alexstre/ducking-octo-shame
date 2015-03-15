/**
 * Classe CarteCouleur
 * @author Alex Marcotte
 * @see #Carte
 */

@SuppressWarnings("serial")
class CarteCouleur extends Carte {

	public CarteCouleur(boolean recto) {
		super(recto);
		System.out.println("Constructeur de CarteCouleur");
	}

	public CarteCouleur(Carte c) {
		super(c);
		System.out.println("Constructeur de copie de CarteCouleur");
	}


	/**
	 * Implementation de duplique
 	 * @return Object	 
	 */
	public Object duplique() {
		return new Object();
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * @param Carte c
	 * @return boolean true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return true;
	}

	/**
	 * Implementation de paintRecto
	 * Methode pour peindre le verso
	 */
	public void paintRecto() {
		System.out.println("paintRecto dans CarteCouleur");
	}

	public String toString() {
		return "CarteCouleur()";
	}
}