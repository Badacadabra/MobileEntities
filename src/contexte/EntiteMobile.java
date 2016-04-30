package contexte;

import strategie.Comportement;
import strategie.ToutDroit;

/**
 * Classe définissant une entité mobile.
 * Une entité mobile est capable de se déplacer dans un monde à deux dimensions.
 * Mais une entité mobile en soi n'est qu'un concept abstrait. Il peut en effet s'agir d'un point ou d'un personnage de jeu vidéo en 2D.
 * Cette classe est donc abstraite et servira de modèle pour des classes concrètes qui seront instanciables.
 * À noter que cette classe ne contient aucune méthode abstraite.
 * Elle s'apparente d'ailleurs à un JavaBean. La classe est publique, mais aucun attribut n'est public. Le principe d'encapsulation est donc respecté.
 * Les attributs sont accessibles en lecture et en écriture via des accesseurs (getters) et des mutateurs (setters).
 * La classe contient enfin un constructeur par défaut, sans paramètres.
 * 
 * @author Baptiste Vannesson
 */
public abstract class EntiteMobile {
    
    /**
     * Chaîne de caractères représentant le nom de l'entité mobile.
     */
    protected String nom;
    /**
     * Position de l'entité mobile sur l'axe des abscisses.
     */
    protected int x;
    /**
     * Position de l'entité mobile sur l'axe des ordonnées.
     */
    protected int y;
    /**
     * Comportement propre à l'entité mobile.
     */
    protected Comportement comportement;
    
    /**
     * Constructeur par défaut d'une entité mobile.
     * On définit ici une entité mobile qui s'appelle « EM » et qui se positionne à l'origine (0, 0).
     * Par défaut, on suppose qu'une entité mobile se déplace tout droit vers la droite si aucun comportement n'est renseigné.
     * Ce choix est discutable, mais si on prend comme référence un classique du jeu vidéo en 2D, « Mario », il est manifeste que le personnage est plus susceptible d'aller tout droit vers la droite...
     */
    public EntiteMobile() {
        this("EM", 0, 0, new ToutDroit());
    }
    
    /**
     * Constructeur prenant le nom de l'entité mobile, ses coordonnées, et son comportement en paramètres.
     * 
     * @param nom Nom de l'entité mobile.
     * @param x Position de l'entité mobile sur l'axe des abscisses.
     * @param y Position de l'entité mobile sur l'axe des ordonnées.
     * @param comportement Comportement de déplacement de l'entité mobile.
     */
    public EntiteMobile(String nom, int x, int y, Comportement comportement) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.comportement = comportement;
    }
    
    /**
     * Accesseur pour récupérer le nom de l'entité mobile.
     * 
     * @return Nom de l'entité mobile.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Mutateur pour changer le nom de l'entité mobile.
     * 
     * @param nom Nouveau nom de l'entité mobile.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Accesseur pour récupérer la position de l'entité mobile sur l'axe des abscisses.
     * 
     * @return Position de l'entité mobile sur l'axe des abscisses.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Mutateur pour changer la position de l'entité mobile sur l'axe des abscisses.
     * 
     * @param x Nouvelle position de l'entité mobile sur l'axe des abscisses.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Accesseur pour récupérer la position de l'entité mobile sur l'axe des ordonnées.
     * 
     * @return Position de l'entité mobile sur l'axe des ordonnées.
     */
    public int getY() {
        return y;
    }
    
    /**
     * Mutateur pour changer la position de l'entité mobile sur l'axe des ordonnées.
     * 
     * @param y Nouvelle position de l'entité mobile sur l'axe des ordonnées.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Accesseur pour récupérer le comportement de l'entité mobile.
     * 
     * @return Comportement de l'entité mobile.
     */
    public Comportement getComportement() {
        return comportement;
    }

    /**
     * Mutateur pour changer le comportement de l'entité mobile.
     * 
     * @param comportement Nouveau comportement affecté à l'entité mobile.
     */
    public void setComportement(Comportement comportement) {
        this.comportement = comportement;
    }
    
    /**
     * Accesseur pour récupérer le nom du comportement de l'entité mobile. Utile pour un affichage en console...
     * On utilise ici la réflexivité pour des raisons pratiques.
     * Il ne serait pas raisonnable d'ajouter un attribut nom et l'accesseur qui va avec à chacune des classes « stratégiques ».
     * 
     * @return Nom du comportement de l'entité mobile.
     */
    public String getNomComportement() {
        return comportement.getClass().getSimpleName();
    }

    /**
     * Fonction utile pour afficher « l'état » d'une entité mobile en console.
     * Par « état », on entend un compte rendu sur l'entité mobile contenant son nom, ses coordonnées et le nom de son comportement.
     * 
     * @return Chaîne de caractères contenant le nom, les coordonnées, et le nom du comportement de l'entité mobile. 
     */
    public String toString() {
        return "Position de « " + nom + " » : (" + x + ", " + y + ") --> " + getNomComportement();
    }
    
}
