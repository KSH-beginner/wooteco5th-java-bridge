package bridge.view;

import bridge.ErrorConstants;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String DIGIT_REGEX = "[-+]*[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String UP_MOVING = "U";
    private static final String DOWN_MOVING = "D";

    public void validateBridgeSize(String bridgeSize) {
        if (isBridgeSizeNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "다리 길이는 숫자여야합니다.");
        }
        if (isWrongBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "다리 길이는 3이상 20이하여야합니다.");
        }
    }

    private boolean isBridgeSizeNotDigit(String bridgeSize) {
        return !Pattern.matches(DIGIT_REGEX, bridgeSize);
    }

    private boolean isWrongBridgeSize(String bridgeSize) {
        int convertedBridgeSize = Integer.parseInt(bridgeSize);
        return convertedBridgeSize < MIN_BRIDGE_SIZE || convertedBridgeSize > MAX_BRIDGE_SIZE;
    }

    public void validateMoving(String moving) {
        if (isMovingNotUAndNotD(moving)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "이동할 칸은 U 또는 D여야합니다.");
        }
    }

    private boolean isMovingNotUAndNotD(String moving) {
        return !moving.equals(UP_MOVING) && !moving.equals(DOWN_MOVING);
    }
}
