/*
 * Module 1109 : module IHM : Carnet de contacts
 */
package s1109.main;

import static s1109.SerialisationDonnees.loadDB;
import static s1109.SerialisationDonnees.updateDB;

/**
 *
 * @author IUT2
 */

public class Main implements Runnable {
    private Controleur c;
    
    public void run() {
       c = new Controleur ();
       c.getIhmAppli().getIhmContact().addObserver(c);
       


     }
    public static void main(String[] args) {        
        java.awt.EventQueue.invokeLater(new Main());  
    }   
      
}

