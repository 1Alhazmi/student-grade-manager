/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class DashboardController {

    @FXML
    private void goToAddStudent(ActionEvent event) {
        try {
            App.setRoot("AddStudent");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToAddGrade(ActionEvent event) {
        try {
            App.setRoot("AddGrades"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goToViewStudents(ActionEvent event) {
        try {
            App.setRoot("ViewStudents");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goToViewReports(ActionEvent event) {
        try {
            App.setRoot("ViewReports");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
