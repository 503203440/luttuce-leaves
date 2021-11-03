package org.yx.lettuce_leaves;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MainApplication extends Application {

    private double xOffSet = 0;
    private double yOffSet = 0;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("index-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        Scene scene = new Scene(fxmlLoader.load());
//        scene.setFill(Color.BLACK);
        stage.setTitle("LETTUCE-LEAVES");
//        stage.initStyle(StageStyle.UNIFIED);
        if (Platform.isSupported(ConditionalFeature.UNIFIED_WINDOW)) {
            log.info("支持UNIFIED_WINDOW");
        } else {
            log.warn("不支持UNIFIED_WINDOW");
        }

        stage.setScene(scene);
//        stage.setOpacity(0.85);
        stage.show();
//        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setOnCloseRequest(windowEvent -> {
            if (ConfirmUtil.confirm("要退出lettuce-leaves吗")) {
                log.info("用户退出，windowEvent:{}", windowEvent.getEventType().getName());
                System.exit(0);
            }
            windowEvent.consume();// 标记事件已消费，阻止进一步传播
        });

        scene.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY() - yOffSet);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}