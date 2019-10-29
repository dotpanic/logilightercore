import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.logilighter.helper.ShortcutsLoader;
import com.logilighter.model.Shortcut;
import com.logilighter.model.ShortcutsConfiguration;
import com.logitech.gaming.LogiLED;

class ShortcutsLoaderTest {

    @Test
    void loadshortcuts() throws Exception {

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
        Set<Shortcut> candicates = shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_ALT));
        assertThat(candicates.size(), equalTo(1));
        Shortcut shortcut = candicates.stream().findFirst().orElseThrow(() -> new Exception("Multiple candidates"));
        assertThat(shortcut.getKey(), equalTo(LogiLED.A));
        assertThat(shortcut.getModifiers().size(), equalTo(1));
    }
}
