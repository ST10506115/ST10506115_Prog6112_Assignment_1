/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
public class Inpatient extends Patient
{
    private int wardNumber;
    private String bedNumber;
    
    public Inpatient(String firstName, String lastName, int age, String gender, String medicalCondition, int wardNumber, String bedNumber)
    {
//set category to "INPATIENT"
        super(firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT);
        
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }
    
//Get & Set wardNumber
    public int getWardNumber()
    {
        return wardNumber;
    }
    
    public void setWardNumber(int wardNumber)
    {
        this.wardNumber = wardNumber;
    }
    
    //Get & Set bedNumber
    public String getBedNumber()
    {
        return bedNumber;
    }
    
    public void setBedNumber(String bedNumber)
    {
        this.bedNumber = bedNumber;
    }
    
//Override display
  @Override
  public void displayDetails()
  {
  super.displayDetails();
  System.out.println("Ward number: " + wardNumber);
  System.out.println("Bed number: " + bedNumber);
  }
}
