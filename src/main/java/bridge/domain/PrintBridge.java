package bridge.domain;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintBridge {

    private static final String UP_SHAPE_KEY = "upShape";
    private static final String DOWN_SHAPE_KEY = "downShape";
    private static final String PRINT_MESSAGE_FORMAT = "[ {0} ]";
    private static final String PRINT_MESSAGE_DELIMITER = " | ";

    private final Map<String, String> shapes = new HashMap<>();

    public void generate(List<String> upShape, List<String> downShape) {
        shapes.put(UP_SHAPE_KEY, convertForPrint(upShape));
        shapes.put(DOWN_SHAPE_KEY, convertForPrint(downShape));
    }

    private String convertForPrint(List<String> shape) {
        String joinedShape = String.join(PRINT_MESSAGE_DELIMITER, shape);
        return MessageFormat.format(PRINT_MESSAGE_FORMAT, joinedShape);
    }

    public Map<String, String> getShapes() {
        return shapes;
    }
}
