package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}