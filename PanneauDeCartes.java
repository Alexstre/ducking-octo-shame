import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class PanneauDeCartes extends JPanel {


 public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes, int delaiAffichageInitial, int delaiAffichageMauvaisePaire) {
        GridLayout layout = new GridLayout(nRangees,nColonnes);
        layout.setHgap(10);
        layout.setVgap(10);
        setLayout(layout);
	}

}