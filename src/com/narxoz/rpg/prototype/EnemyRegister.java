package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegister {

    private Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy enemy) {
        templates.put(key, enemy);
    }

    public Enemy createFromTemplate(String key) {

        Enemy template = templates.get(key);

        if (template == null) {
            throw new IllegalArgumentException("No template found for: " + key);
        }
        return template.clone();
    }

    public void listTemplates() {
        for (String key : templates.keySet()) {
            System.out.println("Template: " + key);
        }
    }
}