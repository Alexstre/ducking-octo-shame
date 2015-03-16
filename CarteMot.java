import java.awt.*;
import java.util.Random;

/**
 * Classe CarteMot implémente une carte qui comprend un mot
 * @author Alex Marcotte
 * @see Carte
 */
@SuppressWarnings("serial")
class CarteMot extends Carte {

	// recto
	protected boolean recto;

	// String
	protected String mot;

	/**
	 * Constructeur de CarteMot
	 * @param recto Un bool qui représente si la carte est recto ou verso
	 * @param mot 	Un mot qui est affiché sur la carte
	 */
	public CarteMot(boolean recto, String mot) {
		super(recto);
		this.mot = mot;
	}

	/**
	 * Implementation de duplique
 	 * @return Carte
 	 * @see Carte#duplique
	 */
	public Carte duplique() {
		CarteMot nouvelle = new CarteMot(estMontree(), this.mot);
		return nouvelle;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * (ie. on le même mot au recto)
	 * @param c 		Une carte
	 * @return boolean 	true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return this.mot.equals(((CarteMot)c).mot);
	}

	/**
	 * Implementation de paintRecto pour peindre le verso
	 * @param g Un contexte graphique Graphics2D
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();

		// Un rectangle qui contiendra le mot
		g.setColor(Color.ORANGE);
		g.fillRect(10, 10, dimen.width - 20, dimen.height - 20);

		// Le mot s'affiche en noir centré dans le rectangle
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Serif", Font.PLAIN, 32));

		FontMetrics fmetric = g.getFontMetrics();
		int x = (dimen.width - fmetric.stringWidth(this.mot)) / 2;
		int y = (fmetric.getAscent() + (dimen.height - (fmetric.getAscent() + fmetric.getDescent())) / 2);
		g.drawString(this.mot, x, y);
	}

	/**
	 * Méthode toString retourne une String qui représente la carte
	 * @return String
	 */
	public String toString() {
		return "Carte mot (" + this.mot + ")";
	}

}