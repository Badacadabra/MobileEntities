package strategie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe définissant un comportement cyclique.
 * Un comportement cyclique est un type particulier de comportement.
 * Le principe est de répéter indéfiniment un motif, c'est-à-dire une suite finie de mouvements.
 * Le motif est ici représenté par une ArrayList paramétrée.
 * 
 * @author Baptiste Vannesson
 */
public class ComportementCyclique implements Comportement {

    /**
     * Liste de mouvements à répéter.
     */
    private List<Mouvement> mouvements;
    /**
     * Indice du mouvement suivant dans la liste des mouvements.
     */
    private int indiceProchainMouvement;
   
    /**
     * Constructeur par défaut d'un comportement cyclique.
     * Par défaut, un comportement cyclique prend en paramètre une liste vide.
     * Or un comportement cyclique requiert au moins un mouvement pour fonctionner.
     * Heureusement, une méthode « addMouvement » permet justement d'ajouter un mouvement.
     * Il n'est donc pas nécessaire d'invoquer le constructeur prenant en paramètre une liste de mouvements.
     */
    public ComportementCyclique() {
        this(new ArrayList<Mouvement>());
    }
    
    /**
     * Constructeur d'un comportement cyclique prenant une liste de mouvements à répéter (autrement dit un motif) en paramètre.
     * Ce constructeur fait une recopie en profondeur de la liste de mouvements passée en paramètre.
     * On va donc au-delà du simple multiréférencement en créant une nouvelle instance et en copiant les valeurs d'une ArrayList à l'autre.
     * Mais naturellement, il faut qu'il y ait au moins un mouvement dans cette liste pour que la recopie ait un intérêt !
     * 
     * @param mouvements Liste de mouvements à répéter (motif).
     */
    public ComportementCyclique(List<Mouvement> mouvements) {
        if (mouvements.size() > 0) {
            // Recopie en profondeur
            this.mouvements = new ArrayList<Mouvement>();
            for (Mouvement mouvement : mouvements) {
                this.mouvements.add(mouvement);
            }
        } else {
            this.mouvements = mouvements;
        }
        indiceProchainMouvement = 0;
    }
    
    /**
     * Ajouter un nouveau mouvement à la liste des mouvements.
     * 
     * @param mouvement Mouvement à ajouter à la liste des mouvements.
     */
    public void addMouvement(Mouvement mouvement) {
        mouvements.add(mouvement);
    }
    
    /**
     * Inversion du motif.
     * La liste de mouvements est renversée (premier mouvement en dernier, dernier mouvement en premier, etc.).
     * Chaque mouvement de la liste est par ailleurs opposé. Exemple : (-1, 0) devient (1, 0).
     * Il s'agit ici d'une « factory method » qui retourne bien une instance de ComportementCyclique.
     * Dans cette méthode, on inverse en profondeur le motif courant en créant une ArrayList de nouveaux mouvements inverses.
     * On renverse ensuite l'ArrayList ainsi créée avec la méthode statique « reverse » de la classe « Collections ».
     * 
     * @return Motif inversé.
     */
    public ComportementCyclique creeComportementInverse() {
        List<Mouvement> mouvementsInverses = new ArrayList<Mouvement>();
        for (Mouvement mouvement : mouvements) {
            mouvementsInverses.add(new Mouvement(-mouvement.getX(), -mouvement.getY()));
        }
        Collections.reverse(mouvementsInverses);
        return new ComportementCyclique(mouvementsInverses);
    }
    
    /**
     * Méthode « stratégique ».
     * Il s'agit d'une redéfinition imposée par l'implémentation de l'interface Comportement.
     * Ici, il faut jouer avec l'index du prochain mouvement pour pouvoir répéter le motif.
     * En effet, à chaque itération du monde, un seul mouvement de la liste est renvoyé.
     * Par conséquent, si le « curseur » est positionné sur le dernier mouvement de la liste, il faut le réinitialiser pour repartir sur le premier mouvement à la prochaine itération.
     * À l'inverse, si le « curseur » n'est pas sur le dernier mouvement de la liste, on incrémente simplement le compteur pour aller au mouvement suivant à la prochaine itération.
     * 
     * @return Instance de Mouvement en fonction de la position du « curseur » dans la liste des mouvements à répéter.
     */
    @Override
    public Mouvement getProchainMouvement() { 
        Mouvement prochainMouvement = mouvements.get(indiceProchainMouvement);
        if (indiceProchainMouvement >= mouvements.size() - 1) {
            indiceProchainMouvement = 0;
        } else {
            indiceProchainMouvement++;
        }
        return prochainMouvement;
    }
    
}
