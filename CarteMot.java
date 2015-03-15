import java.awt.*;

/**
 * Classe CartMot
 * @author Alex Marcotte
 * @see #Carte
 */
@SuppressWarnings("serial")
class CarteMot extends Carte {

	/**
	 * @var boolean recto
	 */
	protected boolean recto;

	/**
	 * @var String mot Le mot sur la carte
	 */
	protected String mot;

	public CarteMot(boolean recto, String mot) {
		super(recto);
		this.mot = mot;
	}

	public CarteMot(Carte c) {
		super(c);
	}

	/**
	 * Implementation de duplique
 	 * @return Carte
	 */
	public Carte duplique() {
		System.out.println("Duplique() dans CarteMot, recto = " + estMontree());
		CarteMot nouvelle = new CarteMot(estMontree(), this.mot);
		return nouvelle;
	}

	/**
	 * Implemente rectoIdentique pour determiner si deux cartes sont identiques
	 * (ie. on la même couleur de recto)
	 * @param Carte c
	 * @return boolean true si les cartes sont identiques
	 */
	public boolean rectoIdentique(Carte c) {
		return this.mot.equals(((CarteMot)c).mot);
	}

	/**
	 * Implementation de paintRecto
	 * Methode pour peindre le verso
	 */
	public void paintRecto(Graphics2D g) {
		Dimension dimen = getSize();
		g.setColor(Color.YELLOW);
		g.fillRect(10, 10, dimen.width - 20, dimen.height - 20);

		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Serif", Font.PLAIN, 32));

		FontMetrics fmetric = g.getFontMetrics();
		int x = (dimen.width - fmetric.stringWidth(this.mot)) / 2;
		int y = (fmetric.getAscent() + (dimen.height - (fmetric.getAscent() + fmetric.getDescent())) / 2);
		g.drawString(this.mot, x, y);

		System.out.format("paintRecto dans CarteMot (%d, %d)%n", dimen.width, dimen.height);
	}

	public String toString() {
		return "Carte mot (" + this.mot + ")";
	}

}