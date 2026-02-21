package com.narxoz.rpg;


import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("FIRE FACTORY:");
        fireFactory.createAbilities().forEach(a ->
                System.out.println(" Ability: " + a.getName()));
        System.out.println(" Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println(" AI: " + fireFactory.createAIBehavior());

        System.out.println("ICE FACTORY:");
        iceFactory.createAbilities().forEach(a ->
                System.out.println(" Ability: " + a.getName()));
        System.out.println(" Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println(" AI: " + iceFactory.createAIBehavior());

        System.out.println("SHADOW FACTORY:");
        shadowFactory.createAbilities().forEach(a ->
                System.out.println(" Ability: " + a.getName()));
        System.out.println(" Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println(" AI: " + shadowFactory.createAIBehavior());

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy dragon = new BossEnemyBuilder()
                .setName("Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .build();

        dragon.displayInfo();
        System.out.println();

        Enemy Goblin = new BasicEnemyBuilder()
                .setName("Goblin")
                .setHealth(300)
                .setDamage(30)
                .setDefense(10)
                .setSpeed(20)
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .build();

        Goblin.displayInfo();
        System.out.println();


        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegister register = new EnemyRegister();

        register.registerTemplate("dragon", dragon);
        register.registerTemplate("goblin", Goblin);

        Enemy eliteDragon = register.createFromTemplate("dragon");
        Enemy eliteGoblin = register.createFromTemplate("goblin");

        System.out.println("Cloned enemies created.\n");

        System.out.println("Original Dragon abilities count: " + dragon.getAbilities().size());

        eliteDragon.getAbilities().add(shadowFactory.createAbilities().get(0)
        );

        System.out.println("Modified clone abilities count: " + eliteDragon.getAbilities().size());

        System.out.println("Original Dragon abilities count AFTER clone modification: " + dragon.getAbilities().size());

        System.out.println();


        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        EnemyComponentFactory shadowFactory2 = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Shadow Demon Lord")
                .setHealth(40000)
                .setDamage(450)
                .setDefense(180)
                .setSpeed(40)
                .setAbilities(shadowFactory2.createAbilities())
                .setLootTable(shadowFactory2.createLootTable())
                .setAI(shadowFactory2.createAIBehavior())
                .build();

        register.registerTemplate("demon", demonLord);


        Enemy greaterDemon = register.createFromTemplate("demon");
        Enemy mythicDemon = register.createFromTemplate("demon");

        greaterDemon.displayInfo();
        System.out.println();
        mythicDemon.displayInfo();
        System.out.println();


        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();

        System.out.println("Abstract Factory: Created themed component families (Fire, Ice, Shadow)");
        System.out.println("Builder: Constructed complex enemies step-by-step using fluent interface");
        System.out.println("Factory Method: build() method created Enemy objects via polymorphism");
        System.out.println("Prototype: Cloned enemy templates using deep copy to create variants");
        System.out.println("All four creational patterns worked together in a unified RPG enemy system.");



        System.out.println("\n=== Demo Complete ===");
    }
}
