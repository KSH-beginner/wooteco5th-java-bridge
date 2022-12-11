package bridge.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DIGIT_REGEX = "[+-]?[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public void validateBridgeSize(String bridgeSize) {
        if (isBridgeSizeNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리 길이는 숫자여야합니다.");
        }
        if (isBridgeSizeUnderThreeOrOverTwenty(bridgeSize)) {
            throw  new IllegalArgumentException(ERROR_PREFIX + "다리 길이는 3 이상 20 이하여야합니다.");
        }
    }

    private boolean isBridgeSizeNotDigit(String bridgeSize) {
        return !Pattern.matches(DIGIT_REGEX, bridgeSize);
    }

    private boolean isBridgeSizeUnderThreeOrOverTwenty(String bridgeSize) {
        int convertedBridgeSize = Integer.parseInt(bridgeSize);
        return convertedBridgeSize < MIN_BRIDGE_SIZE || convertedBridgeSize > MAX_BRIDGE_SIZE;
    }
}
