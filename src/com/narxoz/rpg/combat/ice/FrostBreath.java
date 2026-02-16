package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;
import com.narxoz.rpg.combat.fire.FlameBreath;

public class FrostBreath implements Ability {

    @Override
    public String getName() {
        return "Frost Breath";
    }

    @Override
    public int getDamage() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "Breathes ice air";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }


    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}
