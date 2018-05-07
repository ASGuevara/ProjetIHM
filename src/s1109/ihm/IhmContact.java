/*
 * Module 1109 : module IHM : Formulaire de saisie d'un contact
 */
package s1109.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import s1109.Contact;
import s1109.DispoSortie;
import s1109.Hobby;
import s1109.Mois;


/**
 *
 * @author IUT2
 */
public class IhmContact extends Observable {
// A complÃ©ter

    private JPanel panelPrincipal;
    private JTextField champNom;  // composant pour la saisie du nom 
    private JComboBox champDateNaissJour;
    private JComboBox champDateNaissMois;
    private JComboBox champDateNaissAnnee;
    private JTextField champNumeroTelephone;
    private HashMap<DispoSortie, JRadioButton> radioButtonDisponibilite;
    private HashMap<Hobby, JCheckBox> checkBoxHobbies;
    private JTextArea commentaire;

    /**
     * Formulaire pour saisir les informations relatives Ã  un contact
     */
    public IhmContact() {

        panelPrincipal = new JPanel();
       
        panelPrincipal.setLayout(new BorderLayout());
        initUIComponents();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * CrÃ©e les composants graphiques constituant l'interface
     */
    private void initUIComponents() {
        /*
         * CrÃ©ation des Widgets pour la saisie du : nom, prÃ©nom, tÃ©lÃ©phone ... Ã  complÃ©ter
         */
        
        Contact contact=new Contact();
        radioButtonDisponibilite = new HashMap<DispoSortie, JRadioButton>();
        checkBoxHobbies = new HashMap<Hobby, JCheckBox>();
        
        //------------------------------------------
        //             IDENTITE
        //-------------------------------------------
        
        JPanel panelIdentite=new JPanel();
        panelIdentite.setLayout(new GridLayout(3,2));

        panelIdentite.add(new JLabel("Nom ",SwingConstants.RIGHT));         //1
        champNom = new JTextField(30);  
        panelIdentite.add(champNom);                  //2

        panelIdentite.add(new JLabel("Date de naissance : ",SwingConstants.RIGHT));  //3
        JPanel panelDateNaiss=new JPanel();
        panelDateNaiss.setLayout(new GridLayout(1,3));
        
        champDateNaissJour = new JComboBox();
        for (int i = 1; i < 32; i++) {
            champDateNaissJour.addItem(i);
        }
        panelDateNaiss.add(champDateNaissJour);    //1bis
        
        champDateNaissMois = new JComboBox(Mois.values());
        panelDateNaiss.add(champDateNaissMois);    //2bis

        champDateNaissAnnee = new JComboBox();
        for (int i = 1900; i < 2030; i++) {
            champDateNaissAnnee.addItem(i);
        }
        panelDateNaiss.add(champDateNaissAnnee);    //3bis
        panelIdentite.add(panelDateNaiss);                          //4

        panelIdentite.add(new JLabel("Téléphone ",SwingConstants.RIGHT));               //5
        champNumeroTelephone = new JTextField(14);
        panelIdentite.add(champNumeroTelephone);                   //6

        panelIdentite.setBorder(BorderFactory.createTitledBorder(null,"Identité"));
        getPanelPrincipal().add(panelIdentite, BorderLayout.NORTH);
         //------------------------------------------
        //             détails
        //-------------------------------------------
        
        JPanel panelDetail=new JPanel();
        panelDetail.setLayout(new BorderLayout());
        
        //           PREFERENCE
        
        JPanel panelPreference=new JPanel();
        panelPreference.setLayout(new GridLayout(2,5));
       
        panelPreference.add(new JLabel("Vos disponibilités ",SwingConstants.RIGHT));   //1
        
        ButtonGroup groupeDispo = new ButtonGroup();
        
        for (DispoSortie d : DispoSortie.values()) {
            JRadioButton radio = new JRadioButton(d.toString());
            groupeDispo.add(radio);
            panelPreference.add(radio);                           //2-3-4
            radioButtonDisponibilite.put(d, radio);
        }
        
        //on met le week end en valeur par défaut
        for (Map.Entry<DispoSortie, JRadioButton> ligne: radioButtonDisponibilite.entrySet()) {
            if (ligne.getKey()==DispoSortie.WEEK_END) {
                ligne.getValue().setSelected(true);
            }
        }
        
        panelPreference.add(new JLabel(""));                          //5
        
        panelPreference.add(new JLabel("Hobbies",SwingConstants.RIGHT));              //6

        for (Hobby h : Hobby.values()) {
            JCheckBox check = new JCheckBox(h.toString());
            panelPreference.add(check);                           //7-8-9-10
            checkBoxHobbies.put(h, check);
        }
        
        panelDetail.add(panelPreference,BorderLayout.NORTH);
        
         //           Commentaire
        
        JPanel panelCommentaire=new JPanel();
        panelCommentaire.setLayout(new BorderLayout());
        
        panelCommentaire.add(new JLabel("Commentaire",SwingConstants.CENTER),BorderLayout.NORTH);
        commentaire=new JTextArea(10,30);
        commentaire.setText("Ecrire vos commentaires ici");
        panelCommentaire.add(commentaire,BorderLayout.CENTER);
        
        panelDetail.setBorder(BorderFactory.createTitledBorder(null,"Détails"));
        panelDetail.add(panelCommentaire,BorderLayout.SOUTH);
        
        //  
        
        getPanelPrincipal().add(panelDetail, BorderLayout.CENTER);
        
          //------------------------------------------
        //             Boutons
        //-------------------------------------------
        
        JPanel panelBouton=new JPanel();
        panelBouton.setLayout(new GridLayout(1,4));
        panelBouton.add(new JLabel(""));               //1

        
        // Ajout d'un bouton dans la fenÃªtre (pour tester les mÃ©thodes qui rÃ©cupÃ¨rent les valeurs des composants de IhmContact)
        JButton enregistrer = new JButton("Enregistrer");
        panelBouton.add(enregistrer);                            //2
        
        panelBouton.add(new JLabel(""));                    //3
        
        
        JButton annuler = new JButton("Annuler");     //4
        panelBouton.add(annuler);  
        
        panelBouton.add(new JLabel(""));                    //5

        
        
        getPanelPrincipal().add(panelBouton, BorderLayout.SOUTH);
        
        

        
        //windows listener
        
        // Gestion des evenements (ici le clic) des boutons
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               resetUI();       
             }
            });
    
        
        
        enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setChanged();
        // Valuation des attributs du contact avec les valeurs des composants du formulaire
        // A complÃ©ter pour tous les attributs du contact  5.3    
               contact.setNom(getValChampNom());
               int jour=getValChampDateNaissJour();
               Mois mois = getValChampDateNaissMois();
               int annee=getValChampDateNaissAnnee();
               
               contact.setDateNaissance(jour,mois,annee);
              
               contact.setNumeroTelephone(getValChampNumeroTelephone());
               
               contact.setHobbies(getValChampHobby());
               
               contact.setDisponibilite(getValChampDispo());
               
               contact.setCommentaire(getValCommentaire());
               
               
               notifyObservers(contact);
               clearChanged();  
               resetUI();
               
               
             }
            });
        
    }

    /**
     * Affecte des valeurs aux composants du formulaire ... Ã  complÃ©ter
     */
    
    public void resetUI(){
        this.setValChampNom(" ");
        
        this.setValChampDateNaissJour(0);
        this.setValChampDateNaissMois(Mois.JANVIER);
        this.setValChampDateNaissAnnee(1990);
        this.setValChampNumeroTelephone(" ");
        this.setValCommentaire("Ecrire vos commentaires ici");
        
        for (Map.Entry<DispoSortie, JRadioButton> ligne: radioButtonDisponibilite.entrySet()) {
            if (ligne.getKey()==DispoSortie.WEEK_END) {
                ligne.getValue().setSelected(true);
            }
        }
        
        for(Map.Entry<Hobby,JCheckBox> ligne2: this.checkBoxHobbies.entrySet()){
            if (ligne2.getValue().isSelected()) { 
                ligne2.getValue().setSelected(false);
            }
        }
        
        
     
        
     
        
        
    }
    
    
    public void setValChampNom(String nom) {
        champNom.setText(nom);
    }
    
    public void setValCommentaire(String com) {
        commentaire.setText(com);
    }

    public void setValChampDateNaissJour(int champJour) {
        champDateNaissJour.setSelectedIndex(champJour);
    }

    public void setValChampDateNaissMois(Mois champMois) {
        champDateNaissMois.setSelectedItem(champMois);
    }

    public void setValChampDateNaissAnnee(int champAnnee) {
        champDateNaissAnnee.setSelectedItem(champAnnee);
    }

    public void setValChampNumeroTelephone(String champTelephone) {
        champNumeroTelephone.setText(champTelephone);
    }

    /**
     * Retourne les valeurs associÃ©es aux composants du formulaire ... Ã 
     * complÃ©ter
     */
    public String getValChampNom() {
        return champNom.getText();
    }

    public int getValChampDateNaissJour() {
        return champDateNaissJour.getSelectedIndex() + 1;
    }

    public Mois getValChampDateNaissMois() {
        int numMois = champDateNaissMois.getSelectedIndex();
        Mois mois = Mois.values()[numMois]; //on prends dans l'enumeration le mois numMois-1 (car janvier =0; fevrier =1, ...)
        return mois;
    }

    public int getValChampDateNaissAnnee() {
        int annee = 1900 + champDateNaissAnnee.getSelectedIndex();
        return annee;
    }

    public String getValChampNumeroTelephone() {
        return champNumeroTelephone.getText();
    }

    public DispoSortie getValChampDispo() {
        DispoSortie dispo=null;
        for (Map.Entry<DispoSortie, JRadioButton> ligne: radioButtonDisponibilite.entrySet()) {
            if (ligne.getValue().isSelected()) {
                dispo= ligne.getKey();
            }

        }
        return dispo;

    }
    
    public ArrayList<Hobby> getValChampHobby() {
        ArrayList<Hobby> hobbies=new ArrayList<Hobby>();
        for(Map.Entry<Hobby,JCheckBox> ligne: this.checkBoxHobbies.entrySet()){
            if (ligne.getValue().isSelected()) { 
                hobbies.add(ligne.getKey());
            }
        }
        return hobbies;
    }
    
    public String getValCommentaire(){
        return this.commentaire.getText();
    }
    
}
