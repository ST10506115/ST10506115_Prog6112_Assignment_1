/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Nathan Cant
 */
public class Ward 
{
    private Bed[][] beds;
    
    public Ward()
        {
            beds = new Bed[4][5];
            
            int bedCounter = 1;
            
            for (int row = 0; row < 4; row++)
                {
                    for (int col = 0; col < 5; col++)
                        {
                            String bedNumber = String.format("B%02d", bedCounter);
                            beds[row][col] = new Bed(bedNumber);
                            bedCounter++;
                        }
                }
        }
    public void displayWardLayout()
    {
        for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 5; col++)
                    {
                        System.out.print(beds[row][col].getBedNumber() + " ");
                    }
                System.out.println();
            }
    }
    
    public boolean allocateBed(Inpatient patient)
    {
        for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 5; col++)
                    {
                        if (!beds[row][col].isOccupied())
                            {
                                beds[row][col].occupyBed(patient);
                                patient.setBedNumber(beds[row][col].getBedNumber());
                                return true;
                            }
                    }
            }
            return false;
    }
    
    public boolean releaseBed(String bedNumber)
    {
        for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 5; col++)
                    {
                        if (beds[row][col].getBedNumber().equals(bedNumber))
                            {
                                beds[row][col].releaseBed();
                                return true;
                            }
                    }
            }
            return false;        
    }
    
    public void displayAvailableBeds()
    {
        for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 5; col++)
                    {
                        if (!beds[row][col].isOccupied())
                            {
                                System.out.print(beds[row][col].getBedNumber() + " ");
                            }
                    }
            }     
    }
    
    public void displayOccupiedBeds()
    {
        for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 5; col++)
                    {
                        if (beds[row][col].isOccupied())
                            {
                                System.out.print(beds[row][col].getBedNumber() + " ");
                            }
                    }
            }     
    }

    public int getOccupiedBedCount()
    {
        int count = 0;
        for (int i = 0; i < beds.length; i++)
            {
                for (int j = 0; j < beds[i].length; j++)
                    {
                        if (beds[i][j].isOccupied())
                            {
                                count++;
                            }
                    }   
            }
            return count;
    }
    
//"Helper method" to calc bed count
    public int getTotalBeds()
    {
        return beds.length * beds[0].length;
    }
    
//get beds (For JUnit)
    public Bed[][] getBeds()
        {
            return beds;
        }
}
