package cn.xpbootcamp.gilded_rose;
class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                    item.quality--;
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sell_in < 11) {
                            item.quality++;
                        }

                        if (item.sell_in < 6) {
                            item.quality++;
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sell_in--;
            }

            if (item.sell_in < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                            item.quality--;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }
}
