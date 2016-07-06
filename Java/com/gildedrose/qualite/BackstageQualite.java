package com.gildedrose.qualite;

import com.gildedrose.Item;
import com.gildedrose.Qualitatif;

public class BackstageQualite implements Qualitatif {

    @Override
    public int majQualite(Item item) {
        // manque des regles!
        int qualite = item.quality;
        if (item.sellIn < 0) {
            qualite = 0;
        } else if (item.sellIn <= 5) {
            qualite += 3;
        } else if (item.sellIn <= 10) {
            qualite += 2;
        }
        return qualite;
    }

}
