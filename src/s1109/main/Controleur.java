/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1109.main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import s1109.Contact;
import s1109.Hobby;
import static s1109.SerialisationDonnees.loadDB;
import static s1109.SerialisationDonnees.updateDB;
import s1109.ihm.IhmContact;
import s1109.ihm.ListeContacts;



/**
 *
 * @author 
 */
public class Controleur implements Observer {
    private IhmAppli ihmappli;
    private HashSet<Contact> liste_contacts;

    
    public Controleur(){
        if(!loadDB(this)){
            liste_contacts=new HashSet<Contact>();
        };
        afficheContact();
        
        
        ihmappli=new IhmAppli();
        ihmappli.getWindow().addWindowListener(new WindowAdapter(){
           @Override
            public void windowClosed(WindowEvent e){
                enregistrer();
                System.exit(0);
              
            }
        });
        
        
    }
    
 
    @Override
    public void update(Observable o, Object arg){
        Class classe=o.getClass();
        if(classe==IhmContact.class){
            Contact contact=(Contact) arg;
            liste_contacts.add(contact);
            System.out.println("Update class !");
            afficheContact();
        }
    }
    
 
    public void afficheContact(){
        for(Contact c  : liste_contacts){
                System.out.println(c.getNom());
            }
    }
    
   
    
    public boolean enregistrer(){
        boolean bol =updateDB(this);
        return bol;
    }
    
    public HashSet<Contact> getContacts(){
        return this.liste_contacts;
    }
    
    public void setContacts(HashSet <Contact> contacts){
        this.liste_contacts=contacts;
    }
    
    public IhmAppli getIhmAppli(){
        return this.ihmappli;
    }
    
    
   
    
   
    
    
    /* public Contact getContacts(){
        
        
    }*/
  
    
 }

