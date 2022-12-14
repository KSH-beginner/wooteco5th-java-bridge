package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private static final int DOWN_SHAPE_NUMBER = 0;
    private static final int UP_SHAPE_NUMBER = 1;
    private static final String DOWN_SHAPE = "D";
    private static final String UP_SHAPE = "U";

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> generatedMovableShapes = new ArrayList<>();
        for (int generateBridgeIndex = 0; generateBridgeIndex < size; generateBridgeIndex++) {
            String bridgeShape = convertNumberToShape(bridgeNumberGenerator.generate());
            generatedMovableShapes.add(bridgeShape);
        }
        return generatedMovableShapes;
    }

    private String convertNumberToShape(int number) {
        String bridgeShape = "";
        if (number == DOWN_SHAPE_NUMBER) {
            bridgeShape = DOWN_SHAPE;
        }
        if (number == UP_SHAPE_NUMBER) {
            bridgeShape = UP_SHAPE;
        }
        return bridgeShape;
    }
}
