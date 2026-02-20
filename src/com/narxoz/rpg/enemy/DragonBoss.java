package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DragonBoss implements Enemy {


    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;


    private List<Ability> abilities;


    private Map<Integer, Integer> phases;


    private LootTable lootTable;


    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;


    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element,
                      List<Ability> abilities,
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        // TODO: Display each ability's details
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey()
                    + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly
                + " | Breath Attack: " + hasBreathAttack
                + " | Wingspan: " + wingspan);
        // TODO: Display loot table
    }

    @Override
    public Enemy clone() {

        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            clonedAbilities.add(a.clone());
        }

        LootTable clonedLoot = (lootTable == null) ? null : lootTable.clone();

        int p1 = phases.getOrDefault(1, 0);
        int p2 = phases.getOrDefault(2, 0);
        int p3 = phases.getOrDefault(3, 0);

        return new DragonBoss(
                name,
                health,
                damage,
                defense,
                speed,
                element,
                clonedAbilities,
                p1, p2, p3,
                clonedLoot,
                aiBehavior,
                canFly,
                hasBreathAttack,
                wingspan
        );
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
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

}
