package org.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.demo1.morseservice.MorseService;

public class MorseCodeController {

    @FXML
    private TextArea txftextArea; // Eingabefeld
    @FXML
    private TextArea txftextArea2; // Ausgabefeld

    @FXML
    private TextArea txftextArea3;
    @FXML
    private TextArea txftextArea4;



    private final MorseService morseService = new MorseService(); // MorseService-Objekt


    public MorseCodeController() {
    }

    public void initialize() {
        // Fügt einen Listener für Änderungen im Eingabetextfeld hinzu
        txftextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            // Konvertiere den neuen Text in Morsecode
            String morseCode = morseService.wordToMorse(newValue);

            // Zeige den Morsecode im zweiten TextArea an
            txftextArea2.setText(morseCode);
        });

        txftextArea3.textProperty().addListener((observable, oldValue, newValue) -> {
            // Konvertiere den neuen Text in Morsecode
            String word = morseService.morseToWord(newValue);

            // Zeige den Morsecode im zweiten TextArea an
            txftextArea4.setText(word);
        });

    }
}