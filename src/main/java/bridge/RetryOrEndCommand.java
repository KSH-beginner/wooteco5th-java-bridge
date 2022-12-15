package bridge;

import java.util.Arrays;

public enum RetryOrEndCommand {
    RETRY("R"),
    END("Q");

    private String command;

    RetryOrEndCommand(String command) {
        this.command = command;
    }

    public static RetryOrEndCommand getRetryOrEndCommand(String command) {
        return Arrays.stream(values())
                .filter(value -> value.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorConstants.ERROR_PREFIX + "게임 재시도/종료 커맨드는 R또는 Q여야합니다."));
    }
}
