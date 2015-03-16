import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.Timer;

/**
 * Classe Abstraite Carte
 * @author Alex Marcotte
 * @since Mars 2015
 */
@SuppressWarnings("serial")
abstract class Carte extends JComponent {

	private boolean recto; 

	protected int multi = 1;

	/**
	 * Constructeur pour la classe Carte
	 * @param recto Détermine si la carte affiche son recto
	 */
	protected Carte(boolean recto) {
		this.recto = recto;
		System.out.println("Constructeur de Carte, recto = " + this.recto);
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
	 * @param g Context graphique
	 */
	public void paintVerso(Graphics2D g) {
		Dimension dimen = getSize();
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, (dimen.width - 20) * multi, (dimen.height - 20) * multi);
	}

	/**
	 * Methode abstraite pour peindre le verso, pour implementation
	 * @param g Un contexte graphique Graphics2D
	 */
	abstract void paintRecto(Graphics2D g);

	/**
	 * Redefinition de paintComponent qui appelle paintRecto ou paintVerso
	 * @param g Un contexte graphique Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		if (estMontree()) {
			paintRecto(g2);
		} else {
			paintVerso(g2);
		}
	}

	/**
	 * Methode abstraite pour determiner si deux cartes sont identiques
	 * @param c 		Une carte avec laquelle comparer
	 * @return boolean 	True si les cartes sont identiques
	 */
	abstract boolean rectoIdentique(Carte c);

	/**
	 * Methode abstraite pour retourner une copie identique d'un object
 	 * @return Carte	 
	 */
	public abstract Carte duplique();

	/**
	 * Methode pour melanger un tableau d'instance de Carte
	 * @param cartes Un tableau d'objets de type Carte
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

	/**
	 * Méthode getMulti retourne le multiplicateur de grandeur pour la carte
	 * @return int
	 */
	public int getMulti() {
		return this.multi;
	}

	/**
	 * Méthode setMulti modifie le multiplicateur de grandeur
	 * @param multi 	Un entier
	 */
	public void setMulti(int multi) {
		this.multi = multi;
	}

}