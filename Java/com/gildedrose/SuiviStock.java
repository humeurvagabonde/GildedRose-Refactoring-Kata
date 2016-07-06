package com.gildedrose;

import com.gildedrose.perissable.Perissable;
import com.gildedrose.qualite.Qualitatif;

public class SuiviStock {
    
    private Perissable reglePerissable;
    private Qualitatif regleQualite;
    
    public SuiviStock(Perissable reglePerissable, Qualitatif regleQualite) {
        this.reglePerissable = reglePerissable;
        this.regleQualite = regleQualite;
    }
    
    public void updateQuality(Item item) {
        
    }
}
