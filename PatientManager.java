/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

import java.util.ArrayList;
/**
 *
 * @author Nathan Cant
 */
public class PatientManager 
{
//Stores all registered patients
    private ArrayList<Patient> patients;                                        
    
//Initialises an empty list of patients  
    public PatientManager()
    {
        this.patients = new ArrayList<Patient>();          
    }

//add a new patient
    public void registerPatient(Patient patient)
    {
        patients.add(patient);
    }

//display info for all registered patients    
    public void displayAllPatients()
    {
        for (Patient p : patients)
        {
            p.displayDetails();
        }
    }

//search for a specific patient    
    public Patient searchPatientByID(String patientID)
    {
    for (Patient p : patients)
        {
            if (p.getPatientID().equals(patientID))
            {
                return p;           //match found
            }
        }
    return null;                    //no match found
    }
//update fields   
public boolean updatePatient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition)
    {
        Patient p = searchPatientByID(patientID);
        if(p != null)
            {
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setAge(age);
                p.setGender(gender);
                p.setMedicalCondition(medicalCondition);
//if conditions are met...update 
                return true;               
            }
//if conditions arent met... return false       
        else
            {
                return false;
            }
    }

public boolean deletePatient(String patientID)
    {
Patient p = searchPatientByID(patientID);
        if(p != null)
            {
                patients.remove(p);
//if conditions are met...delete
                return true;               
            }
//if conditions arent met... return false       
        else
            {
                return false;
            }
    }

    public int getPatientCount()
    {
        return patients.size();
    }
}
