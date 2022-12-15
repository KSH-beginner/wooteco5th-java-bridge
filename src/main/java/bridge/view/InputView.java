package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        inputValidator.validateMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readRetryOrEndCommand() {
        String retryOrEndCommand = Console.readLine();
        return retryOrEndCommand;
    }
}
