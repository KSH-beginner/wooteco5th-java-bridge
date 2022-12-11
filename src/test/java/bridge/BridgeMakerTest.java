package bridge;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void 다리_생성_기능(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(generatedBridge).isNotEmpty();
        assertThat(generatedBridge.size()).isEqualTo(bridgeSize);
    }
}