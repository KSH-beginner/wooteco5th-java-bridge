package bridge.model;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintBridge {

    private static final String JOIN_DELIMITER = " | ";
    private static final String PRINT_BRIDGE_SHAPE_FORMAT = "[ {0} ]";
    private static final String UP_SHAPE_KEY = "upShape";
    private static final String DOWN_SHAPE_KEY = "downShape";

    private String upShape;
    private String downShape;

    public Map<String, String> generate(Map<String, List<String>> currentPlayerBridgeShape) {
        Map<String, String> convertedShapeMap = new HashMap<>();
        upShape = convertToPrintShape(currentPlayerBridgeShape.get(UP_SHAPE_KEY));
        downShape = convertToPrintShape(currentPlayerBridgeShape.get(DOWN_SHAPE_KEY));
        convertedShapeMap.put(UP_SHAPE_KEY, upShape);
        convertedShapeMap.put(DOWN_SHAPE_KEY, downShape);
        return convertedShapeMap;
    }

    private String convertToPrintShape(List<String> playerBridgeShape) {
        String joinedShape = String.join(JOIN_DELIMITER, playerBridgeShape);
        return MessageFormat.format(PRINT_BRIDGE_SHAPE_FORMAT, joinedShape);
    }
}
