import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JeuMemory {

	public static void main(String[] args) {
		if (args.length < 5) {
			afficheAide();
			System.exit(0);
		}

		int rangees 		= Integer.parseInt(args[0]);
		int colonnes 		= Integer.parseInt(args[1]);
		int delai_initial 	= Integer.parseInt(args[2]);
		int delai_erreur 	= Integer.parseInt(args[3]);
		int num_theme 		= Integer.parseInt(args[4]);

		InterfaceJeu jeu = new InterfaceJeu(rangees, colonnes, delai_initial, delai_erreur, num_theme);

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

	public static class InterfaceJeu {
		private GenerateurDeCartes generateur;
		private PanneauDeCartes panneau;
		private int rangees;
		private int colonnes;
		private int delai_initial;
		private int delai_erreur;
		private int num_theme;
		private JPanel inside;
		private JPanel boutons;
		private JFrame frame;
		private Carte[] cartes;

		public InterfaceJeu(int rangees, int colonnes, int delai_initial, int delai_erreur, int num_theme) {
			this.rangees = rangees;
			this.colonnes = colonnes;
			this.delai_initial = delai_initial;
			this.delai_erreur = delai_erreur;
			this.num_theme = num_theme;

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
				String[] images = {"images/animaux/bird.jpg", "images/animaux/camel.jpg", "images/animaux/cheetah.jpg", "images/animaux/elephant.jpg", "images/animaux/gorille.jpg", "images/animaux/hare.jpg", "images/animaux/polarbear.jpg", "images/animaux/seal.jpg", "images/animaux/tiger.jpg"};
				generateur = new GenerateurDeCartesImage("Animaux", images);
			} else if (num_theme == 4) { // Image galaxie
				String[] images = {"images/galaxie/galaxy1.jpg", "images/galaxie/galaxy2.jpg", "images/galaxie/galaxy3.jpg", "images/galaxie/galaxy4.jpg", "images/galaxie/galaxy5.jpg", "images/galaxie/galaxy6.jpg", "images/galaxie/galaxy7.jpg", "images/galaxie/galaxy8.jpg", "images/galaxie/galaxy9.jpg", "images/galaxie/galaxy10.jpg"};
				generateur = new GenerateurDeCartesImage("Galaxie", images);
			}
			
			cartes = generateur.generePairesDeCartesMelangees(rangees*colonnes/2);
			panneau = new PanneauDeCartes(rangees, colonnes, cartes, delai_initial, delai_erreur);

			/**
			 * @var JFrame frame JFrame principale du jeu (contient PanneauDeCartes)
			 */
			frame = new JFrame("JeuMemory");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(colonnes*200, rangees*200);

	 		inside = new JPanel(new BorderLayout());
	 		boutons = new JPanel(new FlowLayout());		

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
					frame.dispose();
					new InterfaceJeu(rangees, colonnes, delai_initial, delai_erreur, num_theme);
				}
			});

			/**
			 * @var JButton resoudre Le bouton pour resoudre
			 */
			JButton resoudre = new JButton("Resoudre");
			resoudre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panneau.resoudreJeu();
				}
			});

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
	}

}