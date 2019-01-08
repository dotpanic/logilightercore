package com.logilighter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShortcutsConfiguration {

    private String applicationName;
    private List<Shortcut> shortcuts;

    public ShortcutsConfiguration() {
        shortcuts = new ArrayList<>();
    }

    public Set<Shortcut> getCandicates(Set<Integer> currentModifiers) {
        return shortcuts.stream()
                .filter(shortcut -> shortcut.isCandicate(currentModifiers))
                .collect(Collectors.toSet());
    }

    public String getApplicationName() {
        return applicationName;
    }

    public ShortcutsConfiguration setApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    public ShortcutsConfiguration addShortcut(Shortcut shortcut) {
        shortcuts.add(shortcut);
        return this;
    }

    public List<Shortcut> getShortcuts() {
        return shortcuts;
    }
}
