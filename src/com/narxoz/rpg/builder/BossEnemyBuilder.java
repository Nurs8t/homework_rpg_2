package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer,Integer> phases = new HashMap<>();
    private LootTable loot;
    private String ai;
    private boolean canFly;
    private boolean hasBreath;
    private int wingspan;

    public BossEnemyBuilder setName(String name){ this.name=name; return this; }
    public BossEnemyBuilder setHealth(int health){ this.health=health; return this; }
    public BossEnemyBuilder setDamage(int damage){ this.damage=damage; return this; }
    public BossEnemyBuilder setDefense(int defense){ this.defense=defense; return this; }
    public BossEnemyBuilder setSpeed(int speed){ this.speed=speed; return this; }
    public BossEnemyBuilder setElement(String element){ this.element=element; return this; }

    public BossEnemyBuilder addAbility(Ability a){
        abilities.add(a);
        return this;
    }

    public BossEnemyBuilder addPhase(int phase,int hp){
        phases.put(phase,hp);
        return this;
    }

    public BossEnemyBuilder setLootTable(LootTable loot){
        this.loot=loot;
        return this;
    }

    public BossEnemyBuilder setAI(String ai){
        this.ai=ai;
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly){
        this.canFly=canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreath){
        this.hasBreath=hasBreath;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan){
        this.wingspan=wingspan;
        return this;
    }

    public Enemy build(){
        if(name==null || loot==null)
            throw new IllegalStateException("Missing required fields");

        return new DragonBoss(
                name,health,damage,defense,speed,
                element,new ArrayList<>(abilities),
                new HashMap<>(phases),
                loot,ai,canFly,hasBreath,wingspan
        );
    }
}