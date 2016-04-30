package contexte;

import java.util.ArrayList;
import java.util.List;

import strategie.Mouvement;

/**
 * Classe définissant un monde à deux dimensions.
 * Mathématiquement, la représentation la plus simple d'un tel monde est le repère orthonormé avec une graduation de 1. 
 * Ce monde est composé d'entités mobiles qui se déplacent pas à pas, selon un certain comportement, via des itérations successives.
 * 
 * @author Baptiste Vannesson
 */
public class Monde {

    /**
     * Liste des entités mobiles appartenant au monde.
     */
    private List<EntiteMobile> entitesMobiles;
    
    /**
     * Constructeur par défaut du monde.
     * Par défaut, on initialise l'attribut « entitesMobiles » en tant qu'ArrayList paramétrée.
     * Cette ArrayList recevra des références vers des instances de la classe « EntiteMobile ».
     */
    public Monde() {
        this.entitesMobiles = new ArrayList<EntiteMobile>();
    }
    
    /**
     * Ajout d'une entité mobile au monde.
     * 
     * @param em L'entité mobile à ajouter au monde.
     */
    public void addEntiteMobile(EntiteMobile em) {
        entitesMobiles.add(em);
    }
    
    /**
     * Itérations successives sur les différentes entités mobiles du monde.
     * À chaque itération, cette fonction déplace toutes les entités mobiles du monde selon un comportement qui est propre à chacune d'entre elles.
     * La boucle for englobante permet de répéter n fois le parcours de toutes les entités mobiles.
     * La boucle for imbriquée (« for each ») permet de parcourir toutes les entités mobiles du monde (c'est-à-dire l'ArrayList).
     * Naturellement, nous aurions pu utiliser un Iterator explicite en lieu et place du « for each ».
     * C'est néanmoins inutile dans le cas présent car nous n'avons aucun besoin de la méthode « remove ».
     * Avec un « for each », le compilateur sait se débrouiller lui-même avec un Iterator déguisé (méthodes « hasNext() » et « next() »).
     * 
     * @param n Nombre d'itérations.
     */
    public void lanceIterations(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("ITÉRATION n°" + i);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            for (EntiteMobile em : entitesMobiles) {
                Mouvement mouvement = em.getComportement().getProchainMouvement();
                // Affichage en console de la situation de l'entité mobile avant mouvement
                System.out.println(em.toString());
                // Affichage du mouvement à effectuer sur l'entité mobile
                System.out.print("Déplacement de « " + em.getNom() + " » : ");
                System.out.println(mouvement.toString());
                // Déplacement effectif de chaque entité mobile
                em.setX(em.getX() + mouvement.getX());
                em.setY(em.getY() + mouvement.getY());
            }
        }
    }
    
    /**
     * Fonction utile pour afficher « l'état » du monde en console.
     * Par « état » du monde, on entend un compte rendu précis pour chacune de ses entités mobiles.
     * Dans le compte rendu, on doit donc trouver les noms, les coordonnées, et les comportements de toutes les entités mobiles.
     * 
     * @return Chaîne de caractères contenant les noms, les coordonnées, et les comportements des entités mobiles du monde. 
     */
    public String toString() {
        String str = "\n=============================================================\n";
        str += "Positions des entités mobiles\n";
        str += "=============================================================\n";
        for (EntiteMobile em : entitesMobiles) {
            str += em.toString() + "\n";
        }
        return str;
    }
    
}
