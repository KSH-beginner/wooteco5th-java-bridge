package bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBridge {

    private static final String UP_MOVING = "U";
    private static final String DOWN_MOVING = "D";
    private static final String SUCCESS_SHAPE = "O";
    private static final String FAILURE_SHAPE = "X";
    private static final String BLANK_SHAPE = " ";
    private static final String UP_SHAPE_KEY = "upShape";
    private static final String DOWN_SHAPE_KEY = "downShape";

    private final List<String> upShape = new ArrayList<>();
    private final List<String> downShape = new ArrayList<>();

    public void addSuccessShape(String moving) {
        if (moving.equals(UP_MOVING)) {
            upShape.add(SUCCESS_SHAPE);
            downShape.add(BLANK_SHAPE);
        }
        if (moving.equals(DOWN_MOVING)) {
            downShape.add(SUCCESS_SHAPE);
            upShape.add(BLANK_SHAPE);
        }
    }

    public void addFailureShape(String moving) {
        if (moving.equals(UP_MOVING)) {
            upShape.add(FAILURE_SHAPE);
            downShape.add(BLANK_SHAPE);
        }
        if (moving.equals(DOWN_MOVING)) {
            downShape.add(FAILURE_SHAPE);
            upShape.add(BLANK_SHAPE);
        }
    }

    public Map<String, List<String>> getCurrentShapes() {
        Map<String, List<String>> currentShapeMap = new HashMap<>();
        currentShapeMap.put(UP_SHAPE_KEY, upShape);
        currentShapeMap.put(DOWN_SHAPE_KEY, downShape);
        return currentShapeMap;
    }
}
