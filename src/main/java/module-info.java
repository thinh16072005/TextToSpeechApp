module com.example.texttospeechgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.texttospeechgui to javafx.fxml;
    exports com.example.texttospeechgui;
}