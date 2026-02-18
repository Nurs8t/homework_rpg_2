package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {

    private List<String> items;
    private int gold;
    private int xp;

    public ShadowLootTable() {
        this.items = new ArrayList<>(List.of("Shadow Gem", "Dark Essence", "Night Cloak"));
        this.gold = 450;
        this.xp = 1100;
    }

    public ShadowLootTable(List<String> items, int gold, int xp) {
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
        return new ShadowLootTable(this.items, this.gold, this.xp);
    }
}
