package uk.ac.rgu.cm2115.devices;

public abstract class Thermostat extends Devices<TurnStatus> {

    public String myTurn;
    //public TurnStatus status; 

    public Thermostat(String aname) {
        super(aname);
        this.Status = TurnStatus.ON; 
    }
    

    public void turnOn(){
        this.Status = TurnStatus.ON;
        System.out.println(getName() + " Is" + " Turned On, " + " Status: " + this.getStatus() + " ");
    }

    public void turnOff(){
        this.Status = TurnStatus.OFF;
        System.out.println(getName() + " Is" + " Turned Off," + " Status: " + this.getStatus() + " ");
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
