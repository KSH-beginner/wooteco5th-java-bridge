package bridge.domain;

import java.util.List;

public class GeneratedBridgeShape {

    private final List<String> shapes;

    public GeneratedBridgeShape(List<String> shapes) {
        this.shapes = shapes;
    }

    public boolean isMovableShape(int moveIndex, String shape) {
        String generatedBridgeShape = shapes.get(moveIndex);
        return generatedBridgeShape.equals(shape);
    }

    public boolean isPlayerBridgeSameSize(int playerBridgeSize) {
        return playerBridgeSize == shapes.size();
    }
}
