package com.gildedrose.qualite;

import java.util.function.Function;

public class ReglesQualite {

    public static Function<Integer, Integer> degradationJournaliereNormale() {
        return qualite -> qualite - 1;
    }
    
    public static Function<Integer, Integer> degradationJournaliere2x() {
        return qualite -> qualite - 2;
    }
    
    
    public static int vitesseDegradationJournaliere1x() {
        return 1;
    }
    
    public static Function<Integer, Integer> vitesseDegradationJournaliere2x() {
        return vitesse -> vitesse * 2;
    }
    
    public static Function<Integer, Integer> qualiteJamaisNegative() {
        return qualite -> {
            if (qualite < 0) {
                return 0;
            }
            return qualite;
        };
    }
    
    public static Function<Integer, Integer> qualiteMaximale() {
        return qualite -> {
            if (qualite > 50) {
                return 50;
            }
            return qualite;
        };
    }
    
    public static Function<Integer, Integer> qualiteConstante() {
        return qualite -> qualite;
    }
    
    public static Function<Integer, Integer> ameliorationQualite1x() {
        return qualite -> qualite + 1;
    }
    
    public static Function<Integer, Integer> ameliorationQualite2x() {
        return qualite -> qualite + 2;
    }

    public static Function<Integer, Integer> ameliorationQualite3x() {
        return qualite -> qualite + 3;
    }
    
    public static Function<Integer, Integer> qualiteNulle() {
        return qualite -> 0;
    }

}
