package bridge.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DIGIT_REGEX = "[+-]?[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String MOVING_UP_COMMAND = "U";
    private static final String MOVING_DOWN_COMMAND = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String END_COMMAND = "Q";

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

    public void validateMovingCommand(String movingCommand) {
        if (isMovingCommandNotUAndNotD(movingCommand)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이동할 칸 커맨드는 U 또는 D여야합니다.");
        }
    }

    private boolean isMovingCommandNotUAndNotD(String movingCommand) {
        return !movingCommand.equals(MOVING_UP_COMMAND) && !movingCommand.equals(MOVING_DOWN_COMMAND);
    }

    public void validateRetryOrEndCommand(String retryOrEndCommand) {
        if (isRetryOrEndCommandNotRAndNotQ(retryOrEndCommand)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "게임 재시도/종료 커맨드는 R 또는 Q여야합니다.");
        }
    }

    private boolean isRetryOrEndCommandNotRAndNotQ(String retryOrEndCommand) {
        return !retryOrEndCommand.equals(RETRY_COMMAND) && !retryOrEndCommand.equals(END_COMMAND);
    }
}
