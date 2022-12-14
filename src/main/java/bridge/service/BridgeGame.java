package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameStatus;
import bridge.domain.GeneratedBridgeShape;
import bridge.domain.PlayerBridge;
import bridge.domain.PrintBridge;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GeneratedBridgeShape generatedBridgeShape;
    private final PlayerBridge playerBridge = new PlayerBridge();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private PrintBridge printBridge = new PrintBridge();

    private GameStatus gameStatus;

    public BridgeGame() {
        this.gameStatus = GameStatus.INIT;
    }

    public void generateBridge(int bridgeSize) {
        List<String> generatedMovableShapes = bridgeMaker.makeBridge(bridgeSize);
        generatedBridgeShape = new GeneratedBridgeShape(generatedMovableShapes);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveShape) {
        int beforeMoveBridgeSize = playerBridge.getCurrentBridgeSize();
        if (generatedBridgeShape.isMovableShape(beforeMoveBridgeSize, moveShape)) {
            playerBridge.move(moveShape, true);
        }
        if (!generatedBridgeShape.isMovableShape(beforeMoveBridgeSize, moveShape)) {
            playerBridge.move(moveShape, false);
            gameStatus = GameStatus.FAILURE;
        }
        int afterMoveBridgeSize = playerBridge.getCurrentBridgeSize();
        if (generatedBridgeShape.isPlayerBridgeSameSize(afterMoveBridgeSize) && gameStatus != GameStatus.FAILURE) {
            gameStatus = GameStatus.SUCCESS;
        }
    }

    public boolean isGameSuccess() {
        return this.gameStatus.equals(GameStatus.SUCCESS);
    }

    public boolean isGameFailure() {
        return this.gameStatus.equals(GameStatus.FAILURE);
    }


    public Map<String, String> getCurrentPlayerBridgeShape() {
        printBridge.generate(playerBridge.getCurrentUpShape(), playerBridge.getCurrentDownShape());
        return printBridge.getShapes();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameStatus = GameStatus.INIT;
        playerBridge.initializeShape();
    }
}
