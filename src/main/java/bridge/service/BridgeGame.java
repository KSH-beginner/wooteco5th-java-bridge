package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameStatus;
import bridge.model.GeneratedBridge;
import bridge.model.PlayerBridge;
import bridge.model.PrintBridge;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private GeneratedBridge generatedBridge;
    private final PlayerBridge playerBridge;
    private final PrintBridge printBridge;

    private static final String UP_MOVING = "U";
    private static final String DOWN_MOVING = "D";

    private int moveIndex;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.playerBridge = new PlayerBridge();
        this.printBridge = new PrintBridge();
        moveIndex = 0;
    }

    public void generateBridge(int bridgeSize) {
        List<String> generatedBridgeShape = bridgeMaker.makeBridge(bridgeSize);
        generatedBridge = new GeneratedBridge(generatedBridgeShape);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (generatedBridge.canMove(moveIndex, moving)) {
            playerBridge.addSuccessShape(moving);
            moveIndex++;
        }
        if (!generatedBridge.canMove(moveIndex, moving)) {
            playerBridge.addFailureShape(moving);
        }
    }

    public GameStatus judgeGameStatus() {
        int currentPlayerBridgeSize = moveIndex;
        if (generatedBridge.isSameSize(currentPlayerBridgeSize)) {
            return GameStatus.SUCCESS;
        }
        if (!generatedBridge.isSameSize(currentPlayerBridgeSize)) {
            return GameStatus.FAILURE;
        }
        return GameStatus.PLAY;
    }

    public Map<String, String> generatePrintBridge() {
        Map<String, List<String>> currentShapes = playerBridge.getCurrentShapes();
        return printBridge.generate(currentShapes);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
