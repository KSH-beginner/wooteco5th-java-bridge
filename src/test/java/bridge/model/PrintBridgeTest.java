package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrintBridgeTest {

    @Test
    void 출력용_다리_생성_기능() {
        PrintBridge printBridge = new PrintBridge();
        List<String> playerBridgeUpShape = List.of("O", " ", "X");
        List<String> playerBridgeDownShape = List.of(" ", "O", " ");
        Map<String, List<String>> currentPlayerBridgeShape = new HashMap<>();
        currentPlayerBridgeShape.put("upShape", playerBridgeUpShape);
        currentPlayerBridgeShape.put("downShape", playerBridgeDownShape);
        Map<String, String> printShapeMap = printBridge.generate(currentPlayerBridgeShape);

        assertThat(printShapeMap.get("upShape")).isEqualTo("[ O |   | X ]");
        assertThat(printShapeMap.get("downShape")).isEqualTo("[   | O |   ]");
    }
}