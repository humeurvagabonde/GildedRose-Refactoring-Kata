package com.gildedrose.quality;

import com.gildedrose.Item;

public abstract class AbstractQualitatif implements Qualitatif {

    @Override
    public int majQualite(Item item) {
        return seuillerQualite(calculerQualiteJournaliere(item));
    }
    
    public abstract int calculerQualiteJournaliere(Item item);

    private int seuillerQualite(int qualite) {
        if (qualite > 50) {
            return 50;
        }
        return qualite;
    }
}
