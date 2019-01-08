package com.logilighter;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyListener extends GlobalKeyAdapter {

    private static Logger logger = LoggerFactory.getLogger(GlobalKeyAdapter.class.getName());

    private KeyEventHandler keyEventHandler;

    public KeyListener(KeyEventHandler keyEventHandler) {
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public void keyPressed(GlobalKeyEvent event) {
        logger.debug("Key pressed event: {}", event);
        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
            ApplicationParams.getInstance().setRun(false);
        }
        keyEventHandler.keyPressed(event);
    }

    @Override
    public void keyReleased(GlobalKeyEvent event) {
        logger.debug("Key released event: {}", event);
        keyEventHandler.keyReleased(event);
    }
}
