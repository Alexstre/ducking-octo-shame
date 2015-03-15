import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.Timer;

/**
 * Classe Abstraite Carte
 * @author Alex Marcotte
 * @see #CarteCouleur
 * @see #CarteMot
 * @see #CarteImage
 */
@SuppressWarnings("serial")
abstract class Carte extends JComponent {

	private boolean recto; 

	protected int multi = 1;

	protected int marge_x = 10;
	protected int marge_y = 10;

	/**
	 * Constructeur pour la classe Carte
	 * @param boolean recto
	 * @return Carte
	 */
	protected Carte(boolean recto) {
		this.recto = recto;
		System.out.println("Constructeur de Carte, recto = " + this.recto);
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
		return this.recto;
	}

	/**
	 * @return boolean True si la face est cachee
	 */
	public boolean estCache() {
		return !estMontree();
	}

	/** Montre la carte */
	public void montre() {

		if (estCache()) {
			this.recto = true;
			repaint();
		}

		System.out.println("Montre la carte");
	}

	/** Cache la carte */
	public void cache() {
		if (estMontree()) {
			this.recto = false;
			repaint();
		}
		System.out.println("Cache la carte");
	}

	/** Retourne la carte */
	public void retourne() {
		if (estMontree()) {
			cache();
		} else {
			montre();
		}
		System.out.println("Retourne la carte");
	}

	/**
	 * Peint le verso d'une carte dans le contexte graphique g
	 * Puisque les cartes on toutes le même verso, pas besoin de 
	 * redéfinir dans les sous-classes de Carte
	 * @param Graphics2D g Context graphique
	 */
	public void paintVerso(Graphics2D g) {
		Dimension dimen = getSize();
		g.setColor(Color.BLACK);
		g.fillRect(marge_x, marge_y, (dimen.width - 2*marge_x) * multi, (dimen.height - 2*marge_y) * multi);
	}

	/**
	 * Methode abstraite pour peindre le verso, pour implementation;
 	 * @see #CarteCouleur
 	 * @see #CarteMot
 	 * @see #CarteImage
	 */
	abstract void paintRecto(Graphics2D g);

	/**
	 * Redefinition de paintComponent qui appelle paintRecto ou paintVerso
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		if (estMontree()) {
			paintRecto(g2);
		} else {
			paintVerso(g2);
		}

		System.out.println("PaintComponent dans Carte");
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
 	 * @return Carte	 
	 */
	public abstract Carte duplique();

	/**
	 * Methode pour melanger un tableau d'instance de Carte
	 * @param Carte[] cartes Un tableau d'objets de type Carte
	 */
	public static void melangeCartes(Carte[] cartes) {
		Random r = new Random();
		for (int i = 0; i < cartes.length; i++) {
			int index = r.nextInt(i + 1);

			Carte a = cartes[index];
			cartes[index] = cartes[i];
			cartes[i] = a;
		}
	}

	public int getMulti() {
		return this.multi;
	}

	public void setMulti(int multi) {
		this.multi = multi;
	}

}