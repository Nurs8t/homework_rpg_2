package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {

    private List<String> items;
    private int gold;
    private int xp;

    public IceLootTable() {
        this.items = new ArrayList<>(List.of("Ice Gem", "Frost Scale", "Frozen Core"));
        this.gold = 400;
        this.xp = 1000;
    }

    public IceLootTable(int gold, List<String> items, int xp) {
        this.items = new ArrayList<>(items);
        this.gold = gold;
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
        return new IceLootTable(gold, new ArrayList<>(items), xp);
    }
}
