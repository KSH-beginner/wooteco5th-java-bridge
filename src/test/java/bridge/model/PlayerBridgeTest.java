package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerBridgeTest {

    @Test
    void 현재_플레이어의_다리_모양_가져오는_기능() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addSuccessShape("U");
        playerBridge.addFailureShape("D");
        Map<String, List<String>> currentShapes = playerBridge.getCurrentShapes();
        List<String> currentUpShape = currentShapes.get("upShape");
        List<String> currentDownShape = currentShapes.get("downShape");

        assertThat(currentUpShape).isEqualTo(List.of("O", " "));
        assertThat(currentDownShape).isEqualTo(List.of(" ", "X"));
    }

    @Test
    void 플레이어_다리_모양_초기화_기능() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addSuccessShape("U");
        playerBridge.addFailureShape("D");
        playerBridge.initializeShape();
        Map<String, List<String>> currentShapes = playerBridge.getCurrentShapes();
        List<String> currentUpShape = currentShapes.get("upShape");
        List<String> currentDownShape = currentShapes.get("downShape");

        assertThat(currentUpShape).isEmpty();
        assertThat(currentDownShape).isEmpty();
    }
}