package com.logilighter;

import com.logilighter.helper.ShortcutsLoader;
import com.logitech.gaming.LogiLED;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class.getName());

    public static void main(String[] args) {

        try {
            // Log4j config
            BasicConfigurator.configure();

            // Load shortcuts
            ClassLoader classLoader = Application.class.getClassLoader();
            File shortcutsFile = new File(classLoader.getResource("shortcuts/photoshop.json").getFile());
            ApplicationParams.getInstance().setShortcutsConfiguration(ShortcutsLoader.loadShortcuts(shortcutsFile));

            LogiLED.LogiLedInit();
            LogiLED.LogiLedSetTargetDevice(LogiLED.LOGI_DEVICETYPE_PERKEY_RGB);
            LogiLED.LogiLedSaveCurrentLighting();

            GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
            logger.info("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");
            for (Map.Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
                logger.info("{}: {}", keyboard.getKey(), keyboard.getValue());
            }

            // Init lights
            KeyEventHandler keyEventHandler = new KeyEventHandler();
            keyEventHandler.lightNumLock();
            keyEventHandler.lightCapsLock();
            keyEventHandler.lightScrollLock();

            keyboardHook.addKeyListener(new KeyListener(keyEventHandler));

            try {
                while (ApplicationParams.getInstance().isRun()) {
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) { /* nothing to do here */ } finally {
                keyboardHook.shutdownHook();
            }

        } finally {
            LogiLED.LogiLedRestoreLighting();
            LogiLED.LogiLedShutdown();
        }
    }
}
