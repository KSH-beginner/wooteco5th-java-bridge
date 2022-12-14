package bridge.controller;

import bridge.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private int tryNumber;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        tryNumber = 1;
    }

    public void play() {
        outputView.printGameStartMessage();
        bridgeGame.generateBridge(inputBridgeSize());
        moveStep();
        gameSuccessOrFailureStep();
    }

    private void moveStep() {
        while (!bridgeGame.isGameSuccess() && !bridgeGame.isGameFailure()) {
            bridgeGame.move(inputMovingCommand());
            outputView.printMap(bridgeGame.getCurrentPlayerBridgeShape());
        }
    }

    private void gameSuccessOrFailureStep() {
        if (bridgeGame.isGameSuccess()) {
            gameResultStep(GameStatus.SUCCESS);
        }
        if (bridgeGame.isGameFailure()) {
            String retryOrEndCommand = inputRetryOrEndCommand();
            retryOrEndStep(retryOrEndCommand);
        }
    }

    private void retryOrEndStep(String retryOrEndCommand) {
        if (retryOrEndCommand.equals("R")) {
            gameRetryStep();
            gameSuccessOrFailureStep();
        }
        if (retryOrEndCommand.equals("Q")) {
            gameResultStep(GameStatus.FAILURE);
        }
    }

    private String inputRetryOrEndCommand() {
        outputView.printReadRetryOrEndCommandMessage();
        String retryOrEndCommand = inputView.readRetryOrEndCommand();
        return retryOrEndCommand;
    }

    private void gameResultStep(GameStatus gameStatus) {
        outputView.printResult(bridgeGame.getCurrentPlayerBridgeShape(), gameStatus, tryNumber);
    }

    private void gameRetryStep() {
        tryNumber++;
        bridgeGame.retry();
        moveStep();
    }



    private String inputMovingCommand() {
        outputView.printReadMovingCommandMessage();
        return inputView.readMovingCommand();
    }

    private int inputBridgeSize() {
        outputView.printReadBridgeSizeMessage();
        return inputView.readBridgeSize();
    }


}
