package strategie;

/**
 * Interface permettant de mettre en place une stratégie de comportement.
 * Cette interface est au cœur du design pattern « Strategy », en jouant la carte du polymorphisme et du liage dynamique.
 * 
 * @author Baptiste Vannesson
 */
public interface Comportement {

    /**
     * Méthode permettant de mettre en place le design Pattern « Strategy ».
     * Cette méthode sera redéfinie dans chacune des classes implémentant cette interface.
     * L'intérêt sera alors de pouvoir choisir, à l'exécution, la stratégie de comportement à adopter.
     */
    Mouvement getProchainMouvement();
    
}
