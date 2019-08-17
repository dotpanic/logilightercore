package com.logilighter.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logilighter.model.Shortcut;
import com.logilighter.model.ShortcutsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class ShortcutsLoader {

    private static Logger logger = LoggerFactory.getLogger(ShortcutsLoader.class.getName());

    private ShortcutsLoader() {
    }

    public static ShortcutsConfiguration loadShortcuts(File resourceFile) {

        ShortcutsConfiguration shortcutsConfiguration = new ShortcutsConfiguration();

        try {
            ObjectMapper responseMapper = new ObjectMapper();
            JsonNode root = responseMapper.readTree(Files.readAllBytes(resourceFile.toPath()));

            if (root.hasNonNull("application")) {
                shortcutsConfiguration.setApplicationName(root.path("application").asText());
            }

            if (root.hasNonNull("shortcuts")) {
                JsonNode jsonShortcuts = root.path("shortcuts");
                if (jsonShortcuts.isArray()) {
                    for (JsonNode jsonShortcut : jsonShortcuts) {
                        if (jsonShortcut.hasNonNull("name")
                        && jsonShortcut.hasNonNull("modifiers")
                        && jsonShortcut.hasNonNull("key")) {
                            JsonNode jsonModifiers = jsonShortcut.path("modifiers");
                            if (jsonModifiers.isArray()) {
                                Set<Integer> modifiers = new HashSet<>();
                                for (JsonNode jsonModifier : jsonModifiers) {
                                    modifiers.add(KeyConverter.convertKeyFromJsonToLogiled(jsonModifier.asText()));
                                }
                                shortcutsConfiguration.addShortcut(
                                        new Shortcut(
                                                jsonShortcut.path("name").asText(),
                                                modifiers,
                                                KeyConverter.convertKeyFromJsonToLogiled(jsonShortcut.path("key").asText()))
                                );
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            logger.error("I/O exception occurred", e);
        }

        return shortcutsConfiguration;
    }
}
