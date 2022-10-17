package uk.ac.rgu.cm2115;

import uk.ac.rgu.cm2115.devices.Devices;

public class Thermostat extends Devices{
    public Thermostat(String aname) {
        super(aname);
        //
    }

    public String myTurn;
    

    public void turnOn(){
        System.out.println(getName() + " Is" + " Turned On");
    }

    public void turnOff(){
        System.out.println(getName() + " Is" + " Turned Off");
    }

    // // Default Constructor method 
    // public Thermostat(){
    //     myTurn = "not set"; 
    // }

    // //Parametric Constructor 
    // public Thermostat(String aMyTurn){
    //     myTurn = aMyTurn; 
    // }

    // //Getter Mathods 
    // public String getMyTurn(){
    //     return myTurn; 
    // }

    // //Setters 
    // /*
    // public void setMyTurn(String myTurn){
    //     myTurn = aMyTurn;
    // }
    // */

    // // Other methods 

    // // ToString Method 
    // public String toString(){
    //     String output = "";
    //     output += "The Thermostat is " + getMyTurn(); 
    //     return output; 
    // }
}
