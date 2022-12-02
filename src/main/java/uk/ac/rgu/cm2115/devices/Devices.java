package uk.ac.rgu.cm2115.devices;

import java.util.Comparator;

import uk.ac.rgu.cm2115.devices.diagnostics.DeviceVisitor;

public abstract class Devices<T> implements Comparable <Devices>{
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

    //Implementing a Comparator method 
    public static class DeviceComparator implements Comparator<Devices>{

        @Override
        public int compare(Devices o1, Devices o2) {
            // TODO Auto-generated method stub
            if(o1.getClass().getSimpleName().charAt(0) < o2.getClass().getSimpleName().charAt(0)){
                return -1; 
            }else if (o1.getClass().getSimpleName().charAt(0) > o2.getClass().getSimpleName().charAt(0)){
                return 1;
            }else {
                return 0;
            }
            
        }

    } 

}

   








