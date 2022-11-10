package uk.ac.rgu.cm2115.devices;

public class Thermostat extends Devices<TurnStatus> {

    public String myTurn;
    //public TurnStatus status; 

    public Thermostat(String aname) {
        super(aname);
        this.Status = TurnStatus.OFF; 
    }
    

    public void turnOn(){
        System.out.println(getName() + " Is" + " Turned On, " + " Status: " + TurnStatus.ON);
    }

    public void turnOff(){
        System.out.println(getName() + " Is" + " Turned Off," + " Status: " + TurnStatus.ON);
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
