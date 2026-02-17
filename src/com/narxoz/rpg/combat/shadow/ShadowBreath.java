package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class ShadowBreath implements Ability {

    @Override
    public String getName(){
        return "Shadow Breath";
    }

    @Override
    public int getDamage(){
        return 120;
    }
    @Override
    public String getDescription(){
        return "Strikes from the shadows";
    }
    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }

    @Override
    public Ability clone() {
        return new ShadowBreath();
    }
}
