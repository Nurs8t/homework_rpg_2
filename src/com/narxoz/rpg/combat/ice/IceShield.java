package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.AbilityType;

public class IceShield implements Ability{

    @Override
    public String getName(){
        return "Ice Shield";
    }

    @Override
    public int getDamage(){
        return 0;
    }

    @Override
    public String getDescription(){
        return "Creates a shield of ice";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DEFENSIVE;
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }


}
