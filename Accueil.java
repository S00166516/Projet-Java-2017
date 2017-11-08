/*Bibliothèques fenêtre*/
import java.awt.*;
import javax.swing.*;
/*Bibliothèque récupérer un évènement par clique*/
import java.awt.event.*;

public class Accueil extends JFrame implements ActionListener{
/*....................Déclaration des variables..................*/
	private JButton acces1, acces2;
	private JLabel titre,choix,eleve;
	private JPanel pano;
/*...............Affichage de l'interface d'accueil...........*/
	public Accueil(){
		/*Création de la fenêtre*/
		setSize(500,400);
		setTitle("INTERFACE BANQUE AAJ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*Créer un panneau dans la fenetre avec un espace de 20 entre chaque éléments*/ 
		pano = new JPanel(new BorderLayout(20,20));
		pano.setBackground(Color.lightGray);
		/*Rajouter les éléments au panneau*/
		acces1 = new JButton("Nouvel Utilisateur");
		acces1.setBackground(Color.white);
		acces2  = new JButton("Déjà Utilisateur");
		acces2.setBackground(Color.white);
		titre = new JLabel("                                      BIENVENUE SUR L'INTERFACE AAJ");
		choix = new JLabel("  FAITES VOTRE CHOIX");
		eleve = new JLabel("Par FALCOU Julie, MAITRE Adrien, PAU Allan");
		/*Mode écoute des boutons (attente de clique)*/
		acces1.addActionListener(this);
		acces2.addActionListener(this);
		/*Afficher texte ou image*/
		pano.add(acces1, BorderLayout.WEST);
		pano.add(acces2, BorderLayout.EAST);
		pano.add(titre, BorderLayout.NORTH);
		pano.add(choix, BorderLayout.CENTER);
		pano.add(eleve, BorderLayout.SOUTH);
		add(pano);
		/*Affichage du panneau*/
		setVisible(true);
	}
/*............Récupération du choix de l'utilisateur............*/
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==acces1){
			new Inscription();
		}
		else{
			//new Connection();
		}
	}
	
	public static void main(String[] args){
		new Accueil();	
	}

}
