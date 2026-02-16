package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FireShield implements Ability {

    @Override
    public String getName() {
        return "Fire Shield";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Creates a protective fire barrier that reduces incoming damage.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DEFENSIVE;
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}
