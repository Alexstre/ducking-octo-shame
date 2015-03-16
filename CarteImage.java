import java.awt.*;
import javax.swing.*;

/**
 * Classe CarteImage implémente une carte qui comprend une image
 * @author Alex Marcotte
 * @see Carte
 */
@SuppressWarnings("serial")
class CarteImage extends Carte {

	protected boolean recto;
	protected ImageIcon image;

	/**
	 * Constructeur
	 * @param recto 	Un booléen si le dessus de la carte est affichée
	 * @param img 		Une image à ajouter sur la carte
	 */
	public CarteImage(boolean recto, ImageIcon img) {
		super(recto);
		this.image = img;
	}

	/**
	 * Implementation de duplique
 	 * @return Carte
 	 * @see Carte#duplique
	 */
	public Carte duplique() {
		CarteImage carte = new CarteImage(estMontree(), this.image);
		return carte;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * @param c 		Une carte avec laquelle comparée
	 * @return boolean 	true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return this.image.getImage().equals(((CarteImage)c).image.getImage());
	}

	/**
	 * Implementation de paintRecto pour peindre le verso
	 * @param g un contexte graphique Graphics2D
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();
		g.drawImage(image.getImage(), 10, 10, dimen.width - 20, dimen.height - 20, this);
	}

	/**
	 * Méthode toString retourne une String qui représente la carte
	 * @return String
	 */
	public String toString() {
		return "CarteImage avec " + this.image.getImage();
	}
}