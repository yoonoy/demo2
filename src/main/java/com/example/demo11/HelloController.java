package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField weightInput;
    @FXML
    private TextField heightInput;
    @FXML
    private Label bmiResult;

    @FXML
    public void clearFields() {
        weightInput.clear();
        heightInput.clear();
        bmiResult.setText("Your BMI");
    }



}
