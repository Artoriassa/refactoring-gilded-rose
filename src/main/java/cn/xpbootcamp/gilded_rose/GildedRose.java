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
            if (isNotAgedBrie(item) && !isBackStagePasses(item)) {
                if (isNotSulfuras(item) && qualityGreaterThanZero(item)) {
                    item.quality--;
                }
            } else {
                if (qualityLessThanFifty(item)) {
                    item.quality++;
                    if (isBackStagePasses(item)) {
                        if (sellInLessEleven(item)) {
                            item.quality++;
                        }

                        if (sellInLessSix(item)) {
                            item.quality++;
                        }
                    }
                }
            }

            if (isNotSulfuras(item)) {
                item.sell_in--;
            }

            if (sellInLessThanZero(item)) {
                if (isNotAgedBrie(item)) {
                    if (!isBackStagePasses(item)) {
                        if (isNotSulfuras(item) && qualityGreaterThanZero(item)) {
                            item.quality--;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (qualityLessThanFifty(item)) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private static boolean sellInLessThanZero(Item item) {
        return item.sell_in < 0;
    }

    private static boolean sellInLessSix(Item item) {
        return item.sell_in < 6;
    }
    private static boolean sellInLessEleven(Item item) {
        return item.sell_in < 11;
    }
    private static boolean qualityLessThanFifty(Item item) {
        return item.quality < 50;
    }
    private static boolean qualityGreaterThanZero(Item item) {
        return item.quality > 0;
    }
    private static boolean isNotSulfuras(Item item) {
        return !item.name.equals(SULFURAS);
    }
    private static boolean isNotAgedBrie(Item item) {
        return !item.name.equals(AGED_BRIE);
    }
    private static boolean isBackStagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }
}
