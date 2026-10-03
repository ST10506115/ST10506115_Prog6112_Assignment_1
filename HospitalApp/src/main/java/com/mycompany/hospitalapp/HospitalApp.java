/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
import java.util.Scanner;
public class HospitalApp 
{

    public static void main(String[] args) 
    {
//Create instances
        
        PatientManager patientManager = new PatientManager();
        Ward ward = new Ward();
        ReportManager reportManager = new ReportManager(patientManager, ward);
        
        Scanner scanner = new Scanner(System.in);
        
//Menu loop

        boolean running = true;
        while(running)
            {
                System.out.println("========== HOSPITAL MENU ==========");
                System.out.println("1. Register Patient");
                System.out.println("2. Search Patient By ID");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. View Full Report");
                System.out.println("6. Allocate Beds");
                System.out.println("7. Release Bed");
                System.out.println("8. Display Ward Layout");
                System.out.println("9. Exit");
                System.out.println("Enter Choice: ");

                int choice = scanner.nextInt();

                switch(choice)
                    {
                    case 1:     //Register Patient
                        
                        System.out.print("Enter First Name: ");
                        scanner.nextLine();
                        String firstName = scanner.nextLine();
                        
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        
                        System.out.print("Enter Gender M/F: "); 
                        scanner.nextLine();
                        String gender = scanner.nextLine();
                        
                        System.out.print("Enter Medical Condition: ");
                        String medicalCondition = scanner.nextLine();
                        
//Create and register an Inpatient
                        Inpatient newPatient = new Inpatient(firstName, lastName, age, gender, medicalCondition, 0, "N/A");
                        patientManager.registerPatient(newPatient);
                        
                        System.out.println("A New Patient Has Been Registered!");
                        break;
                        
                    case 2:     //Search for a patient
                        
                        System.out.print("Enter Patient ID To Search: ");
                        String searchID = scanner.next();
                        Patient foundPatient = patientManager.searchPatientByID(searchID);
                            if(foundPatient != null)
                                {
                                    foundPatient.displayDetails();
                                }
                            else
                                {   
                                    System.out.println("Patient Not Found!");
                                }
                        break;
                        
                    case 3:     //Update Patient   
                        
                        System.out.print("Enter Patient ID To Update: ");
                        String updateID = scanner.next();
                        Patient patientToUpdate = patientManager.searchPatientByID(updateID);
                            if(patientToUpdate != null)
                                {
                                    System.out.print("Enter New Medical Condition: ");
                                    scanner.nextLine();
                                    String newCondition = scanner.nextLine();
                                    patientToUpdate.setMedicalCondition(newCondition);
                                    System.out.println("Patient Updated Successfully!");
                                }
                            else
                                {
                                    System.out.println("Patient Not Found!");
                                }
                        break;
                        
                    case 4:     //Delete a patient
                        
                        System.out.print("Enter Patient ID To Delete: ");
                        String deleteID = scanner.next();
                            if(patientManager.deletePatient(deleteID))
                                {
                                    System.out.println("Patient Deleted Successfully!");
                                }
                            else
                                {
                                    System.out.println("Patient Not Found!");
                                }
                        break;
                        
                    case 5:     //View full report
                        
                        reportManager.displayFullReport();
                        break;
                        
                    case 6:     //Allocate A Bed
                        
                       System.out.print("Enter Patient ID: ");
                       String patientID = scanner.next();
                       Patient patientForBed = patientManager.searchPatientByID(patientID);
                        if(patientForBed != null)
                            {
                            if(patientForBed instanceof Inpatient)
                                {
                                    ward.allocateBed((Inpatient) patientForBed);
                                    System.out.println("Bed Allocated Successfully!");
                                }
                            else
                                {
                                    System.out.println("Only Inpatients May Be Allocated A Bed!");
                                }
                            }
                            else
                                {
                                    System.out.println("Patient Not Found!");
                                }
                        break;
                        
                    case 7:     //Clear A Bed
                        
                        System.out.println("Enter Bed Number To Release A Bed (eg. B01): ");
                        String bedNumber = scanner.next();
                        ward.releaseBed(bedNumber);
                        System.out.println("Bed Successfully Released!");
                        break;
                        
                    case 8:     //Display ward layout
                        
                        System.out.println("\n=== Ward Layout: ===");
                        ward.displayWardLayout();
                        
                        System.out.println("\nAvailable Beds: ");
                        ward.displayAvailableBeds();
                        
                        System.out.println("\nOccupied Beds: ");
                        ward.displayOccupiedBeds();
                        System.out.println();
                        break;
                        
                    case 9:
                        
                        running = false;
                        System.out.println("Exiting...");
                        break; 
                        
                    default:
                        System.out.println("Invalid Choice");
                    }
        }
        scanner.close();
    }
}