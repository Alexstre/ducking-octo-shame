/**
 * Classe CarteMot
 * @author Alex Marcotte
 * @see #Carte
 */

@SuppressWarnings("serial")
class CarteMot extends Carte {

	public CarteMot(boolean recto) {
		super(recto);
		System.out.println("Constructeur de CarteMot");
	}

	public CarteMot(Carte c) {
		super(c);
		System.out.println("Constructeur de copie de CarteMot");
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
		System.out.println("paintRecto dans CarteMot");
	}

	public String toString() {
		return "CarteMot()";
	}
}