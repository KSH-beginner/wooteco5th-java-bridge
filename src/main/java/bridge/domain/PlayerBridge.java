package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PlayerBridge {

    private static final String UP_SHAPE = "U";
    private static final String DOWN_SHAPE = "D";
    private static final String SUCCESS_SHAPE = "O";
    private static final String FAILURE_SHAPE = "X";
    private static final String BLANK_SHAPE = " ";

    private final List<String> upShape = new ArrayList<>();
    private final List<String> downShape = new ArrayList<>();

    public void move(String moveShape, boolean canMove) {
        if (canMove) {
            moveSuccess(moveShape);
        }
        if (!canMove) {
            moveFailure(moveShape);
        }
    }

    private void moveSuccess(String moveShape) {
        if (moveShape.equals(UP_SHAPE)) {
            addUpShape(SUCCESS_SHAPE);
            addDownShape(BLANK_SHAPE);
        }
        if (moveShape.equals(DOWN_SHAPE)) {
            addDownShape(SUCCESS_SHAPE);
            addUpShape(BLANK_SHAPE);
        }
    }

    private void moveFailure(String moveShape) {
        if (moveShape.equals(UP_SHAPE)) {
            addUpShape(FAILURE_SHAPE);
            addDownShape(BLANK_SHAPE);
        }
        if (moveShape.equals(DOWN_SHAPE)) {
            addDownShape(FAILURE_SHAPE);
            addUpShape(BLANK_SHAPE);
        }
    }

    private void addUpShape(String shapeToAdd) {
        upShape.add(shapeToAdd);
    }

    private void addDownShape(String shapeToAdd) {
        downShape.add(shapeToAdd);
    }

    public int getCurrentBridgeSize() {
        return upShape.size();
    }

    public List<String> getCurrentUpShape() {
        return Collections.unmodifiableList(this.upShape);
    }

    public List<String> getCurrentDownShape() {
        return Collections.unmodifiableList(this.downShape);
    }

    public void initializeShape() {
        upShape.clear();
        downShape.clear();
    }
}
