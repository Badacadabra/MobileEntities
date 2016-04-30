package strategie;

import java.util.Random;

/**
 * Classe définissant un comportement aléatoire.
 * Un comportement aléatoire est un type particulier de comportement.
 * Le principe est de générer, au hasard, de nouvelles valeurs de déplacement en x et en y.
 * On veut d'ailleurs éviter que x ait toujours la même valeur que y.
 * La méthode helper « randomInt » est donc appelée deux fois pour générer x et y indépendamment. 
 * 
 * @author Baptiste Vannesson
 */
public class ComportementAleatoire implements Comportement {

    /**
     * Valeur maximum utilisée pour borner la génération aléatoire.
     * Un nombre aléatoire est généré entre -valMax et +valMax.
     */
    private int valMax;

    /**
     * Constructeur par défaut d'un comportement aléatoire.
     * Par défaut, valMax est la plus grande valeur d'un entier signé sur un octet (byte), soit 127.
     * On ne prend pas ici la valeur maximum d'un entier signé sur quatre octets (int) qui compliquerait l'exercice inutilement.
     * D'ailleurs, faire appel à Integer.MAX_VALUE nous contraindrait à utiliser des long (sur 8 octets) pour stocker les valeurs de certaines coordonnées.
     */
    public ComportementAleatoire() {
        this(Byte.MAX_VALUE);
    }
    
    /**
     * Constructeur prenant une valeur maximum en paramètre.
     * 
     * @param valMax Valeur maximum bornant la génération aléatoire.
     */
    public ComportementAleatoire(int valMax) {
        this.valMax = valMax;
    }
    
    /**
     * Méthode utilitaire générant un nombre aléatoire entre deux bornes.
     * Elle est privée car elle n'est pas censée être utilisée depuis l'extérieur de la classe.
     * 
     * @param min Borne inférieure (-valMax).
     * @param max Borne supérieure (+valMax).
     * @return Nombre aléatoire.
     */
    private int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min; // + 1 pour inclure le maximum
    }
    
    /**
     * Méthode « stratégique ».
     * Il s'agit d'une redéfinition imposée par l'implémentation de l'interface Comportement.
     * Ici on se contente de renvoyer un mouvement avec un nouveau x et un nouveau y, choisis au hasard.
     * 
     * @return Instance de Mouvement avec un x et un y générés aléatoirement par « randomInt ».
     */
    @Override
    public Mouvement getProchainMouvement() {
        return new Mouvement(randomInt(-valMax, valMax), randomInt(-valMax, valMax));
    }
    
}
