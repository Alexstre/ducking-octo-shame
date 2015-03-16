import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.net.*;

/**
 * Classe PanneauDeCartes
 * Représente un panneau de cartes de n'importe quel sous-classes de Carte
 * @author Alex Marcotte
 */

@SuppressWarnings("serial")
class PanneauDeCartes extends JPanel {

	private Carte[] cartes;

	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire) {
		GridLayout layout = new GridLayout(nRangees, nColonnes);
		layout.setHgap(10);
		layout.setVgap(10);
		setLayout(layout);

		this.cartes = cartes;

		// Ajoute les cartes au panneau
		for (Carte carte: cartes) {
			add(carte); // Ajoute la carte dans le panneau
		}

		ActionSourie listener = new ActionSourie(delaiAffichageMauvaisePaire, cartes.length/2);

		/**
		 * @var Timer timer Gère le début de la partie après
		 */
		Timer timer = new Timer(delaiAffichageInitial, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Début de la partie, on veut retourner toutes les cartes
				retourneToutesLesCartes();
				// Puis on ajoute le mouseListener aux cartes
				for (Carte carte: cartes) {
					carte.addMouseListener(listener);
				}
			}
		});
		timer.setInitialDelay(delaiAffichageInitial);
		timer.setRepeats(false);
		timer.start();
	}

	private void retourneToutesLesCartes() {
		for (Carte carte: cartes) {
			carte.retourne();
		}
	}

	public void resoudreJeu() {
		for (Carte carte: cartes) {
			carte.montre();
			carte.removeMouseListener(carte.getMouseListeners()[0]);
		}
	}

}