package com.logilighter.helper;

import com.logitech.gaming.LogiLED;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyConverter {

    private static Map<String, Integer> jsonToLogiledMap = initJsonToLogiledMap();
    private static Map<Integer, Integer> javaToLogiledMap = initJavaToLogiledMap();
    private static Set<Integer> allKeys = initAllKeys();

    private static Map<String, Integer> initJsonToLogiledMap() {

        Map<String, Integer> map = new HashMap<>();

        map.put("ctrl", LogiLED.LEFT_CONTROL);
        map.put("alt", LogiLED.LEFT_ALT);
        map.put("shift", LogiLED.LEFT_SHIFT);

        map.put("a", LogiLED.A);
        map.put("b", LogiLED.B);
        map.put("c", LogiLED.C);
        map.put("d", LogiLED.D);
        map.put("e", LogiLED.E);
        map.put("f", LogiLED.F);
        map.put("g", LogiLED.G);
        map.put("h", LogiLED.H);
        map.put("i", LogiLED.I);
        map.put("j", LogiLED.J);
        map.put("k", LogiLED.K);
        map.put("l", LogiLED.L);
        map.put("m", LogiLED.M);
        map.put("n", LogiLED.N);
        map.put("o", LogiLED.O);
        map.put("p", LogiLED.P);
        map.put("q", LogiLED.Q);
        map.put("r", LogiLED.R);
        map.put("s", LogiLED.S);
        map.put("t", LogiLED.T);
        map.put("u", LogiLED.U);
        map.put("v", LogiLED.V);
        map.put("w", LogiLED.W);
        map.put("x", LogiLED.X);
        map.put("y", LogiLED.Y);
        map.put("z", LogiLED.Z);

        map.put("enter", LogiLED.ENTER);
        map.put("delete", LogiLED.KEYBOARD_DELETE);
        map.put("insert", LogiLED.INSERT);
        map.put("backspace", LogiLED.BACKSPACE);
        map.put("[", LogiLED.OPEN_BRACKET);
        map.put("]", LogiLED.CLOSE_BRACKET);

        return map;
    }

    private static Map<Integer, Integer> initJavaToLogiledMap() {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(GlobalKeyEvent.VK_CONTROL, LogiLED.LEFT_CONTROL);
        map.put(GlobalKeyEvent.VK_LCONTROL, LogiLED.LEFT_CONTROL);
        map.put(GlobalKeyEvent.VK_RCONTROL, LogiLED.RIGHT_CONTROL);
        map.put(GlobalKeyEvent.VK_MENU, LogiLED.LEFT_ALT);
        map.put(GlobalKeyEvent.VK_LMENU, LogiLED.LEFT_ALT);
        map.put(GlobalKeyEvent.VK_RMENU, LogiLED.RIGHT_ALT);
        map.put(GlobalKeyEvent.VK_SHIFT, LogiLED.LEFT_SHIFT);
        map.put(GlobalKeyEvent.VK_LSHIFT, LogiLED.LEFT_SHIFT);
        map.put(GlobalKeyEvent.VK_RSHIFT, LogiLED.RIGHT_SHIFT);

        map.put(GlobalKeyEvent.VK_A, LogiLED.A);
        map.put(GlobalKeyEvent.VK_B, LogiLED.B);
        map.put(GlobalKeyEvent.VK_C, LogiLED.C);
        map.put(GlobalKeyEvent.VK_D, LogiLED.D);
        map.put(GlobalKeyEvent.VK_E, LogiLED.E);
        map.put(GlobalKeyEvent.VK_F, LogiLED.F);
        map.put(GlobalKeyEvent.VK_G, LogiLED.G);
        map.put(GlobalKeyEvent.VK_H, LogiLED.H);
        map.put(GlobalKeyEvent.VK_I, LogiLED.I);
        map.put(GlobalKeyEvent.VK_J, LogiLED.J);
        map.put(GlobalKeyEvent.VK_K, LogiLED.K);
        map.put(GlobalKeyEvent.VK_L, LogiLED.L);
        map.put(GlobalKeyEvent.VK_M, LogiLED.M);
        map.put(GlobalKeyEvent.VK_N, LogiLED.N);
        map.put(GlobalKeyEvent.VK_O, LogiLED.O);
        map.put(GlobalKeyEvent.VK_P, LogiLED.P);
        map.put(GlobalKeyEvent.VK_Q, LogiLED.Q);
        map.put(GlobalKeyEvent.VK_R, LogiLED.R);
        map.put(GlobalKeyEvent.VK_S, LogiLED.S);
        map.put(GlobalKeyEvent.VK_T, LogiLED.T);
        map.put(GlobalKeyEvent.VK_U, LogiLED.U);
        map.put(GlobalKeyEvent.VK_V, LogiLED.V);
        map.put(GlobalKeyEvent.VK_W, LogiLED.W);
        map.put(GlobalKeyEvent.VK_X, LogiLED.X);
        map.put(GlobalKeyEvent.VK_Y, LogiLED.Y);
        map.put(GlobalKeyEvent.VK_Z, LogiLED.Z);

        return map;
    }

    private static Set<Integer> initAllKeys() {

        Set<Integer> keys = new HashSet<>();

        keys.add(LogiLED.ESC);
        keys.add(LogiLED.F1);
        keys.add(LogiLED.F2);
        keys.add(LogiLED.F3);
        keys.add(LogiLED.F4);
        keys.add(LogiLED.F5);
        keys.add(LogiLED.F6);
        keys.add(LogiLED.F7);
        keys.add(LogiLED.F8);
        keys.add(LogiLED.F9);
        keys.add(LogiLED.F10);
        keys.add(LogiLED.F11);
        keys.add(LogiLED.F12);
        keys.add(LogiLED.PRINT_SCREEN);
        keys.add(LogiLED.PAUSE_BREAK);
        keys.add(LogiLED.TILDE);
        keys.add(LogiLED.ONE);
        keys.add(LogiLED.TWO);
        keys.add(LogiLED.THREE);
        keys.add(LogiLED.FOUR);
        keys.add(LogiLED.FIVE);
        keys.add(LogiLED.SIX);
        keys.add(LogiLED.SEVEN);
        keys.add(LogiLED.EIGHT);
        keys.add(LogiLED.NINE);
        keys.add(LogiLED.ZERO);
        keys.add(LogiLED.MINUS);
        keys.add(LogiLED.EQUALS);
        keys.add(LogiLED.BACKSPACE);
        keys.add(LogiLED.INSERT);
        keys.add(LogiLED.HOME);
        keys.add(LogiLED.PAGE_UP);
        keys.add(LogiLED.NUM_SLASH);
        keys.add(LogiLED.NUM_ASTERISK);
        keys.add(LogiLED.NUM_MINUS);
        keys.add(LogiLED.TAB);
        keys.add(LogiLED.Q);
        keys.add(LogiLED.W);
        keys.add(LogiLED.E);
        keys.add(LogiLED.R);
        keys.add(LogiLED.T);
        keys.add(LogiLED.Y);
        keys.add(LogiLED.U);
        keys.add(LogiLED.I);
        keys.add(LogiLED.O);
        keys.add(LogiLED.P);
        keys.add(LogiLED.OPEN_BRACKET);
        keys.add(LogiLED.CLOSE_BRACKET);
        keys.add(LogiLED.BACKSLASH);
        keys.add(LogiLED.KEYBOARD_DELETE);
        keys.add(LogiLED.END);
        keys.add(LogiLED.PAGE_DOWN);
        keys.add(LogiLED.NUM_SEVEN);
        keys.add(LogiLED.NUM_EIGHT);
        keys.add(LogiLED.NUM_NINE);
        keys.add(LogiLED.NUM_PLUS);
        keys.add(LogiLED.A);
        keys.add(LogiLED.S);
        keys.add(LogiLED.D);
        keys.add(LogiLED.F);
        keys.add(LogiLED.G);
        keys.add(LogiLED.H);
        keys.add(LogiLED.J);
        keys.add(LogiLED.K);
        keys.add(LogiLED.L);
        keys.add(LogiLED.SEMICOLON);
        keys.add(LogiLED.APOSTROPHE);
        keys.add(LogiLED.ENTER);
        keys.add(LogiLED.NUM_FOUR);
        keys.add(LogiLED.NUM_FIVE);
        keys.add(LogiLED.NUM_SIX);
        keys.add(LogiLED.LEFT_SHIFT);
        keys.add(LogiLED.Z);
        keys.add(LogiLED.X);
        keys.add(LogiLED.C);
        keys.add(LogiLED.V);
        keys.add(LogiLED.B);
        keys.add(LogiLED.N);
        keys.add(LogiLED.M);
        keys.add(LogiLED.COMMA);
        keys.add(LogiLED.PERIOD);
        keys.add(LogiLED.FORWARD_SLASH);
        keys.add(LogiLED.RIGHT_SHIFT);
        keys.add(LogiLED.ARROW_UP);
        keys.add(LogiLED.NUM_ONE);
        keys.add(LogiLED.NUM_TWO);
        keys.add(LogiLED.NUM_THREE);
        keys.add(LogiLED.NUM_ENTER);
        keys.add(LogiLED.LEFT_CONTROL);
        keys.add(LogiLED.LEFT_WINDOWS);
        keys.add(LogiLED.LEFT_ALT);
        keys.add(LogiLED.SPACE);
        keys.add(LogiLED.RIGHT_ALT);
        keys.add(LogiLED.RIGHT_WINDOWS);
        keys.add(LogiLED.APPLICATION_SELECT);
        keys.add(LogiLED.RIGHT_CONTROL);
        keys.add(LogiLED.ARROW_LEFT);
        keys.add(LogiLED.ARROW_DOWN);
        keys.add(LogiLED.ARROW_RIGHT);
        keys.add(LogiLED.NUM_ZERO);
        keys.add(LogiLED.NUM_PERIOD);
        keys.add(LogiLED.G_1);
        keys.add(LogiLED.G_2);
        keys.add(LogiLED.G_3);
        keys.add(LogiLED.G_4);
        keys.add(LogiLED.G_5);
        keys.add(LogiLED.G_6);
        keys.add(LogiLED.G_7);
        keys.add(LogiLED.G_8);
        keys.add(LogiLED.G_9);
        keys.add(LogiLED.G_LOGO);
        keys.add(LogiLED.G_BADGE);
        keys.add(LogiLED.CAPS_LOCK);
        keys.add(LogiLED.SCROLL_LOCK);

        return keys;
    }

    public static Integer convertKeyFromJsonToLogiled(String keyName) {
        return jsonToLogiledMap.get(keyName.toLowerCase());
    }

    public static Integer convertKeyFromJavaToLogiled(Integer keyCode) {
        return javaToLogiledMap.get(keyCode);
    }

    public static Set<Integer> getAllKeys() {
        return allKeys;
    }
}
