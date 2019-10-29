package com.logilighter.helper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.logilighter.model.Shortcut;
import com.logilighter.model.ShortcutsConfiguration;
import com.logitech.gaming.LogiLED;

class ShortcutsLoaderTest {

    @Test
    void test_loadShortcuts_success() throws Exception {

        // Prepare
        ClassLoader classLoader = getClass().getClassLoader();
        Path shortcutsFile = Paths.get(Objects.requireNonNull(classLoader.getResource("shortcuts/photoshop.json")).toURI());

        // Execute
        ShortcutsConfiguration shortcutsConfiguration = ShortcutsLoader.loadShortcuts(shortcutsFile);

        // Verify
        assertThat(shortcutsConfiguration.getApplicationName(), equalTo("photoshop.exe"));
        assertThat(shortcutsConfiguration.getShortcuts().size(), equalTo(2));
        assertThat(shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_ALT)).size(), equalTo(1));
        assertThat(shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_CONTROL)).size(), equalTo(1));
        Set<Shortcut> candidates = shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_ALT));
        assertThat(candidates.size(), equalTo(1));
        Shortcut shortcut = candidates.stream().findFirst().orElseThrow(() -> new Exception("Multiple candidates"));
        assertThat(shortcut.getKey(), equalTo(LogiLED.A));
        assertThat(shortcut.getModifiers().size(), equalTo(1));
    }

}
