package uk.ac.rgu;

public class Light {
    public String myDim;
    SmartApp s2 = new SmartApp("off");

    public Light(){
        myDim = "not set"; 
    }

    // A simple Pop-up message 
    public void simpleMessage(){
        System.out.println("Input Either (up/down)");
    }

    //Parametric Constructor 
    public Light(String aMyDim){
        myDim = aMyDim; 
    }

    //Getter Mathods 
    public String getMyDim(){
        return myDim; 
    }

    //Setters 
    /*
    public void setMyDim(String myDim){
        myDim = aMyDim;
    }
    */

    // Other methods 

    // ToString Method 
    public String toString(){
        String output = "";
        output += "The Thermostat is " + s2.getMyString() + " The Dim is " + getMyDim(); 
        return output; 
    }

}
