package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class FlameBreath implements Ability {

    @Override
    public String getName() {
        return "Flame Breath";
    }

    @Override
    public int getDamage() {
        return 120;
    }

    @Override
    public String getDescription() {
        return "Breathes fire in a cone, burning enemies.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }


    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}
