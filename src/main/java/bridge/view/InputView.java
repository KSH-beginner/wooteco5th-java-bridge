package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
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