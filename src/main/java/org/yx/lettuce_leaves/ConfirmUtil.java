package org.yx.lettuce_leaves;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * @author YX
 * @date 2021/10/27
 */
public class ConfirmUtil {
    public static boolean confirm(String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, content, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        return ButtonType.YES.equals(buttonType.get());
    }
}
