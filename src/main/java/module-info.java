module org.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    exports org.example.demo1.controller to javafx.fxml;
    opens org.example.demo1.controller to javafx.fxml;
    opens org.example.demo1 to javafx.fxml;

    exports org.example.demo1;
}