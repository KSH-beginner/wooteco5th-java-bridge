package bridge.view;

import bridge.ErrorConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "", "aaa"})
    void 다리_길이가_숫자가_아니면_예외_처리(String bridgeSize) {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorConstants.ERROR_PREFIX + "다리 길이는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "-1", "21", "100"})
    void 다리_길이가_3이상_20이하가_아니면_예외_처리(String bridgeSize) {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorConstants.ERROR_PREFIX + "다리 길이는 3이상 20이하여야합니다.");
    }

}