package com.gildedrose;

public class Item {

    public static enum Type {
        NORMAL(""),
        AGED_BRIE("Aged Brie"),
        SULFURAS("Sulfuras"),
        BACKSTAGES("Backstage passes"),
        CONJURED("Conjured");
        
        private String prefix;
        Type(String prefix) {
            this.prefix = prefix;
        }
        
        public String prefix() {
            return prefix;
        }
    }
    
    public static Type type(Item item) {
        if (item.name.startsWith(Type.AGED_BRIE.prefix())) {
            return Type.AGED_BRIE;
        }
        
        if (item.name.startsWith(Type.SULFURAS.prefix())) {
            return Type.SULFURAS;
        }
        
        if (item.name.startsWith(Type.BACKSTAGES.prefix())) {
            return Type.BACKSTAGES;
        }
        
        if (item.name.startsWith(Type.CONJURED.prefix())) {
            return Type.CONJURED;
        }
        
        return Type.NORMAL;
    }
    
    public static boolean dureeLimiteVenteExpiree(Item item) {
        return item.sellIn < 0;
    }
    
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
