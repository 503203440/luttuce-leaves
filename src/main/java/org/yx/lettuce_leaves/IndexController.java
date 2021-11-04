package org.yx.lettuce_leaves;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author YX
 * @date 2021/10/27
 */
@Slf4j
public class IndexController {

    @FXML
    public void exit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "要退出lettuce-leaves吗", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.YES)) {
            log.info("用户退出");
            System.exit(0);
        }
    }

    @FXML
    public void newConnect(ActionEvent event) {
        String name = event.getSource().getClass().getName();
        Object eventSource = event.getSource();
        if (eventSource instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) eventSource;
            Window ownerWindow = menuItem.getParentPopup().getOwnerWindow();
            System.out.println(name);
            Stage stage = new Stage();
            stage.setTitle("新建连接");
            stage.initOwner(ownerWindow);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }
    }

    @FXML
    public void about(ActionEvent event) {

    }
}
