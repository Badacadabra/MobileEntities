package strategie;

/**
 * Classe définissant un comportement rectiligne.
 * Un comportement rectiligne est un type particulier de comportement.
 * Le principe est de se déplacer tout droit, dans une direction prédéfinie (haut, droite, bas, gauche).
 * On utilisera naturellement des constantes pour représenter les quatre directions de déplacement.
 * Le type simple « byte » sur un octet est ici largement suffisant (inutile de prendre un int !).
 * On sait pertinemment qu'il n'y aura pas plus de quatre valeurs.
 * Ces dernières sont d'ailleurs définies dans le sens des aiguilles d'une montre.
 * 
 * @author Baptiste Vannesson
 */
public class ToutDroit implements Comportement {

    /**
     * Constante symbolisant un déplacement vers le haut.
     */
    public static final byte HAUT = 0;
    /**
     * Constante symbolisant un déplacement vers la droite.
     */
    public static final byte DROITE = 1;
    /**
     * Constante symbolisant un déplacement vers le bas.
     */
    public static final byte BAS = 2;
    /**
     * Constante symbolisant un déplacement vers la gauche.
     */
    public static final byte GAUCHE = 3;

    /**
     * Direction de déplacement.
     */
    private byte direction;
    /**
     * Vitesse de déplacement.
     */
    private int vitesse;
   
    /**
     * Constructeur par défaut d'un comportement rectiligne.
     * Par défaut, on se déplace tout droit vers la droite avec une vitesse constante de 1 par itération.
     * Ce choix est discutable, mais si on prend comme référence un classique du jeu vidéo en 2D, « Mario », il est manifeste que le personnage est plus susceptible d'aller tout droit vers la droite...
     */
    public ToutDroit() {
        this(DROITE, 1);
    }
    
    /**
     * Constructeur prenant en paramètre une direction et une vitesse de déplacement.
     * 
     * @param direction Direction de déplacement.
     * @param vitesse Vitesse de déplacement.
     */
    public ToutDroit(byte direction, int vitesse) {
        this.direction = direction;
        this.vitesse = vitesse;
    }
    
    /**
     * Méthode « stratégique ».
     * Il s'agit d'une redéfinition imposée par l'implémentation de l'interface Comportement.
     * Ici, la méthode s'articule autour d'un switch qui détermine quelle est la direction.
     * En fonction de la direction, on instancie la classe Mouvement avec le vecteur adéquat.
     * À noter que la vitesse de déplacement est bel et bien variable car paramétrable. 
     * 
     * @return Instance de Mouvement conditionnée par la direction et la vitesse de déplacement.
     */
    @Override
    public Mouvement getProchainMouvement() {
        Mouvement prochainMouvement = null;
        switch (direction) {
            case HAUT:
                prochainMouvement = new Mouvement(0, vitesse);
                break;
            case DROITE:
                prochainMouvement = new Mouvement(vitesse, 0);
                break;
            case BAS:
                prochainMouvement = new Mouvement(0, -vitesse);
                break;
            case GAUCHE:
                prochainMouvement = new Mouvement(-vitesse, 0);
                break;
        }
        return prochainMouvement;
    }

}
