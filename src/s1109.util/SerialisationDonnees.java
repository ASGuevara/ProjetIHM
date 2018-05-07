/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1109;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import s1109.main.Controleur;

/**
 *
 * @author iut2
 */
public class SerialisationDonnees {
    
    // Fichier de sérialisation
	private static final String DB_FILE = "src/data/carnet.db";
    
    /**
     * Met à jour du fichier de sérialisation
     * @return 
     */
    public static boolean updateDB(Controleur c) {
       // System.out.println("Test update");
        return saveDB(c);
    }

    
   /**
    * Sauvegarde du fichier de sérialisation
    * @return 
    */
	
    private static boolean saveDB(Controleur c) {
        //System.out.println("Test saveDB");
        File file;
        boolean success = true;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;            
        
        file = new File(DB_FILE);
        try {
            System.out.println("Test save try");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(c.getContacts()); 
        }
        catch (Exception e) {
            System.out.println("SAVE" + e);
            success = false;
        }
        finally {
                if (oos != null) { 
                    try { oos.close(); }
                    catch(IOException e) {}
                }
                
                if (fos != null) { 
                    try { fos.close(); }
                    catch(IOException e) {}
                }
            
        }
        
        return success;
    }
    
    /**
     * Chargement des données à partir d'un fichier de sérialisation
     * @return 
     */
    public static boolean loadDB(Controleur c) {
        
        System.out.println("Test load");
        
        boolean success = true;
        File file = new File(DB_FILE);
        
        if (file.exists()) {
            System.out.println("Test load file exist");
            
            FileInputStream fis = null;
            ObjectInputStream ois = null;            

            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                c.setContacts( (HashSet <Contact>) ois.readObject());
               
            }             
            catch(Exception e) {
                System.out.println("LOAD" + e);
                success = false;
            }
            finally {
                if (ois != null) { 
                    try { ois.close(); }
                    catch(IOException e) {}
                }
                
                if (fis != null) { 
                    try { fis.close(); }
                    catch(IOException e) {}
                }
            }
        } else { success = false; }
        
        return success;
    }
     
}
