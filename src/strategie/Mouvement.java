package strategie;

/**
 * Classe définissant un mouvement.
 * Mathématiquement, un mouvement peut être vu comme un vecteur.
 * 
 * @author Baptiste Vannesson
 */
public class Mouvement {

    /**
     * Translation sur l'axe des abscisses.
     */
    private int x;
    /**
     * Translation sur l'axe des ordonnées.
     */
    private int y;
   
    /**
     * Constructeur par défaut d'un mouvement.
     * Par défaut, aucune translation n'est effectuée.
     */
    public Mouvement() {
        this(0, 0);
    }
    
    /**
     * Constructeur prenant en paramètres les translations à effectuer sur les deux axes.
     * 
     * @param x Translation sur l'axe des abscisses.
     * @param y Translation sur l'axe des ordonnées.
     */
    public Mouvement(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Accesseur pour récupérer la translation sur l'axe des abscisses.
     * 
     * @return Translation sur l'axe des abscisses.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Mutateur pour changer la translation sur l'axe des abscisses.
     * 
     * @param x Nouvelle translation sur l'axe des abscisses.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Accesseur pour récupérer la translation sur l'axe des ordonnées.
     * 
     * @return Translation sur l'axe des ordonnées.
     */
    public int getY() {
        return y;
    }
    
    /**
     * Mutateur pour changer la translation sur l'axe des ordonnées.
     * 
     * @param y Nouvelle translation sur l'axe des ordonnées.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Fonction utile pour afficher « l'état » d'un mouvement en console.
     * On veut en fait savoir quel est le vecteur utilisé pour le déplacement, sous la forme (x, y).
     * 
     * @return Chaîne de caractères contenant la translation demandée sur chacun des axes du plan. 
     */
    public String toString() {
        String str = "(" + x + ", " + y + ")";
        str += "\n-------------------------------------------------------------";
        return str;
    }
    
}
