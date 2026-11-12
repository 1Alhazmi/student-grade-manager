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

public class AddStudentController {

    @FXML private TextField studentIdField;
    @FXML private TextField studentNameField;
    @FXML private Label statusLabel;

    @FXML
    private void handleSaveStudent(ActionEvent event) {
        String id = studentIdField.getText();
        String name = studentNameField.getText();

        if(id.isEmpty() || name.isEmpty()) {
            statusLabel.setText("Please fill all fields!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        Student newStudent = new Student(id, name);

        // كتابة البيانات في الملف
        try (FileWriter writer = new FileWriter("students.txt", true)) {
            writer.write(newStudent.toString() + "\n");
            statusLabel.setText("Student saved successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
            studentIdField.clear();
            studentNameField.clear();
        } catch (IOException e) {
            statusLabel.setText("Error saving student!");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        App.setRoot("Dashboard");
    }
}