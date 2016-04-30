package test;

import contexte.EntiteMobile;
import contexte.Monde;
import contexte.Point;
import strategie.ComportementAleatoire;
import strategie.ComportementCombine;
import strategie.ComportementCyclique;
import strategie.Mouvement;
import strategie.ToutDroit;

/**
 * Classe permettant d'effectuer quelques tests.
 * 
 * @author Baptiste Vannesson
 */
public class Main {

    public static void main(String[] args) {
        
        // Création du monde
        Monde monde = new Monde();
        
        // Création de quelques comportements
        ToutDroit toutDroit = new ToutDroit(ToutDroit.BAS, 1);
        ComportementAleatoire aleatoire = new ComportementAleatoire(30);
        ComportementCombine combine = new ComportementCombine(new ToutDroit(), new ToutDroit(ToutDroit.HAUT, 5));
        ComportementCyclique cyclique = new ComportementCyclique();
        ComportementCyclique cycliqueInverse;
        
        // Création de quelques mouvements pour le motif du comportement cyclique
        Mouvement mouvement1 = new Mouvement(-1, 0);
        Mouvement mouvement2 = new Mouvement(1, 0);
        Mouvement mouvement3 = new Mouvement(2, 4);
        Mouvement[] mouvements = {mouvement1, mouvement2, mouvement3};
        
        // Ajout de mouvements pour le motif du comportement cyclique
        for (Mouvement mouvement : mouvements) {
            cyclique.addMouvement(mouvement);
        }
        
        // Inversion du motif
        cycliqueInverse = cyclique.creeComportementInverse();
        
        // Création de quelques entités mobiles
        EntiteMobile em1 = new Point("point1", 0, 0, toutDroit);
        EntiteMobile em2 = new Point("point2" , 1, 3, aleatoire);
        EntiteMobile em3 = new Point("point3", -7, -1, combine);
        EntiteMobile em4 = new Point("point4", -10, 10, cyclique);
        EntiteMobile em5 = new Point("point5", -10, 10, cycliqueInverse);
        EntiteMobile[] ems = {em1, em2, em3, em4, em5};
        
        // Ajout des entités mobiles au monde
        for (EntiteMobile em : ems) {
            monde.addEntiteMobile(em);
        }
        
        // Affichage des entités mobiles en console, avant tout déplacement
        System.out.println(monde.toString());
        
        // Déplacement de toutes les entités mobiles du monde en 20 itérations
        monde.lanceIterations(20);
        
        // Affichage du résultat en console (position de chaque entité mobile après 20 itérations)
        System.out.println(monde.toString());
        
    }

}
