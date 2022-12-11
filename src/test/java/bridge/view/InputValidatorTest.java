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

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1", "21", "100"})
    void 입력한_다리_길이가_3_이상_20_이하가_아니면_예외_처리(String bridgeSize) {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3 이상 20 이하여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "a", "1", "u", "d"})
    void 입력한_이동할_칸_커맨드가_U_또는_D가_아니면_예외_처리(String movingCommand) {
        assertThatThrownBy(() -> inputValidator.validateMovingCommand(movingCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸 커맨드는 U 또는 D여야합니다.");
    }
}