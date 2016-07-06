package com.gildedrose.qualite;

import com.gildedrose.Item;

public class QualiteConstante implements Qualitatif {

    @Override
    public int majQualite(Item item) {
        return item.quality;
    }

}
