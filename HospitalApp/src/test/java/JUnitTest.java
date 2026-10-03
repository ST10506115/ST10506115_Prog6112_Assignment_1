/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospitalapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nathan Cant
 */
public class JUnitTest 
{
    private PatientManager patientManager;
    private Ward ward;
    
    @BeforeEach
    public void setUp()
        {
            patientManager = new PatientManager();
            ward = new Ward();
        }
    
//create, register, and find Patient
    @Test
    public void testRegisterPatient()
        {
            Inpatient patient = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            Patient found = patientManager.searchPatientByID("P001");
            assertNotNull(found, " Patient Should Be Found");
            assertEquals("John Doe ", found.getFirstName() + " " + found.getLastName(), " Patient Name Should Be John Doe");
        }
    
//Search for Patient
    @Test
    public void testSearchPatient()
        {
            Inpatient patient = new Inpatient("Sarah ", "Smith ", 25, " F ", "Broken Arm ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            Patient found = patientManager.searchPatientByID("P001");
            assertNotNull(found, " Patient Should Be Found");
        }
    
//Update Patient Details
    @Test
    public void testUpdatePatient()
        {
            Inpatient patient = new Inpatient("John ", "Doe" , 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            Patient found = patientManager.searchPatientByID("P001");
            found.setMedicalCondition("Headache ");
            
            Patient updated = patientManager.searchPatientByID("P001");
            assertEquals("Medical Condition Should Be Updated ", "Headache ", updated.getMedicalCondition());
        }
    
//Delete Patient
    @Test
    public void testDeletePatient()
        {
            Inpatient patient = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            boolean deleted = patientManager.deletePatient("P001");
            assertTrue(deleted, " Patient Should Be Deleted");
            
            Patient found = patientManager.searchPatientByID("P001");
            assertNull(found, "Patient Should Not Be Found After Deletion ");
        }
    
//Allocate a bed
    @Test
    public void testAllocateBed()
    {
            Inpatient patient = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            boolean allocated = ward.allocateBed(patient);
            assertTrue( allocated, " Bed Should Be Allocated");
    }        
    
//Release Bed
    @Test
    public void testReleaseBed()
        {
            Inpatient patient = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(patient);
            
            ward.allocateBed(patient);
            ward.releaseBed("P001");
            
            assertEquals(false, ward.getBeds()[0][0].isOccupied(), " Bed B01 Should Be Available");
        }
    
//Prevent duplicate patient ID
    @Test
    public void testPreventDuplicatePatientID()
        {
            Inpatient patient1 = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            Inpatient patient2 = new Inpatient("Jane ", "Doe ", 25, " F ", "Cold ", 0, " N/A");
            
            patientManager.registerPatient(patient1);
            patientManager.registerPatient(patient2);
            
            assertNotEquals("Patients Should Not Have Different ID's ", patient1.getPatientID(), patient2.getPatientID());              
        }
    
//Prevent duplicate beds
    @Test
    public void testPreventOccupiedBedAllocation()
        {
            Inpatient patient1 = new Inpatient("John ", "Doe ", 30, " M ", "Fever ", 0, " N/A");
            Inpatient patient2 = new Inpatient("Jane ", "Doe ", 25, " F ", "Cold ", 0, " N/A");
            
            patientManager.registerPatient(patient1);
            patientManager.registerPatient(patient2);
            
            ward.allocateBed(patient1);
            boolean allocated = ward.allocateBed(patient2);
            
            assertTrue(allocated, " Second Patient Should Get A Different Bed");
            assertNotEquals("Patients Should Be In Different Beds", patient1.getBedNumber(), patient2.getBedNumber());
        }
    
//Prevent duplicate bed allocation when all beds are full
    @Test
    public void testPreventAllocationWhenFullBeds()
        {
            for(int i = 0; i < 20; i++)
                {
                    Inpatient patient = new Inpatient("Patient " + i, "Last " + i, 30, " M ", "Condition ", 0, " N/A ");
                    patientManager.registerPatient(patient);
                    ward.allocateBed(patient);
                }
            Inpatient extraPatient = new Inpatient("Extra ", "Patient ", 30, " M ", "Fever ", 0, " N/A");
            patientManager.registerPatient(extraPatient);
            boolean allocated = ward.allocateBed(extraPatient);
            
            assertFalse(allocated, " Allocation Should Fail When All Beds Are Occupied");
        }
}
