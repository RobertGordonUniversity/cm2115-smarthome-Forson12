package uk.ac.rgu.cm2115.devices;

public abstract class Devices <T>{
    // lab 5
    protected T Status; 

    protected String name; 

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

}

   








