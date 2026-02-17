package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class Vanish implements Ability {
    @Override
    public String getName() {
        return "Vanish";
    }
    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Disappear the shadow";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DEFENSIVE;
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}
