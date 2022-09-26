package uk;

public class SmartApp {
    //Fields 
    public String mySwitch;
    

    // Default Constructor method 
    public SmartApp(){
        System.out.println("Input Either (on/off)");
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
