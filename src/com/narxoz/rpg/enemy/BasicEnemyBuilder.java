package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class BasicEnemyBuilder implements Enemy {

    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final List<Ability> abilities;
    private final LootTable lootTable;

    public BasicEnemyBuilder(String name, int health, int damage,
                             int defense, int speed,
                             List<Ability> abilities,
                             LootTable lootTable) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities;
        this.lootTable = lootTable;
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities =
                abilities.stream().map(Ability::clone).toList();

        return new BasicEnemyBuilder(
                name, health, damage, defense, speed,
                clonedAbilities,
                lootTable.clone()
        );
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("HP: " + health +
                " | DMG: " + damage +
                " | DEF: " + defense +
                " | SPD: " + speed);
        System.out.println("Abilities: " + abilities.size());
        System.out.println("Loot: " + lootTable.getLootInfo());
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}