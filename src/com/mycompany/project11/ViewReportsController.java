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

public class ViewReportsController {

    @FXML private TextArea reportArea;

    @FXML
    public void initialize() {
        StringBuilder report = new StringBuilder();
        double totalGrades = 0;
        int gradeCount = 0;

        report.append("=== Students Grades ===\n");
        try {
            File gradesFile = new File("grades.txt");
            if (gradesFile.exists()) {
                Scanner sc = new Scanner(gradesFile);
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    report.append(line).append("\n");
                    
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        try {
                            totalGrades += Double.parseDouble(parts[2]);
                            gradeCount++;
                        } catch (NumberFormatException e) { }
                    }
                }
                sc.close();
            } else {
                report.append("No grades found.\n");
            }

            if (gradeCount > 0) {
                double avg = totalGrades / gradeCount;
                report.append("\n===========================\n");
                report.append("Overall Average Grade: ").append(String.format("%.2f", avg)).append("\n");
            }
        } catch (Exception e) {
            report.append("Error reading file.");
        }
        reportArea.setText(report.toString());
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        App.setRoot("Dashboard");
    }
}