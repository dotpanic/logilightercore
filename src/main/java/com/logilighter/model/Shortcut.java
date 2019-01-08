package com.logilighter.model;

import java.util.Set;

public class Shortcut {

    private String name;
    private Set<Integer> modifiers;
    private Integer key;

    public Shortcut(String name, Set<Integer> modifiers, Integer key) {
        this.name = name;
        this.modifiers = modifiers;
        this.key = key;
    }

    public boolean isCandicate(Set<Integer> currentModifiers) {
        return modifiers.equals(currentModifiers);
    }

    public Set<Integer> getModifiers() {
        return modifiers;
    }

    public Integer getKey() {
        return key;
    }
}
