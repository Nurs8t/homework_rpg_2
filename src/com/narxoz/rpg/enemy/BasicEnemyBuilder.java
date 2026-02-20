package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private Integer health;
    private int damage;
    private int defense;
    private int speed;

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override
    public BasicEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BasicEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public BasicEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public BasicEnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public BasicEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BasicEnemyBuilder setAbilities(List<Ability> abilities) {
        if (abilities == null) {
            this.abilities = new ArrayList<>();
        } else {
            this.abilities = new ArrayList<>(abilities);
        }
        return this;
    }

    @Override
    public BasicEnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }
    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Enemy name is required.");
        }
        if (health == null || health <= 0) {
            throw new IllegalStateException("Health must be positive.");
        }
        if (lootTable == null) {
            throw new IllegalStateException("LootTable must be set.");
        }

        List<Ability> copiedAbilities = new ArrayList<>(this.abilities);
        LootTable copiedLoot = lootTable.clone();

        return new BasicEnemy(
                name,
                health,
                damage,
                defense,
                speed,
                copiedAbilities,
                copiedLoot
        );
    }
}