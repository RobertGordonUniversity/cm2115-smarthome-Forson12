package uk.ac.rgu.cm2115.devices;

public abstract class Devices {

    protected String name; 

    public Devices(String aname) {
        name = aname; 
    }
    
    public String getName() {
        return name;
        
    }

}
