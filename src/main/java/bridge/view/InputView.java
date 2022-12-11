package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMovingCommand() {
        String movingCommand = Console.readLine();
        return movingCommand;
    }

    public String readRetryOrEndCommand() {
        String retryOrEndCommand = Console.readLine();
        return retryOrEndCommand;
    }
}