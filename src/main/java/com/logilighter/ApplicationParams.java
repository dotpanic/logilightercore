package com.logilighter;

import com.logilighter.model.ShortcutsConfiguration;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class ApplicationParams  {

    private boolean run = true;

    private boolean numLock;
    private boolean capsLock;
    private boolean scrollLock;

    private ShortcutsConfiguration shortcutsConfiguration;

    private Set<Integer> pressedKeys = new HashSet<>();

    private ApplicationParams() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        numLock = toolkit.getLockingKeyState(KeyEvent.VK_NUM_LOCK);
        capsLock = toolkit.getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        scrollLock = toolkit.getLockingKeyState(KeyEvent.VK_SCROLL_LOCK);
    }

    private static ApplicationParams INSTANCE = new ApplicationParams();

    public static ApplicationParams getInstance() {
        return INSTANCE;
    }

    public boolean isRun() {
        return run;
    }

    public ApplicationParams setRun(boolean run) {
        this.run = run;
        return this;
    }

    public boolean isNumLock() {
        return numLock;
    }

    public ApplicationParams setNumLock(boolean numLock) {
        this.numLock = numLock;
        return this;
    }

    public boolean isCapsLock() {
        return capsLock;
    }

    public ApplicationParams setCapsLock(boolean capsLock) {
        this.capsLock = capsLock;
        return this;
    }

    public boolean isScrollLock() {
        return scrollLock;
    }

    public ApplicationParams setScrollLock(boolean scrollLock) {
        this.scrollLock = scrollLock;
        return this;
    }

    public void keyPress(Integer key) {
        pressedKeys.add(key);
    }

    public void keyRelease(Integer key) {
        pressedKeys.remove(key);
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

    public ShortcutsConfiguration getShortcutsConfiguration() {
        return shortcutsConfiguration;
    }

    public ApplicationParams setShortcutsConfiguration(ShortcutsConfiguration shortcutsConfiguration) {
        this.shortcutsConfiguration = shortcutsConfiguration;
        return this;
    }
}
