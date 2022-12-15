package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Map<String, String> printShapeMap = printBridge.generate(playerBridgeUpShape, playerBridgeDownShape);

        assertThat(printShapeMap.get("upShape")).isEqualTo("[ O |   | X ]");
        assertThat(printShapeMap.get("downShape")).isEqualTo("[   | O |   ]");
    }
}