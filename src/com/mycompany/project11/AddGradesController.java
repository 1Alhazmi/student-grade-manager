/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddGradesController {

    @FXML private TextField studentIdField;
    @FXML private TextField courseField;
    @FXML private TextField gradeField;
    @FXML private Label statusLabel;

    @FXML
    private void handleSaveGrade(ActionEvent event) {
        String id = studentIdField.getText();
        String course = courseField.getText();
        String grade = gradeField.getText();

        if(id.isEmpty() || course.isEmpty() || grade.isEmpty()) {
            statusLabel.setText("Please fill all fields!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        String record = id + "," + course + "," + grade;

        try (FileWriter writer = new FileWriter("grades.txt", true)) {
            writer.write(record + "\n");
            statusLabel.setText("Grade saved successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
            
            studentIdField.clear();
            courseField.clear();
            gradeField.clear();
        } catch (IOException e) {
            statusLabel.setText("Error saving grade!");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        App.setRoot("Dashboard");
    }
}