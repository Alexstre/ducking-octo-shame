import java.awt.*;
import java.util.Random;

/**
 * Classe CarteCouleur
 * @author Alex Marcotte
 * @see #Carte
 */
@SuppressWarnings("serial")
class CarteCouleur extends Carte {

	/**
	 * @var boolean recto
	 */
	protected boolean recto;

	/**
	 * @var Color[] couleurs Array des couleurs possibles pour les cartes
	 */
	public static Color[] couleurs = new Color[]{Color.RED,Color.GREEN,Color.BLUE,Color.CYAN,Color.MAGENTA,Color.YELLOW,Color.PINK,Color.ORANGE};

	/**
	 * @var Color couleur Couleur de la carte (recto)
	 */
	protected Color couleur;

	public CarteCouleur(boolean recto) {
		super(recto);
		this.couleur = couleurHasard();
		System.out.println("Constructeur de CarteCouleur, recto = " + estMontree());
	}

	public CarteCouleur(Carte c) {
		super(c);
		System.out.println("Constructeur de copie de CarteCouleur");
	}

	/**
	 * Implementation de duplique
 	 * @return Carte
	 */
	public Carte duplique() {
		System.out.println("Duplique() dans CarteCouleur, recto = " + estMontree());
		CarteCouleur nouvelle = new CarteCouleur(estMontree());
		nouvelle.couleur = this.couleur;
		return nouvelle;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * (ie. on la même couleur de recto)
	 * @param Carte c
	 * @return boolean true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return this.couleur.equals(((CarteCouleur)c).couleur);
	}

	/**
	 * Implementation de paintRecto
	 * Methode pour peindre le verso
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();
		g.setColor(this.couleur);
		g.fillRect(10, 10, dimen.width - 20, dimen.height - 20);

		System.out.format("paintRecto dans CarteCouleur (%d, %d)%n", dimen.width, dimen.height);
	}

	public String toString() {
		return "Carte de Couleur " + this.couleur;
	}

	private Color couleurHasard() {
		int index = new Random().nextInt(couleurs.length);
		return couleurs[index];
	}

}