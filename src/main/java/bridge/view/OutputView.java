package bridge.view;

import bridge.GameStatus;

import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_RETRY_OR_END_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String UP_SHAPE_KEY = "upShape";
    private static final String DOWN_SHAPE_KEY = "upShape";
    private static final String IS_GAME_SUCCESS_MESSAGE = "게임 성공 여부 : ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAILURE_MESSAGE = "실패";
    private static final String TOTAL_TRY_NUMBER_MESSAGE = "총 시도한 횟수 : ";

    public void printGameStartMessage() {
        printMessage(GAME_START_MESSAGE);
    }

    public void printReadBridgeSizeMessage() {
        printMessage(READ_BRIDGE_SIZE_MESSAGE);
    }

    public void printReadMovingCommandMessage() {
        printMessage(READ_MOVING_COMMAND_MESSAGE);
    }

    public void printReadRetryOrEndCommandMessage() {
        printMessage(READ_RETRY_OR_END_COMMAND_MESSAGE);
    }
    
    public void printFinalGameResultMessage() {
        printMessage(FINAL_GAME_RESULT_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<String, String> shapes) {
        String upShape = shapes.get(UP_SHAPE_KEY);
        String downShape = shapes.get(DOWN_SHAPE_KEY);
        printMessage(upShape);
        printMessage(downShape);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Map<String, String> currentShapes, GameStatus gameStatus, int tryNumber) {
        printFinalGameResultMessage();
        printMap(currentShapes);
        printGameStatus(gameStatus);
        printTryNumber(tryNumber);
    }

    private void printGameStatus(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.SUCCESS)) {
            printMessage(IS_GAME_SUCCESS_MESSAGE + SUCCESS_MESSAGE);
        }
        if (gameStatus.equals(GameStatus.FAILURE)) {
            printMessage(IS_GAME_SUCCESS_MESSAGE + FAILURE_MESSAGE);
        }
    }

    private void printTryNumber(int tryNumber) {
        printMessage(TOTAL_TRY_NUMBER_MESSAGE + tryNumber);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
