package bridge;

import bridge.constant.ErrorConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    @Test
    void 움직일_수_있는_칸의_번호를_받아서_움직일_수_있는_칸_이니셜_반환() {
        int downStepNumber = 0;
        int upStepNumber = 1;
        String downStepInitial = Step.setMovableStepInitial(downStepNumber);
        String upStepInitial = Step.setMovableStepInitial(upStepNumber);

        assertThat(downStepInitial).isEqualTo("D");
        assertThat(upStepInitial).isEqualTo("U");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 20, 200, 2000, 20000})
    void 움직일_수_있는_칸의_번호가_0_또는_1이_아니면_예외_발생(int movableStepNumber) {
        assertThatThrownBy(() -> Step.setMovableStepInitial(movableStepNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}