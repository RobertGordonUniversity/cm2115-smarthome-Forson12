package uk.ac.rgu;

public class SmartApp {
    //Fields 
    public String mySwitch;
    

    public void simpleMessage(){
        System.out.println("Input Either (on/off)");
    }
    
    // Default Constructor method 
    public SmartApp(){
        mySwitch = "not set"; 
    }

    //Parametric Constructor 
    public SmartApp(String aMySwitch){
        mySwitch = aMySwitch; 
    }

    //Getter Mathods 
    public String getMyString(){
        return mySwitch; 
    }

    //Setters 
    /*
    public void setMySwitch(String Make){
        mySwitch = aMySwitch;
    }
    */

    // Other methods 

    // ToString Method 
    public String toString(){
        String output = "";
        output += "The Switch is " + getMyString(); 
        return output; 
    }

}
