import javax.swing.*;
import java.util.Random;

/**
 * Classe GenerateurDeCartesImage
 * @author Alex Marcotte
 * @since Mars 2015
 * @see GenerateurDeCartes
 */
class GenerateurDeCartesImage extends GenerateurDeCartes {

	protected String nom = "Images";

	protected String[] images;

	public GenerateurDeCartesImage(String nom, String[] images) {
		this.nom = nom;
		this.images = images;
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
		int index = new Random().nextInt(this.images.length);
		ImageIcon image = new ImageIcon(images[index]);
		return new CarteImage(true, image);
	}

	/**
	 * Retourne un entier indiquant le nombre de cartes différentes disponibles dans ce thème
	 * @return int
	 */
	public int nombreDeCartesDifferentes() {
		return images.length;
	}

}