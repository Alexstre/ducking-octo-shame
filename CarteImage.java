import java.awt.*;
import javax.swing.*;

/**
 * Classe CarteImage
 * @author Alex Marcotte
 * @see #Carte
 */

@SuppressWarnings("serial")
class CarteImage extends Carte {

	protected boolean recto;
	protected ImageIcon image;

	public CarteImage(boolean recto, ImageIcon img) {
		super(recto);
		this.image = img;
		System.out.println("Constructeur de CarteImage");
	}

	public CarteImage(Carte c) {
		super(c);
		System.out.println("Constructeur de copie de CarteImage");
	}

	/**
	 * Implementation de duplique
 	 * @return Carte	 
	 */
	public Carte duplique() {
		CarteImage carte = new CarteImage(estMontree(), this.image);
		return carte;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * @param Carte c
	 * @return boolean true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		System.out.println("This: " + this.image + " Other: " + ((CarteImage)c).image);
		return this.image.getImage().equals(((CarteImage)c).image.getImage());
	}

	/**
	 * Implementation de paintRecto
	 * Methode pour peindre le verso
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();
		g.drawImage(image.getImage(), 10, 10, dimen.width - 20, dimen.height - 20, this);
		System.out.format("paintRecto dans CarteMot (%d, %d)%n", dimen.width, dimen.height);
	}

	public String toString() {
		return "CarteImage()";
	}
}