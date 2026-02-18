package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.combat.shadow.Vanish;
import com.narxoz.rpg.combat.shadow.ShadowBreath;
import com.narxoz.rpg.loot.*;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        return List.of(new ShadowBreath(), new Vanish()
        );
    }

    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Tactical";
    }
}

