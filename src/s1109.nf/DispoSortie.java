/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package s1109;

/**
 *
 * @author IUT2
 */
public enum DispoSortie implements java.io.Serializable {
    SOIR("Le soir"),
    NUIT("La nuit"),
    WEEK_END("Le WE");
    
    private final String label;
    
    private DispoSortie(String label) { 
        this.label = label; 
    }
    
    public String getLabel() {
        return this.label;
    }
    
    /**
     * Surcharge toString de façon à utiliser directement le libellé de la DispoSortie
     * @return String : le libellé de la disponibilité
     */
    @Override
    public String toString() { 
        return this.getLabel(); 
    }
}