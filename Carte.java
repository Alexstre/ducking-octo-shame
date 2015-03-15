import javax.swing.*;
import java.awt.*;

/**
 * Classe Abstraite Carte
 * @author Alex Marcotte
 * @see #CarteCouleur
 * @see #CarteMot
 * @see #CarteImage
 */
@SuppressWarnings("serial")
abstract class Carte extends JComponent {

	/**
	 * Constructeur pour la classe Carte
	 * @param boolean recto
	 * @return Carte
	 */
	protected Carte(boolean recto) {
		System.out.println("Hey");
	}

	/**
	 * Constructeur de copie
	 * @param Carte c
	 * @return Carte
	 */
	protected Carte(Carte c) {
		System.out.println("Hi");
	}

	/**
	 * @return boolean True si la face est montree
	 */
	public boolean estMontree() {
		return true;
	}

	/**
	 * @return boolean True si la face est cachee
	 */
	public boolean estCache() {
		return !estMontree();
	}

	/** Montre la carte */
	public void montre() {
		System.out.println("Montre la carte");
	}

	/** Cache la carte */
	public void cache() {
		System.out.println("Cache la carte");
	}

	/** Retourne la carte */
	public void retourne() {
		System.out.println("Retourne la carte");
	}

	/**
	 * Peint le verso d'une carte dans le contexte graphique g
	 * @param Graphics2D g Context graphique
	 */
	public void paintVerso(Graphics2D g) {
		System.out.println("PaintVerso");
	}

	/**
	 * Methode abstraite pour peindre le verso, pour implementation;
 	 * @see #CarteCouleur
 	 * @see #CarteMot
 	 * @see #CarteImage
	 */
	abstract void paintRecto();

	/**
	 * Redefinition de paintComponent
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("PaintComponent");
	}

	/**
	 * Methode abstraite pour determiner si deux cartes sont identiques
	 * @param Carte c
	 * @return boolean True si les cartes sont identiques
	 * @see #CarteCouleur
 	 * @see #CarteMot
 	 * @see #CarteImage
	 */
	abstract boolean rectoIdentique(Carte c);

	/**
	 * Methode abstraite pour retourner une copie identique d'un object
 	 * @see #CarteCouleur
 	 * @see #CarteMot
 	 * @see #CarteImage
 	 * @return Object	 
	 */
	public abstract Object duplique();

	/**
	 * Methode pour melanger un tableau d'instance de Carte
	 * @param Carte[] cartes Un tableau d'objets de type Carte
	 */
	public static void melangeCartes(Carte[] cartes) {
		System.out.println("melangeCartes");
	}

}