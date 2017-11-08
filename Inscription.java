/*Bibliothèques fenêtre*/
import java.awt.*;
import javax.swing.*;
/*Bibliothèque récupérer un évènement par clique*/
import java.awt.event.*;


public class Inscription extends JFrame implements ActionListener{

/*....................Déclaration des variables..................*/

	private JLabel nomLabel, prenomLabel,mdpLabel,ageLabel, icon, erreurLabel;
	private JPanel pano1, panoNom, panoPrenom, panoMdp,panoAge, panoIcon, content, panoValidation, pano2;
	public JTextField nom, prenom, age, mdp;
	private JButton validation, annulation, ok;
	private JOptionPane pane1, pane2,pane3, pane4;
	public String textNom,textPrenom,textAge, textMdp;

/*............Affichage de l'interface d'inscription..........*/

	public Inscription(){
		/*****Création de la fenêtre taille-nom*****/
		setSize(600,500);
		setTitle("INSCRIPTION/CREATION DE COMPTE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*****Créer un panneau dans la fenetre avec un espace de 20 entre chaque éléments*****/ 
		pano1 = new JPanel(new BorderLayout(20,20));
		pano1.setBackground(Color.white);
		/*****Panneau nom*****/
			/*Caractéristiques principale du panneau couleur-taille-titre*/
    			panoNom = new JPanel();
    			panoNom.setBackground(Color.lightGray);
    			panoNom.setPreferredSize(new Dimension(400, 100));
			panoNom.setBorder(BorderFactory.createTitledBorder("Nom du l'utilisateur"));
			/*Création des composants*/
    			nom = new JTextField();
    			nom.setPreferredSize(new Dimension(100, 25));
    			nomLabel = new JLabel("Saisir votre nom :");
			/*Rajout des composants au panneau*/
    			panoNom.add(nomLabel);
    			panoNom.add(nom);
		/*****Panneau Age*****/
			/*Caractéristiques principale du panneau couleur-taille-titre*/
			panoAge = new JPanel();
    			panoAge.setBackground(Color.lightGray);
    			panoAge.setPreferredSize(new Dimension(400, 100));
			panoAge.setBorder(BorderFactory.createTitledBorder("Age de l'utilisateur"));
			/*Création des composants*/
    			age = new JTextField();
    			age.setPreferredSize(new Dimension(100, 25));
    	  		ageLabel = new JLabel("Saisir votre age :");
			/*Rajout des composants au panneau*/
    			panoAge.add(ageLabel);
    			panoAge.add(age);
		/*****Panneau Prenom*****/
			/*Caractéristiques principale du panneau couleur-taille-titre*/
			panoPrenom = new JPanel();
    			panoPrenom.setBackground(Color.lightGray);
    			panoPrenom.setPreferredSize(new Dimension(400, 100));
			panoPrenom.setBorder(BorderFactory.createTitledBorder("Prénom de l'utilisateur"));
			/*Création des composants*/
    			prenom = new JTextField();
    			prenom.setPreferredSize(new Dimension(100, 25));
     			prenomLabel = new JLabel("Saisir votre prénom :");
			/*Rajout des composants au panneau*/
    			panoPrenom.add(prenomLabel);
    			panoPrenom.add(prenom);
		/*****Panneau Mot de Passe*****/
			/*Caractéristiques principale du panneau couleur-taille-titre*/
			panoMdp = new JPanel();
    			panoMdp.setBackground(Color.lightGray);
    			panoMdp.setPreferredSize(new Dimension(400, 100));
			panoMdp.setBorder(BorderFactory.createTitledBorder("Mot de passe de l'utilisateur"));
			/*Création des composants*/
    			mdp = new JTextField();
    			mdp.setPreferredSize(new Dimension(100, 25));
    	   		mdpLabel = new JLabel("Saisir votre mot de passe :");
			/*Rajout des composants au panneau*/
    			panoMdp.add(mdpLabel);
    			panoMdp.add(mdp);
		/******Icon******/
			/*Importation de l'image*/
			icon = new JLabel(new ImageIcon("cle.gif"));
			/*Création du panneau*/
			panoIcon = new JPanel();
			panoIcon.setBackground(Color.white);
			/*Mise en page*/
			panoIcon.setLayout(new BorderLayout());
			panoIcon.add(icon);
		/*****Boutons******/
			/*Création et initialisation des boutons*/
			validation = new JButton("VALIDER");
			validation.addActionListener(this);
			annulation = new JButton("ANNULER");
			annulation.addActionListener(this);
			/*Caractéristiques principale du panneau couleur-taille-titre*/	
			panoValidation = new JPanel();
			panoValidation.setBackground(Color.white);
    			panoValidation.setPreferredSize(new Dimension(300, 100));
			/*Rajout des composants au panneau*/
    			panoValidation.add(validation);
			panoValidation.add(annulation);
		/*****Panneau central*****/
		content = new JPanel();
		content.setBackground(Color.white);
		content.add(panoNom);
		content.add(panoPrenom);
		content.add(panoAge);
		content.add(panoMdp);
		content.add(panoValidation);
		/*****Affichage panneau*****/
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(panoIcon, BorderLayout.WEST);
		setVisible(true);
	}

/*......Création de la liste comparative pour l'âge...........*/

/*L'objectif est de vréifier si l'utilisateur rentre bien un entier ou pas pour son âge
et s'il n'est pas trop jeune pour se créer un compte (age limite : 14 ans)*/
	
	public int testAge(){
		try {
			int number = Integer.parseInt(textAge);
			if (number<14){
				return 2;
			}
			else{
				return 0;
			}
			
		}
		catch (NumberFormatException e) {
			return 1;
		}
	}

/*........................Récupération clicks......................*/

	public  void actionPerformed(ActionEvent e){
		/******Si l'utilisateur appuie sur "Annuler", on ferme la fenêtre******/
        	if (e.getSource()==annulation){
			this.dispose();
		}
		/******Si l'utilisateur apppuie sur "Valider"*******/
		else{
			/*On transforme les frappes utilisateur en string*/
			textNom = nom.getText();
			textPrenom = prenom.getText();
			textAge = age.getText();
			textMdp = mdp.getText();
			/*On initialise la vérification de l'âge*/
			int testAge = testAge();
			/*Vérification que tous les champs soient pleins et affichage message*/
			if (textNom.length() == 0||textPrenom.length() == 0||textAge.length() == 0 ||textMdp.length() == 0){
				pane1=new JOptionPane();
				pane1.showMessageDialog(null,"ERREUR : COMPLETEZ TOUS LES CHAMPS !","ERREUR !!",JOptionPane.INFORMATION_MESSAGE);
			}
			/*Vérification que l'age est un nombre et affichage message*/
			if ((testAge == 1)&&(textNom.length() != 0||textPrenom.length() != 0||textAge.length() != 0||textMdp.length() != 0)&&(textAge.length() != 0)){
				pane2=new JOptionPane();
				pane2.showMessageDialog(null,"ERREUR : VOTRE AGE N'EST PAS VALIDE !","ERREUR !!",JOptionPane.INFORMATION_MESSAGE);
			}
			/*Vérification de l'âge limite et affichage message*/
			if ((testAge == 2)&&(textNom.length() != 0||textPrenom.length() != 0||textMdp.length() != 0)){
				pane3=new JOptionPane();
				pane3.showMessageDialog(null,"ERREUR : VOUS ETES TROP JEUNE !","ERREUR !!",JOptionPane.INFORMATION_MESSAGE);
			}
			/*Validation de la création du compte de l'utilisateur*/
			if ((testAge == 0)&&(textNom.length() != 0||textPrenom.length() != 0||textAge.length() != 0||textMdp.length() != 0)) {
				pane4=new JOptionPane();
				pane4.showMessageDialog(null,"Votre identifiant est : "+textNom+textPrenom.substring(0,1)+"\nVotre mot de passe est : "+textMdp+"\nAppuyez maintenant sur 'Déjà Utilisateur'","COMPTE CREE",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		}
    	}
}
