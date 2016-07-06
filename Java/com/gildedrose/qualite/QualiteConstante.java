package com.gildedrose.qualite;

import com.gildedrose.Item;
import com.gildedrose.Qualitatif;

public class QualiteConstante implements Qualitatif {

    @Override
    public int majQualite(Item item) {
        return item.quality;
    }

}
