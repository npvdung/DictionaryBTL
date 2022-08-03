module com.example.graphicsversion {
    requires javafx.controls;
    requires javafx.fxml;
    requires voicerss.tts;
    requires java.desktop;
    requires org.json;
    requires org.apache.commons.text;

    opens com.example.graphicsversion to javafx.fxml;
    exports com.example.graphicsversion;
}