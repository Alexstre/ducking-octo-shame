/**
 * Classe CarteImage
 * @author Alex Marcotte
 * @see #Carte
 */

@SuppressWarnings("serial")
class CarteImage extends Carte {

	public CarteImage(boolean recto) {
		super(recto);
		System.out.println("Constructeur de CarteImage");
	}

	public CarteImage(Carte c) {
		super(c);
		System.out.println("Constructeur de copie de CarteImage");
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
		System.out.println("paintRecto dans CarteImage");
	}

	public String toString() {
		return "CarteImage()";
	}
}