package com.logilighter.events;

import com.logilighter.ApplicationParams;
import com.logilighter.helper.KeyConverter;
import com.logilighter.model.Shortcut;
import com.logitech.gaming.LogiLED;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class KeyEventHandler {

    private static Logger logger = LoggerFactory.getLogger(KeyEventHandler.class.getName());

    public void keyPressed(GlobalKeyEvent event) {
        switch (event.getVirtualKeyCode()) {
            case GlobalKeyEvent.VK_NUMLOCK:
                switchNumlock();
                break;
            case GlobalKeyEvent.VK_CAPITAL:
                switchCapsLock();
                break;
            case GlobalKeyEvent.VK_SCROLL:
                switchScrollLock();
                break;
            default:
                break;
        }
        ApplicationParams.getInstance().keyPress(KeyConverter.convertKeyFromJavaToLogiled(event.getVirtualKeyCode()));
        lightKeyboard();
    }

    public void keyReleased(GlobalKeyEvent event) {
        ApplicationParams.getInstance().keyRelease(KeyConverter.convertKeyFromJavaToLogiled(event.getVirtualKeyCode()));
        lightKeyboard();
    }

    public void lightKeyboard() {

        Set<Integer> pressedKeys = ApplicationParams.getInstance().getPressedKeys();
        Set<Integer> allKeys = KeyConverter.getAllKeys();

        if (pressedKeys.size() > 0) {

            // For all possible keys, either focus or unfocus keys
            Set<Shortcut> eligibleShortcuts = ApplicationParams.getInstance().getShortcutsConfiguration().getCandicates(
                    pressedKeys
            );

            Set<Integer> eligibleKeys = eligibleShortcuts.stream()
                    .map(Shortcut::getKey)
                    .collect(Collectors.toSet());

            Set<Integer> nonEligibleKeys = allKeys.stream()
                    .filter(k -> !eligibleKeys.contains(k))
                    .collect(Collectors.toSet());

            focusKeys(eligibleKeys);
            lightKeys(nonEligibleKeys);

        } else {
            lightKeys(allKeys);
        }
    }

    private void switchNumlock() {
        if (ApplicationParams.getInstance().isNumLock()) {
            ApplicationParams.getInstance().setNumLock(false);
        } else {
            ApplicationParams.getInstance().setNumLock(true);
        }
        lightNumLock();
    }

    private void switchCapsLock() {
        if (ApplicationParams.getInstance().isCapsLock()) {
            ApplicationParams.getInstance().setCapsLock(false);
        } else {
            ApplicationParams.getInstance().setCapsLock(true);
        }
        lightCapsLock();
    }

    private void switchScrollLock() {
        if (ApplicationParams.getInstance().isScrollLock()) {
            ApplicationParams.getInstance().setScrollLock(false);
        } else {
            ApplicationParams.getInstance().setScrollLock(true);
        }
        lightScrollLock();
    }

    public void lightCapsLock() {
        if (ApplicationParams.getInstance().isCapsLock()) {
            // saveKeysState(Collections.singleton(LogiLED.CAPS_LOCK));
            flashKeys(Collections.singleton(LogiLED.CAPS_LOCK));
        } else {
            // restoreKeysState(Collections.singleton(LogiLED.CAPS_LOCK));
            unflashKeys(Collections.singleton(LogiLED.CAPS_LOCK));
        }
    }

    public void lightScrollLock() {
        if (ApplicationParams.getInstance().isScrollLock()) {
            flashKeys(Collections.singleton(LogiLED.SCROLL_LOCK));
        } else {
            unflashKeys(Collections.singleton(LogiLED.SCROLL_LOCK));
        }
    }

    public void lightNumLock() {
        if (ApplicationParams.getInstance().isNumLock()) {
            focusKeys(Collections.singleton(LogiLED.NUM_LOCK));
        } else {
            lightKeys(Collections.singleton(LogiLED.NUM_LOCK));
        }
    }

    public void focusKeys(Set<Integer> keys) {
        logger.debug("Setting keys...");
        keys.forEach(key -> LogiLED.LogiLedSetLightingForKeyWithKeyName(key, 100, 0, 0));
        logger.debug("Keys lightning set!");
    }

    public void flashKeys(Set<Integer> keys) {
        logger.debug("Setting keys...");
        keys.forEach(key -> LogiLED.LogiLedFlashSingleKey(key, 100, 0, 0, LogiLED.LOGI_LED_DURATION_INFINITE, 200));
        logger.debug("Keys lightning set!");
    }

    public void unflashKeys(Set<Integer> keys) {
        logger.debug("Setting keys...");
        keys.forEach(LogiLED::LogiLedStopEffectsOnKey);
        logger.debug("Keys lightning set!");
    }

    public void lightKeys(Set<Integer> keys) {
        logger.debug("Setting keys...");
        keys.forEach(key -> LogiLED.LogiLedSetLightingForKeyWithKeyName(key, 100, 100, 100));
        logger.debug("Keys lightning set!");
    }

    public void darkKeys(Set<Integer> keys) {
        logger.debug("Setting keys...");
        keys.forEach(key -> LogiLED.LogiLedSetLightingForKeyWithKeyName(key, 0, 0, 0));
        logger.debug("Keys lightning set!");
    }

    public void saveKeysState(Set<Integer> keys) {
        logger.debug("Saving keys state...");
        keys.forEach(LogiLED::LogiLedSaveLightingForKey);
        logger.debug("Keys state saved!");
    }

    public void restoreKeysState(Set<Integer> keys) {
        logger.debug("Restoring keys state...");
        keys.forEach(LogiLED::LogiLedRestoreLightingForKey);
        logger.debug("Keys state restored!");
    }
}
