/*
 * Module 1109 : Classe Contact
 * Cette classe représente les contacts d'un carnet d'adresse
 */
package s1109;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author IUT2
 */

/**
 * 
 * @class Contact
 * Fiche d'un contact du carnet d'adresse
 */
public class Contact implements java.io.Serializable {
    // Attributs définissant un contact
    private String nom; // Nom du contact
    private int dateJour; // Jour de la date de naissance du contact
    private Mois dateMois; // Mois de la date de naissance du contact
    private int dateAnnee; // Année de la date de naissance du contact
    private String numeroTelephone; // Numéro de téléphone du contact
    private DispoSortie disponibilite; // Disponibilité préférée du contact
    private ArrayList<Hobby> hobbies; // Hobbies du contact
    private String commentaire; // un commentaire 

    
    /**
     * Constructeur vide
     */
    public Contact() {
        // On affecte des valeurs par défaut aux attributs
        this.nom = "Nouveau contact";
        this.dateJour = 1;
        this.dateMois = Mois.JANVIER;
        this.dateAnnee = 1970;        
        this.numeroTelephone = "";
        this.disponibilite = DispoSortie.SOIR;
        this.hobbies = new ArrayList<Hobby>();
        this.commentaire = "";
    }
    
    /**
     * Constructeur avec paramètres
     * @param nom nom à affecter au contact
     * @param jour jour de naissance à affecter au contact
     * @param mois mois de naissance à affecter au contact
     * @param annee année de naissance à affecter au contact
     * @param telephone n° de téléphone à affecter au contact
     * @param dispo disponibilité pour les sorties à affecter au contact
     * @param hobbies ensemble de hobbies à affecter au contact
     * @param comment un commentaire à affecter au contact
     * 
     */
    public Contact(String nom, int jour, Mois mois, int annee, String telephone, 
            DispoSortie dispo, ArrayList<Hobby> hobbies,String comment) {
        this.nom = nom;
        this.dateJour = jour;
        this.dateMois = mois;
        this.dateAnnee = annee;        
        this.numeroTelephone = telephone;
        this.disponibilite = dispo;
        this.hobbies = hobbies;
        this.commentaire = comment; 
    }
    
    /**
     * Retourne le nom du contact
     * @return 
     */
    public String getNom() { 
        return this.nom;
    }

    /**
     * Affecte le nom du contact
     * @param nom chaîne contenant le nom du contact
     * @return retourne vrai si l'affectation a pu se faire (nom non null) et false sinon
     */
    public boolean setNom(String nom) {
        if (nom != null) { 
            this.nom = nom;
            return true;
        }
        return false ;
    }

    
    /**
     * Retourne le jour de la date de naissance du contact
     * @return int
     */
    public int  getDateNaissanceJour()  { 
        return this.dateJour; 
    }
    /**
     * Retourne le mois de la date de naissance du contact
     * @return Mois
     */
    public Mois getDateNaissanceMois()  { 
        return this.dateMois; 
    }
    /**
     * Retourne l'annee de la date de naissance du contact
     * @return int
     */
    public int  getDateNaissanceAnnee() { 
        return this.dateAnnee; 
    }
    /**
     * Retourne la date de naissance du contact (concaténation des éléments
     * @return String
     */
    public String getDateNaissance() { 
        return this.dateJour + " " + this.dateMois + " " + this.dateAnnee; 
    }
    
    /**
     * Affecte la date de naissance du contact
     * @param jour : jour de la date de naissance
     * @param mois : mois de la date de naissance (non null)
     * @param annee : année de la date de naissance
     * @return true si les affectations ont pu être faites (mois non null) et false sinon
     */
    public boolean setDateNaissance(int jour, Mois mois, int annee) {        
        if (mois != null ) { 
            this.dateAnnee = annee;
            this.dateMois = mois;
            this.dateJour = jour;
            return true;
        }
        else return false ;
    }
    
    /**
     * Retourne le numéro de téléphone du contact
     * @return String
     */
    public String getNumeroTelephone() { 
       return this.numeroTelephone;
    }

    /**
     * Affecte le numéro de téléphone
     * @param numeroTelephone : une chaîne contenant le numéro de téléphone (non null)
     * @return true si l'affectation a pu être faite, false sinon
     */
    public boolean setNumeroTelephone(String numeroTelephone) {       
        if (numeroTelephone != null) { 
            this.numeroTelephone = numeroTelephone;
            return true ;
        }
        else return false;
    }

 
    /**
     * Retourne la disponibilité pour des sorties
     * @return DispoSortie
     */
    public DispoSortie getDisponibilite() { 
       return this.disponibilite; 
    }

    /**
     * Affecte la disponibilité pour des sorties
     * @param disponibilite : une DispoSortie non null
     * @return true si l'affectation a pu être faite (disponibilite non null) et false sinon
     */
    public boolean setDisponibilite(DispoSortie disponibilite) {       
        if (disponibilite != null) { 
            this.disponibilite = disponibilite;
            return true ;
        }
        else return false;
    }

    /**
     * Retourne la liste des hobby
     * @return tableau contenant la liste des hobby
     */
    public ArrayList<Hobby> getHobbies() { 
        return this.hobbies; 
    }
    
    /**
     * Ajoute un Hobby dans la liste
     * @param hobby un hobby à ajouter à l'ensemble des hobbies du contact (non null, pas encore dans l'ensemble)
     * @return True si le hobby n'est pas encore dans la liste
     */
    public boolean addHobby(Hobby hobby) {
        if (hobby != null && !this.hobbies.contains(hobby)) {
            hobbies.add(hobby);
            return true ;
        }
        else return false;
    }

    /**
     * Affecte l'ensemble de Hobbies
     * @param hobbies l'ensemble des hobbies du contact (non null)
     */
    
    public boolean setHobbies(ArrayList<Hobby> hobbies) {
        if (hobbies != null) { 
            this.hobbies = hobbies;
            return true ;
        }
        else return false;
    }
    /**
     * Retire tous les hobbies de la liste
     */
    public void removeAllHobbies() {
        this.hobbies = new ArrayList<Hobby>();
    }
    
    /**
     * Retire un hobby de la liste
     * @param h un hobby
     * @return True si le hobby est dans la liste
     */

    public boolean removeHobby(Hobby h) {
        boolean res = false;
        if (h != null) {
           int index = hobbies.indexOf(h);
           
           if (index >= 0) {
               hobbies.remove(index);
               res = true;
           }
        }
        return res;        
    } 
    
    /**
     * Retourne le commentaire
     * @return String
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Affecte le commentaire au sujet du contact
     * @param commentaires chaine contenant le commentaire
     */
    
    public boolean setCommentaire(String commentaire) {
        this.commentaire = commentaire;
        return true;
    }

}
