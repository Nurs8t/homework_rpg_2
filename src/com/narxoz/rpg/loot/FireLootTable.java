package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;

public class FireLootTable implements LootTable{

    private List<String> items;
    private int gold;
    private int xp;

    public FireLootTable(){
        this.gold=300;
        this.xp=1000;
        this.items=List.of("Fire Gem", "Dragon Scale", "Flame Rune");
    }

    public FireLootTable(int gold, List<String> items, int xp) {
        this.gold = gold;
        this.items = items;
        this.xp = xp;
    }

    @Override
    public List<String> getItems() {
        return items;
    }
    @Override
    public int getGoldDrop() {
        return gold;
    }
    @Override
    public int getExperienceDrop() {
        return xp;
    }
    @Override
    public String getLootInfo() {
        return "Items: " + items + ", Gold: " + gold + ", XP: " + xp;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(gold, new ArrayList<>(items), xp);
    }

}
