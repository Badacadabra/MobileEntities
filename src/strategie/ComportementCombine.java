package strategie;

/**
 * Classe définissant un comportement combiné.
 * Un comportement combiné est un type particulier de comportement.
 * Le principe est ici de combiner deux comportements en fusionnant les mouvements qu'ils impliquent.
 * Mathématiquement, ce comportement revient à faire une somme de vecteurs. 
 * 
 * @author Baptiste Vannesson
 */
public class ComportementCombine implements Comportement {

    /**
     * Premier comportement entrant dans la combinaison.
     */
    private Comportement comportement1;
    /**
     * Deuxième comportement entrant dans la combinaison.
     */
    private Comportement comportement2;

    /**
     * Constructeur par défaut d'un comportement combiné.
     * Par défaut, un comportement combiné prend deux mouvements « ToutDroit ».
     * Le premier mouvement « ToutDroit » est paramétré pour aller à droite, le second en haut.
     * La vitesse de déplacement est toujours de 1 par itération.
     * Il s'agit donc d'un déplacement purement en diagonale vers la droite et vers le haut : (1, 1).
     * Ce choix est discutable, mais si on prend comme référence un classique du jeu vidéo en 2D, « Mario », il est manifeste que le personnage est plus susceptible d'aller vers la droite et vers le haut (exemple : sauter un précipice...).
     */
    public ComportementCombine() {
        this(new ToutDroit(), new ToutDroit(ToutDroit.HAUT, 1));
    }
    
    /**
     * Constructeur prenant en paramètres les deux comportements à combiner.
     * 
     * @param comportement1 Premier comportement entrant dans la combinaison.
     * @param comportement2 Deuxième comportement entrant dans la combinaison.
     */
    public ComportementCombine(Comportement comportement1, Comportement comportement2) {
        this.comportement1 = comportement1;
        this.comportement2 = comportement2;
    }
    
    /**
     * Méthode « stratégique ».
     * Il s'agit d'une redéfinition imposée par l'implémentation de l'interface Comportement.
     * On doit ici faire la somme vectorielle des prochains mouvements des instances à combiner.
     * Pour ce faire, on calcule la somme des x (d'un côté) et des y (de l'autre) des mouvements en question.
     * On crée ensuite un nouveau mouvement à partir des coordonnées tout juste calculées.
     * 
     * @return Instance de Mouvement avec un x et un y issus de la somme (vectorielle) des mouvements relatifs aux comportements à combiner.
     */
    @Override
    public Mouvement getProchainMouvement() {
        int xCombine = comportement1.getProchainMouvement().getX() + comportement2.getProchainMouvement().getX();
        int yCombine = comportement1.getProchainMouvement().getY() + comportement2.getProchainMouvement().getY();
        return new Mouvement(xCombine, yCombine);
    }
    
}
