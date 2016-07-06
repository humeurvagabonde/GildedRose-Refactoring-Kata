package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.Perissable;

public class PeremptionLineaire implements Perissable {

    @Override
    public int decompterJournalier(Item item) {
        return item.sellIn - 1;
    }

}
