package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GeneratedBridgeTest {

    @Test
    void 이동할_칸을_건널_수_있는지_판단하는_기능() {
        GeneratedBridge generatedBridge = new GeneratedBridge(List.of("U", "D", "U"));
        String upStep = "U";
        String downStep = "D";

        assertThat(generatedBridge.canMove(0, upStep)).isTrue();
        assertThat(generatedBridge.canMove(1, upStep)).isFalse();
        assertThat(generatedBridge.canMove(2, downStep)).isFalse();
    }
}