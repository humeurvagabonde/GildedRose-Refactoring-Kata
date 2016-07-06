package com.gildedrose.sellin;

import java.util.function.Function;

public class ReglesDureeLimiteVente {

    public static Function<Integer, Integer> diminutionJournaliereNormale() {
        return duree -> duree -1;
    }
    
    public static Function<Integer, Integer> dureeLimiteVenteConstante() {
        return duree -> duree;
    }
    
}
