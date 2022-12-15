package bridge.controller;

import bridge.GameStatus;
import bridge.RetryOrEndCommand;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Map;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private GameStatus gameStatus;
    private RetryOrEndCommand retryOrEndCommand;

    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAILURE_MESSAGE = "실패";

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void play() {
        gameStatus = GameStatus.PLAY;
        printGameStartMessageStep();
        generateBridgeStep();
        moveStep();
    }

    private void printGameStartMessageStep() {
        outputView.printBridgeGameStartMessage();
    }

    private void generateBridgeStep() {
        bridgeGame.generateBridge(readBridgeSizeStep());
    }

    private int readBridgeSizeStep() {
        try {
            outputView.printReadBridgeSizeMessage();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readBridgeSizeStep();
        }
    }

    private void moveStep() {
        while (!gameStatus.equals(GameStatus.SUCCESS) && !gameStatus.equals(GameStatus.FAILURE)) {
            gameStatus = bridgeGame.move(readMovingStep());
            outputView.printMap(bridgeGame.generatePrintBridge());
        }
        checkSuccessOrFailureStep();
    }

    private String readMovingStep() {
        try {
            outputView.printReadMovingMessage();
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readMovingStep();
        }
    }

    private void checkSuccessOrFailureStep() {
        if (gameStatus.equals(GameStatus.FAILURE)) {
            readRetryOrEndCommandStep();
            retryOrEndStep();
        }
        if (gameStatus.equals(GameStatus.SUCCESS)) {
            printResultStep();
        }
    }

    private void readRetryOrEndCommandStep() {
        try {
            outputView.printReadRetryOrEndCommandMessage();
            retryOrEndCommand = inputView.readRetryOrEndCommand();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            readRetryOrEndCommandStep();
        }
    }

    private void retryOrEndStep() {
        if (retryOrEndCommand.equals(RetryOrEndCommand.RETRY)) {
            bridgeGame.retry();
            gameStatus = GameStatus.RETRY;
            moveStep();
        }
        if (retryOrEndCommand.equals(RetryOrEndCommand.END)) {
            printResultStep();
        }
    }

    private void printResultStep() {
        Map<String, String> finalShape = bridgeGame.generatePrintBridge();
        String finalGameStatus = "";
        if (gameStatus.equals(GameStatus.SUCCESS)) {
            finalGameStatus = SUCCESS_MESSAGE;
        }
        if (gameStatus.equals(GameStatus.FAILURE)) {
            finalGameStatus = FAILURE_MESSAGE;
        }
        outputView.printResult(finalShape, finalGameStatus, bridgeGame.getTryNumber());
    }
}
