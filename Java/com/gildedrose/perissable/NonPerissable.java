package com.gildedrose.perissable;

import com.gildedrose.Item;

public class NonPerissable implements Perissable {

    @Override
    public int decompterJournalier(Item item) {
        return item.sellIn;
    }

}
