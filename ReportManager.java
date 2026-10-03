/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
public class ReportManager 
{
    private PatientManager patientManager;
    private Ward ward;

    public ReportManager(PatientManager patientManager, Ward ward)
        {
          this.patientManager = patientManager;  
          this.ward = ward;
        }
    
//get total number of registered patients
    public int getTotalRegisteredPatients()
    {
        return this.patientManager.getPatientCount();
    }
    
//get occupied beds
    public int getTotalOccupiedBeds()
    {
        return this.ward.getOccupiedBedCount();
    }
    
//ward occupancy percentage
    public double getWardOccupancyPercentage()
    {
        int occupied = this.ward.getOccupiedBedCount();
        int total = this.ward.getTotalBeds();
        return (occupied / (double) total) * 100;
    }
    
//Display full report
    public void displayFullReport()
    {
    System.out.println("\n---------- HOSPITAL REPORT ----------");
    System.out.println("\n=== REGISTERED PATIENTS ===");
        this.patientManager.displayAllPatients();
        
    System.out.println("\n=== AVAILABLE BEDS ===");
        this.ward.displayAvailableBeds();
        
    System.out.println("\n=== OCCUPIED BEDS ===");
        this.ward.displayOccupiedBeds();
        
    System.out.println("\n=== STATISTICS ===");
    System.out.println("Total registered patients: " + this.getTotalRegisteredPatients());  
    System.out.println("Total occupied beds: " + this.getTotalOccupiedBeds());
    System.out.println("Ward occupancy percentage: " + String.format("%.2f", this.getWardOccupancyPercentage()) + "%");
    System.out.println("\n=================================================\n");
    }
}
