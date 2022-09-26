package uk.ac.rgu.cm2115;

public class Thermostat {
    public String myTurn;
    

    // Default Constructor method 
    public Thermostat(){
        System.out.println("Input Either (up/down)");
        myTurn = "not set"; 
    }

    //Parametric Constructor 
    public Thermostat(String aMyTurn){
        myTurn = aMyTurn; 
    }

    //Getter Mathods 
    public String getMyTurn(){
        return myTurn; 
    }

    //Setters 
    /*
    public void setMyTurn(String myTurn){
        myTurn = aMyTurn;
    }
    */

    // Other methods 

    // ToString Method 
    public String toString(){
        String output = "";
        output += "The Thermostat is " + getMyTurn(); 
        return output; 
    }
}
