package bridge.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintBridge {

    private static final String UP_SHAPE_KEY = "upShape";
    private static final String DOWN_SHAPE_KEY = "downShape";
    private static final String REPLACE_TARGET = ",";
    private static final String REPLACEMENT = " | ";

    private final Map<String, String> shapes = new HashMap<>();

    public void generate(List<String> upShape, List<String> downShape) {
        shapes.put(UP_SHAPE_KEY, convertForPrint(upShape));
        shapes.put(DOWN_SHAPE_KEY, convertForPrint(downShape));
    }

    private String convertForPrint(List<String> shape) {
        return shape.toString().replace(REPLACE_TARGET, REPLACEMENT);
    }

    public Map<String, String> getShapes() {
        return shapes;
    }
}
