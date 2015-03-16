import javax.swing.*;
import java.util.Random;

class GenerateurDeCartesImage extends GenerateurDeCartes {

	protected String nom = "Images";

	protected String[] images;

	public GenerateurDeCartesImage(String nom, String[] images) {
		this.nom = nom;
		this.images = images;
	}

	public String getNom() {
		return this.nom;
	}

	public String[] getImages() {
		return this.images;
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
	 * @param int
	 */
	public int nombreDeCartesDifferentes() {
		return images.length;
	}

}