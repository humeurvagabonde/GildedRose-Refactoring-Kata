package com.gildedrose.suivi;

import static com.gildedrose.qualite.ReglesQualite.ameliorationQualite2x;
import static com.gildedrose.qualite.ReglesQualite.ameliorationQualite3x;
import static com.gildedrose.qualite.ReglesQualite.ameliorationQualite1x;
import static com.gildedrose.qualite.ReglesQualite.degradationJournaliere2x;
import static com.gildedrose.qualite.ReglesQualite.degradationJournaliereNormale;
import static com.gildedrose.qualite.ReglesQualite.qualiteJamaisNegative;
import static com.gildedrose.qualite.ReglesQualite.qualiteMaximale;
import static com.gildedrose.qualite.ReglesQualite.qualiteNulle;

import java.util.function.Function;

import com.gildedrose.Item;
import com.gildedrose.Item.Type;
import com.gildedrose.qualite.ReglesQualite;
import com.gildedrose.sellin.ReglesDureeLimiteVente;

public class SuiviStock {

    public static Function<Item, Item> appliquerRegleDureeLimiteVenteJournaliere() {
        return item -> {
            Type type = Item.type(item);
            Function<Integer, Integer> regleDureLimiteVente;
            switch (type) {
            case SULFURAS:
                regleDureLimiteVente = ReglesDureeLimiteVente.dureeLimiteVenteConstante();
                break;
            default:
                regleDureLimiteVente = ReglesDureeLimiteVente.diminutionJournaliereNormale();
            }
            item.sellIn = regleDureLimiteVente.apply(item.sellIn);
            return item;
        };
    }
    
    public static Function<Item, Item> appliquerRegleQualiteJournaliere() {
        return item -> {
            Type type = Item.type(item);
            Function<Integer, Integer> regleQualite = degradationJournaliereNormale();
            switch (type) {
            case AGED_BRIE:
                regleQualite = ameliorationQualite1x();
                break;
            case SULFURAS:
                regleQualite = ReglesQualite.qualiteConstante();
                break;
            case BACKSTAGES:
                if (Item.dureeLimiteVenteExpiree(item)) {
                    regleQualite = qualiteNulle();
                } else if (item.sellIn <= 5) {
                    regleQualite = ameliorationQualite3x();
                } else if (item.sellIn <= 10) {
                    regleQualite = ameliorationQualite2x();
                } else {
                    regleQualite = ameliorationQualite1x();
                }
                break;
            case CONJURED:
                regleQualite = degradationJournaliere2x();
                break;
            default:
                if (Item.dureeLimiteVenteExpiree(item)) {
                    regleQualite = degradationJournaliere2x();
                }
                break;
            }
            
            // BUG cela ne sapplique pas a SULFURA
            regleQualite = regleQualite.andThen(qualiteJamaisNegative()).andThen(qualiteMaximale());
            item.quality = regleQualite.apply(item.quality);
            
            return item;
        };
    }
    
    
    /*case NORMAL:
                break;
            case AGED_BRIE:
                break;
            case SULFURAS:
                break;
            case BACKSTAGES:
                break;
            case CONJURED:
                break;
            }*/
    
}
