package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 20})
    void 다리_생성_기능(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridgeShapes = bridgeMaker.makeBridge(bridgeSize);

        assertThat(generatedBridgeShapes.size()).isEqualTo(bridgeSize);
    }
}