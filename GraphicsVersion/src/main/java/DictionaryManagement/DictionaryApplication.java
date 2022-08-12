package DictionaryManagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryApplication implements Initializable {
    @FXML
    public Button mic;
    @FXML
    public Button search;
    @FXML
    public Button audio;
    @FXML
    public TextField inWord;
    @FXML
    public Button fix;
    @FXML
    public Button delete;
    @FXML
    public TextArea translate;
    @FXML
    public ListView<String> listView;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
