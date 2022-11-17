package uk.ac.rgu.cm2115.devices;

public abstract class SmartPlug extends Devices<LightStatus> implements Switchable{
    //Fields 
    //public String mySwitch;
    

    // public void simpleMessage(){
    //     System.out.println("Input Either (on/off)");
    // }
    
   // public LightStatus status;

    public SmartPlug(String aname) {
        super(aname);
        this.Status = LightStatus.ON;
        //T
    }
    
    @Override
    public void switchOn(){
        System.out.print(getName() + " is " + " Switched On," + " Status: " + LightStatus.ON + " ");
    }
    
    @Override
    public void switchOff(){
        System.out.print(getName() + " is " + " Switched Off, " + " Status: " + LightStatus.OFF + " ");
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
