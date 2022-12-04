package uk.ac.rgu.cm2115.devices;

import java.util.Comparator;

import uk.ac.rgu.cm2115.devices.diagnostics.DeviceVisitor;

public abstract class Devices<T> implements Comparable<Devices<?>>{
    // lab 5
    protected T Status; 
    protected String name; 
    private DeviceLogger logger;  
    
    // Accept Method 
    public abstract void accept(DeviceVisitor visitor);

    public Devices(String aname) {
        name = aname;
        try {
            this.logger = new DeviceLogger("devices.log");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
    //protected log method 
    protected void log(String input){
        logger.log(input);
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
            Devices<?> otherDevice = (Devices<?>)other; 
            return otherDevice.name.equals(this.name);
        }
        return false; 
    }

    @Override
    public int compareTo(Devices<?> o) {
        // TODO Auto-generated method stub
        if (name.compareToIgnoreCase(o.name) == -1){
            return -1;
        } else if(name.compareToIgnoreCase(o.name) == 0){
            return 0;  
        }else{
            return 1;
        }
        
    }

    

    //Implementing a Comparator method 
    public static class DeviceComparator implements Comparator<Devices<?>>{
        @Override
        public int compare(Devices<?> o1, Devices<?> o2) {
            // TODO Auto-generated method stub
            if (o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName()) == -1){
                return -1;
            }
            else if(o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName()) == 0){
                return 0; 
            }else {
                return 1;
            }
            
        }

    } 

}

   








