/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
public class Patient 
{
    private static int patientCounter = 0;
    
    private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private PatientCategory category;
    
    //Generate patient ID with incrementation
    public Patient(String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory category)
    {
        patientCounter++;
        this.patientID = String.format("P%03d", patientCounter);
    
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.medicalCondition = medicalCondition;
    this.category = category;
    }
    
    //Getters & Setters
    //get patientID (NO setter)
    public String getPatientID()
    {
        return patientID;
    }
    
    //first Name
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    //Last name
    public String getLastName()
    {
        return lastName;
    }
    
     public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
     
    //age
    public int getAge()
    {
        return age;
    }
      
    public void setAge(int age)
    {
       this.age = age;
    }
    
    //gender
    public String getGender()
    {
        return gender;
    }
     
    public void setGender(String gender)
    {
        this.gender = gender;
    }
      
    //Medical condition
    public String getMedicalCondition()
    {
       return medicalCondition;
    }
    
    public void setMedicalCondition(String medicalCondition)
    {
        this.medicalCondition = medicalCondition;
    }
    
    //Category
    public PatientCategory getCategory()
    {
        return category;
    }
    
    public void setCategory(PatientCategory category)
    {
        this.category = category;
    }
    
    public void displayDetails()
    {
    System.out.println("-----Patient info-----");
    System.out.println("ID: " + patientID);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Medical condition: " + medicalCondition);
    System.out.println("Category: " + category);
    }
}
