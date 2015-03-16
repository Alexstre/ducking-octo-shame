import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;

/**
 * Class ActionSourite
 * Sera utilisé puisque MouseAdapter implémente déjà l'interface MouseListener et donc on n'aura qu'a override
 * les méthodes utilisées. La grande majoritée de la logique du jeu se trouve dans cette classe.
 * @see MouseAdapter
 * @see MouseListener
 */
class ActionSourie extends MouseAdapter {

	Carte derniere = null;

	int delaiAffichageMauvaisePaire;

	int nombreDePaires;
	int pairesTrouvees = 0;

	int clicks = 0;

	boolean ignore = false;

	/**
	 * Constructeur
	 * @param delaiAffichageMauvaisePaire	Délai avant de retourner les cartes
	 * @param nombreDePaires 				Nombre de paires (pour savoir si le jeu est complet)
	 */
	public ActionSourie(int delaiAffichageMauvaisePaire, int nombreDePaires) {
		this.delaiAffichageMauvaisePaire = delaiAffichageMauvaisePaire;
		this.nombreDePaires = nombreDePaires;
	}

	/**
	 * Méthode mouseClicked
	 * @see MouseAdapter#mouseClicked
	 * @param e Un MouseEvent qui contient l'objet cliqué
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.ignore) return;
		super.mouseClicked(e);
		Object source = e.getSource();

		clicks++;

		// La carte qui vient d'être choisie
		Carte carte = castSourceEnCarte(e.getSource());

		if (derniere == null) {
			System.out.println("Click sur une première carte");
			derniere = carte;
		} else {
			System.out.println("Click sur une deuxieme carte");
			// Il y a une carte d'affichée on les compare
			if (!carte.rectoIdentique(derniere)) {
				this.ignore = true;

				// Début du Timer avant de retourner les cartes
				Timer timer = new Timer(this.delaiAffichageMauvaisePaire, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						carte.retourne();
						derniere.retourne();
						derniere = null;
						ignore = false;
					}
				});
				timer.setInitialDelay(this.delaiAffichageMauvaisePaire);
				timer.setRepeats(false);
				timer.start();

			} else { // On a trouvé une paire, on veut donc 'reset' la dernière
				pairesTrouvees++;
				derniere = null;
			}
		}

		carte.retourne();

		// Fin de la partie
		if (pairesTrouvees == nombreDePaires) {
			String message;
			if (clicks == 2*nombreDePaires) {
				message = "Bravo! Vous avez trouvé toutes les paires avec le nombre minimum d'essais!";
			} else {
				message = "Bravo! Vous avez trouvé toutes les paires en " + clicks + " essais d'un minimum de " + 2*nombreDePaires;
			}
			JOptionPane.showMessageDialog(null, message);
		}
	}

	/**
	 * Méthode mouseEntered. Lancée lorsque le curseur entre sur une carte
	 * @see MouseAdapter#mouseEntered
	 * @param e Un MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		Carte carte = castComponentEnCarte(e.getComponent());
		carte.setMulti(2);
		carte.repaint();
	}


	/**
	 * Méthode mouseExisted. Lancée lorsque le curseur quitte une carte
	 * @see MouseAdapter#mouseExited
	 * @param e Un MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		Carte carte = castComponentEnCarte(e.getComponent());
		carte.setMulti(1);
		carte.repaint();		
	}

	/**
	 * Méthode castSourceEnCarte
	 * @param source Un objet (fourni par un MouseEvent)
	 * @return Carte Une instance de sous-classe de Carte appropriée
	 * @see #mouseExited
	 * @see #mouseEntered	 
	 */
	private Carte castSourceEnCarte(Object source) {
		// On cast la source en la classe correspondante
		if (source instanceof CarteCouleur) {
			return (CarteCouleur)source;
		} else if (source instanceof CarteImage) {
			return (CarteImage)source;
		} else if (source instanceof CarteMot) {
			return (CarteMot)source;
		} else {
			throw new IllegalArgumentException("Le type de carte n'est pas supporté\n");
		}
	}

	/**
	 * Méthode castComponentEnCarte
	 * @param c 		Un component (fourni par un MouseEvent)
	 * @return Carte 	Une instance de sous-classe de Carte appropriée
	 * @see #mouseExited
	 * @see #mouseEntered
	 */
	private Carte castComponentEnCarte(Component c) {
		// On cast la source en la classe correspondante
		if (c instanceof CarteCouleur) {
			return (CarteCouleur)c;
		} else if (c instanceof CarteImage) {
			return (CarteImage)c;
		} else if (c instanceof CarteMot) {
			return (CarteMot)c;
		} else {
			throw new IllegalArgumentException("Le type de carte n'est pas supporté\n");
		}
	}

}