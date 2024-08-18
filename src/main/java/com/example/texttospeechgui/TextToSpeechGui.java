package com.example.texttospeechgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TextToSpeechGui extends Application {
    private static final int APP_WIDTH = 375;
    private static final int APP_HEIGHT = 475;

    private TextArea textArea;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Text-to-speech App");
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene() {
        VBox box = new VBox();
        Label textToSpeechLabel = new Label("Text To Speech");

        box.getStyleClass().add("body");

        textToSpeechLabel.getStyleClass().add("text-to-speech-label");
        textToSpeechLabel.setMaxWidth(Double.MAX_VALUE);
        textToSpeechLabel.setAlignment(Pos.CENTER);
        box.getChildren().add(textToSpeechLabel);

        textArea = new TextArea();
        // Add text area:
        textArea.setWrapText(true);
        textArea.getStyleClass().add("text-area");

        StackPane textAreaPane = new StackPane();
        // Add 'margin' around left and right of text area:
        textAreaPane.setPadding(new Insets(0, 15, 0, 15));
        textAreaPane.getChildren().add(textArea);

        box.getChildren().add(textAreaPane);

        // Add settings buttons:
        GridPane settingsPane = createSettingComponents();
        box.getChildren().add(settingsPane);

        return new Scene(box, APP_WIDTH, APP_HEIGHT);
    }

    private GridPane createSettingComponents() {
        GridPane gridPane = new GridPane();

        Label voiceLabel = new Label("Voice");
        Label rateLabel = new Label("Rate");
        Label volumeLabel = new Label("Volume");

        gridPane.add(voiceLabel, 0, 0);
        gridPane.add(rateLabel, 1, 0);
        gridPane.add(volumeLabel, 2, 0);

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}