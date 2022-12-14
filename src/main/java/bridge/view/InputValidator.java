package bridge.view;

import bridge.ErrorConstants;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String DIGIT_REGEX = "[0-9]+";

    public void validateBridgeSize(String bridgeSize) {
        if (isBridgeSizeNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "다리 길이는 숫자여야합니다.");
        }
    }

    private boolean isBridgeSizeNotDigit(String bridgeSize) {
        return !Pattern.matches(DIGIT_REGEX, bridgeSize);
    }
}
