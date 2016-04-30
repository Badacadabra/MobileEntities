package contexte;

import strategie.Comportement;

/**
 * Classe définissant un point.
 * Un point est une entité mobile capable de se déplacer dans un monde à deux dimensions. 
 * 
 * @author Baptiste Vannesson
 */
public class Point extends EntiteMobile {
    
    /**
     * Constructeur par défaut d'un point.
     * On appelle ici le constructeur par défaut de la classe mère (EntiteMobile).
     * Par défaut, un point s'appelle donc « EM », se place à l'origine (0, 0), et possède un comportement ToutDroit vers la droite.
     */
    public Point() {
        super();
    }
    
    /**
     * Constructeur prenant le nom du point, ses coordonnées, et son comportement en paramètres.
     * On appelle ici le constructeur de la classe parente (EntiteMobile).
     * 
     * @param nom Nom du point.
     * @param x Position du point sur l'axe des abscisses.
     * @param y Position du point sur l'axe des ordonnées.
     * @param comportement Comportement de déplacement du point.
     */
    public Point(String nom, int x, int y, Comportement comportement) {
        super(nom, x, y, comportement);
    }
    
}
