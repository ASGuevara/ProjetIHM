/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1109.main;

import java.awt.BorderLayout;

import s1109.ihm.IhmContact;
import s1109.ihm.ListeContacts;

import javax.swing.JFrame;
import s1109.Contact;
import s1109.Hobby;
import s1109.Mois;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
/**
 *
 * @author guevlisteContactsarag
 */
public class IhmAppli extends Observable {

    private IhmContact ihmContact;
    private ListeContacts listeContacts;
    public JFrame window ;

    // Instanciation de la fenÃªtre qui reÃ§oit le formulaire IhmContact
    public IhmAppli() {
        //creation d'un contact intermediaire

        window = new JFrame("Test IHM Contact");
        window.setLayout(new BorderLayout());
        window.setSize (700, 500);
        ihmContact  = new IhmContact();
        listeContacts  = new ListeContacts();

        // Ajout de l'IHM formulaire dans la fenÃªtre 
      
        window.add(ihmContact.getPanelPrincipal(), BorderLayout.CENTER);
        window.add(listeContacts.getPanelPrincipal(), BorderLayout.WEST);


           // window.addWindowListener(l);



        window.setVisible (true);   
        window.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);//windows listener pour quand on ferme la fenetre ça fait saveDB(this);
        
        
        
    }
    
    public IhmContact getIhmContact(){
        return this.ihmContact;
    }
    
    public ListeContacts getListContact(){
        return this.listeContacts;
    }
    
    public Frame getWindow(){
        return window;
    }
      
        
    }
