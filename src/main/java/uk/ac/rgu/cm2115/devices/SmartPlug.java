package uk.ac.rgu.cm2115.devices;

public class SmartPlug extends Devices implements Switchable{
    //Fields 
    //public String mySwitch;
    

    // public void simpleMessage(){
    //     System.out.println("Input Either (on/off)");
    // }
    
    public SmartPlug(String aname) {
        super(aname);
        //T
    }
    
    @Override
    public void swichOn(){
        System.out.print(getName() + " is " + " Switch On");
    }
    
    @Override
    public void swichOff(){
        System.out.print(getName() + " is " + " Switch Off");
    }
    
    // Default Constructor method 
    // public SmartPlug(){
    //     mySwitch = "not set"; 
    // }

    // //Parametric Constructor 
    // public SmartPlug(String aMySwitch){
    //     mySwitch = aMySwitch; 
    // }

    // //Getter Mathods 
    // public String getMyString(){
    //     return mySwitch; 
    // }

    // //Setters 
    // /*
    // public void setMySwitch(String Make){
    //     mySwitch = aMySwitch;
    // }
    // */

    // // Other methods 

    // // ToString Method 
    // public String toString(){
    //     String output = "";
    //     output += "The Switch is " + getMyString(); 
    //     return output; 
    // }

}
