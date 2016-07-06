package com.gildedrose.qualite;

import com.gildedrose.Item;

public abstract class AbstractRegleQualite implements Qualitatif {

    // ya p.e qquchose a faire avec des Fonction anonyme (java 8) au niveau composition
    @Override
    public int majQualite(Item item) {
        return seuiller(calculerQualiteJournaliere(item));
    }
    
    public abstract int calculerQualiteJournaliere(Item item);
    
    private int seuiller(int qualite) {
        int qualiteSeuillee = qualite;
        if (qualite > 50) {
            qualiteSeuillee = 50;
        } else if (qualite < 0) {
            qualiteSeuillee = 0;
        }
        return qualiteSeuillee;
    }

}
