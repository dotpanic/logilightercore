import com.logilighter.helper.ShortcutsLoader;
import com.logilighter.model.Shortcut;
import com.logilighter.model.ShortcutsConfiguration;
import com.logitech.gaming.LogiLED;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ShortcutsLoaderTest {

    @Test
    void loadshortcuts() throws Exception {

        // Prepare
        ClassLoader classLoader = getClass().getClassLoader();
        File shortcutsFile = new File(classLoader.getResource("shortcuts/photoshop.json").getFile());

        // Execute
        ShortcutsConfiguration shortcutsConfiguration = ShortcutsLoader.loadShortcuts(shortcutsFile);

        // Verify
        assertThat(shortcutsConfiguration.getApplicationName(), equalTo("photoshop.exe"));
        assertThat(shortcutsConfiguration.getShortcuts().size(), equalTo(2));
        assertThat(shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_ALT)).size(), equalTo(1));
        assertThat(shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_CONTROL)).size(), equalTo(2));
        Set<Shortcut> candicates = shortcutsConfiguration.getCandicates(Collections.singleton(LogiLED.LEFT_ALT));
        assertThat(candicates.size(), equalTo(1));
        Shortcut shortcut = candicates.stream().findFirst().orElseThrow(() -> new Exception("Multiple candidates"));
        assertThat(shortcut.getKey(), equalTo(LogiLED.A));
        assertThat(shortcut.getModifiers().size(), equalTo(3));
    }
}