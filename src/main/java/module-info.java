module org.yx.luttuceleaves {
    requires javafx.controls;
    requires javafx.fxml;
    requires hutool.all;
    requires lombok;
    requires slf4j.api;
    requires org.kordamp.bootstrapfx.core;

    opens org.yx.lettuce_leaves to javafx.fxml;
    exports org.yx.lettuce_leaves;
}