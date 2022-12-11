package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "A", "가", "a1"})
    void 입력한_다리_길이가_숫자가_아니면_예외_처리(String bridgeSize) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 숫자여야합니다.");
    }
}