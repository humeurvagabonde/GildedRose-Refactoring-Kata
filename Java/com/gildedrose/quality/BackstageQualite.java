package com.gildedrose.quality;

import com.gildedrose.Item;

public class BackstageQualite implements Qualitatif {

    @Override
    public int majQualite(Item item) {
        // TODO sortir les conditions
        int qualite = item.quality;
        if (item.sellIn < 0) {
            qualite = 0;
        } else if (item.sellIn <= 5) {
            qualite += 3; 
        } else if (item.sellIn <= 10) {
            qualite += 2;
        } else {
            qualite += 1;
        }
        return qualite;
    }

}
