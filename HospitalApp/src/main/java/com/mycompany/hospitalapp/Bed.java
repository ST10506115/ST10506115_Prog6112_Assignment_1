/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
public class Bed 
{
    private String bedNumber;
    private boolean occupied;
    private Inpatient patient;

public Bed(String bedNumber)
    {
        this.bedNumber = bedNumber;
        this.occupied = false;
        this.patient = null;
    }

//getters
    public String getBedNumber()
    {
        return bedNumber;
    }

    public boolean isOccupied()
    {
        return occupied;
    }

    public Inpatient getPatient()
    {
        return patient;
    }
    
public void occupyBed(Inpatient patient)
    {
        this.occupied = true;
        this.patient = patient;
    }

public void releaseBed()
    {
        this.occupied = false;
        this.patient = null;
    }
}
