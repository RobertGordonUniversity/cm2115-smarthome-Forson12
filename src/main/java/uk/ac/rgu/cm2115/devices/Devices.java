package uk.ac.rgu.cm2115.devices;

import uk.ac.rgu.cm2115.devices.diagnostics.DeviceVisitor;

public abstract class Devices <T>{
    // lab 5
    protected T Status; 

    protected String name; 
    
    // Accept Method 
    public abstract void accept(DeviceVisitor visitor);

    public Devices(String aname) {
        name = aname; 
    }
    
    public final String getName() {
        return name;
        
    }
    
    //lab 5
    public final T getStatus() {
        return Status;
    }



    // ToString Method 
    public final String toString(){
        String output = "";
        output += getName() + " " + getClass().getSimpleName(); 
        return output; 
    }
    // the .equals methid 
    @Override
    public final boolean equals(Object other){
        if(other != null && other.getClass().equals(this.getClass())){
            Devices otherDevice = (Devices)other; 
            return otherDevice.name.equals(this.name);
        }
        return false; 
    }

}

   








