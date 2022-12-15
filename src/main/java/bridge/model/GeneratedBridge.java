package bridge.model;

import java.util.List;

public class GeneratedBridge {

    private final List<String> shapes;

    public GeneratedBridge(List<String> shapes) {
        this.shapes = shapes;
    }

    public boolean canMove(int moveIndex, String playerMoveShape) {
        String movableShape = shapes.get(moveIndex);
        return movableShape.equals(playerMoveShape);
    }
}
