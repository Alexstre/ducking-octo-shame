import java.awt.*;
import java.util.Random;

/**
 * Classe CarteCouleur, sous-classe de Carte.
 * Implémente un type de Carte correspondant à une couleur
 * @author Alex Marcotte
 * @see Carte
 */
@SuppressWarnings("serial")
class CarteCouleur extends Carte {

	// recto est true si le dessus de la carte est montré
	protected boolean recto;

	// Couleurs disponibles pour les cartes
	public static Color[] couleurs = new Color[]{Color.RED,Color.GREEN,Color.BLUE,Color.CYAN,Color.MAGENTA,Color.YELLOW,Color.PINK,Color.ORANGE};

	// Couleur de cette instance de carte
	protected Color couleur;

	/**
	 * Constructeur de CarteCouleur
	 * @param recto Un bool qui représente si la carte est recto ou verso
	 */
	public CarteCouleur(boolean recto) {
		super(recto);
		this.couleur = couleurHasard();
	}

	/**
	 * Implementation de duplique
	 * @see Carte#duplique
 	 * @return Carte
	 */
	public Carte duplique() {
		CarteCouleur nouvelle = new CarteCouleur(estMontree());
		nouvelle.couleur = this.couleur;
		return nouvelle;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * (ie. on la même couleur de recto)
	 * @param c 		Une carte avec laquelle comparée
	 * @return boolean 	true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return this.couleur.equals(((CarteCouleur)c).couleur);
	}

	/**
	 * Méthode paintRecto, implementation de paintRecto pour peindre le verso
	 * @param g 	Un contexte graphique 2D
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();
		g.setColor(this.couleur);
		g.fillRect(10, 10, dimen.width - 20, dimen.height - 20);
	}

	/**
	 * Méthode toString retourne une String qui représente la carte
	 * @return String
	 */
	public String toString() {
		return "Carte de Couleur: " + this.couleur;
	}

	/**
	 * Méthode couleurHasard retourne une couleur au hasard parmis celles disponibles
	 * @return Color
	 */
	private Color couleurHasard() {
		int index = new Random().nextInt(couleurs.length);
		return couleurs[index];
	}

}