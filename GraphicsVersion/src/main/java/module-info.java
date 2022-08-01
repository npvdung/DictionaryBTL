module com.example.graphicsversion {
    requires javafx.controls;
    requires javafx.fxml;
    requires voicerss.tts;
    requires java.desktop;


    opens com.example.graphicsversion to javafx.fxml;
    exports com.example.graphicsversion;
}