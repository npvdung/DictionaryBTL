module com.example.graphicsversion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graphicsversion to javafx.fxml;
    exports com.example.graphicsversion;
}