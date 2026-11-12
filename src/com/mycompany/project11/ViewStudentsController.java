/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ViewStudentsController {

    @FXML private TextArea displayArea;

    @FXML
    public void initialize() {
        StringBuilder report = new StringBuilder();
        report.append("=== All Registered Students ===\n");
        try {
            File studentsFile = new File("students.txt");
            if (studentsFile.exists()) {
                Scanner sc = new Scanner(studentsFile);
                while(sc.hasNextLine()) {
                    report.append(sc.nextLine()).append("\n");
                }
                sc.close();
            } else {
                report.append("No students found.\n");
            }
        } catch (Exception e) {
            report.append("Error reading file.");
        }
        displayArea.setText(report.toString());
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        App.setRoot("Dashboard");
    }
}