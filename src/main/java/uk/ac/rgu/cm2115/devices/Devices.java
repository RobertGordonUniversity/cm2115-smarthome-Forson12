package uk.ac.rgu.cm2115.devices;

public abstract class Devices {

    protected String name; 

    public Devices(String aname) {
        name = aname; 
    }
    
    
    
    public final String getName() {
        return name;
        
    }
    

    // ToString Method 
    public final String toString(){
        String output = "";
        output += getName() +" " + getClass().getSimpleName(); 
        return output; 
    }
}
