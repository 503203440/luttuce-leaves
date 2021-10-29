package org.yx.lettuce_leaves;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author YX
 * @date 2021/10/27
 */
@Slf4j
public class IndexController {


    @FXML
    private Button exit;

    @FXML
    public void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "要退出lettuce-leaves吗", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.YES)) {
            log.info("用户退出");
            System.exit(0);
        }
    }

}
