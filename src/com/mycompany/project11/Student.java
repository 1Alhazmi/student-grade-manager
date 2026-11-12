/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project11;

public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    
    // هذه الدالة ترتب البيانات بصيغة نصية مفصولة بفاصلة لسهولة حفظها في الملف
    @Override
    public String toString() {
        return id + "," + name; 
    }
}