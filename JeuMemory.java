import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JeuMemory {

	/**
	 * @var Carte[] cartes Contient les cartes pour le jeu
	 */
	private static Carte[] cartes;

	/**
	 * @var GenerateurDeCartesCouleur generate
	 */
	private static GenerateurDeCartes generateur;

	/**
	 * @var PanneauDeCartes panneau JComponent qui contient les cartes
	 */
	private static PanneauDeCartes panneau;

	private static int rangees;
	private static int colonnes;
	private static int delai_initial;
	private static int delai_erreur;
	private static int num_theme;

	public static void main(String[] args) {

		if (args.length < 5) {
			afficheAide();
			System.exit(0);
		}

		rangees 		= Integer.parseInt(args[0]);
		colonnes 		= Integer.parseInt(args[1]);
		delai_initial 	= Integer.parseInt(args[2]);
		delai_erreur 	= Integer.parseInt(args[3]);
		num_theme 		= Integer.parseInt(args[4]);

		nouvellePartie();

		/**
		 * @var JFrame frame JFrame principale du jeu (contient PanneauDeCartes)
		 */
		JFrame frame = new JFrame("JeuMemory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(colonnes*200, rangees*200);

		/**
		 * @var JPanel inside Contient le panneau et les boutons
		 */
		JPanel inside = new JPanel(new BorderLayout());

		/**
		 * @var JButton quitter Le bouton pour quitter
		 */
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		/**
		 * @var JButton recommencer Le bouton pour faire une nouvelle partie
		 */
		JButton recommencer = new JButton("Recommencer");
		recommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nouvellePartie();
			}
		});

		/**
		 * @var JButton resoudre Le bouton pour resoudre
		 */
		JButton resoudre = new JButton("Resoudre");

		/**
		 * JPanel boutons Contient les boutons au bas du JFrame
		 */
		JPanel boutons = new JPanel(new FlowLayout());
		boutons.add(resoudre);
		boutons.add(recommencer);
		boutons.add(quitter);

		// Ajoute les components au inside
		inside.add(panneau, BorderLayout.CENTER);
		inside.add(boutons, BorderLayout.SOUTH);

		// Puis on ajoute le inside au JFrame
		frame.add(inside);
		frame.setVisible(true);
	}

	/**
	 * Méthode afficheAide
	 * Affiche l'aide lorsque les paramètres entrés par ligne de commande
	 * ne sont pas valide (si le nombre total de paramètre est inférieur
	 * au nombre requis)
	 */
	private static void afficheAide() {
		System.out.println("Utilisation: java JeuMemory <nRangées> <nColonnes> <délaiAffichageInitial(ms)> <delaiAffichageMauvaisePaire(ms)> <numeroDeTheme>");
		System.out.println("Ex: java JeuMemory 5 6 5000 1000 3");
		System.out.println("Voici la liste des thèmes disponibles:");
		System.out.println("0: Cartes couleurs");
		System.out.println("1: Lettres A...Z");
		System.out.println("2: Noms d'émotions");
		System.out.println("3: Images d'animaux");
		System.out.println("4: Images de galaxies");
		System.out.println("5: Mélange des thèmes 0 à 4");
	}
	
	private static void nouvellePartie() {
		cartes = new Carte[rangees*colonnes];

		// Dépendemment du thème voulu...
		if (num_theme == 0) { // Couleur
			generateur = new GenerateurDeCartesCouleur("Couleurs");
		} else if (num_theme == 1) { // Lettres
			String[] lettres = "abcdefghijklmnopqrstuvwxyz".split("(?!^)");
			generateur = new GenerateurDeCartesMot("Lettres", lettres);
		} else if (num_theme == 2) { // Émotions
			// De http://www.carrefourtpl.com/index.php?option=com_content&view=article&id=116%3Aliste-des-emotions&catid=55&lang=fr
			String[] emotions = {"Joie", "Heureux", "Fier", "Passion", "Amour", "Outrage", "Furie", "Bougon", "Triste", "Chagrin", "Nerveux", "Souci", "Effroi", "Honte"};
			generateur = new GenerateurDeCartesMot("Emotions", emotions);
		} else if (num_theme == 3) { // Image animaux

		} else if (num_theme == 4) { // Image galaxie

		}
		
		cartes = generateur.generePairesDeCartesMelangees(rangees*colonnes/2);
		panneau = new PanneauDeCartes(rangees, colonnes, cartes, delai_initial, delai_erreur);
	}

}