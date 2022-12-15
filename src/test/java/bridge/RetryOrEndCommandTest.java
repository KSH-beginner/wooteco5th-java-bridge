package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RetryOrEndCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1", "R1", "Q1"})
    void 게임_재시도_종료_커맨드가_R이나_Q가_아니면_예외_처리(String retryOrEndCommand) {
        assertThatThrownBy(() -> RetryOrEndCommand.getRetryOrEndCommand(retryOrEndCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorConstants.ERROR_PREFIX + "게임 재시도/종료 커맨드는 R또는 Q여야합니다.");
    }
}