package uk.ac.rgu.cm2115.devices;

/**
 * Class to act as a hub for the smarthome
 * @author Mark Snaith
 */
public class Home  {
    public Devices[] devices; 

    public Home(){
        devices = new Devices[4]; 

    }
    public void addDevice(Devices device){
        for(int i=0; i<this.devices.length; i++){
            if(devices[i] == null){
                devices[i] = device; 
                break; 
            }
        }

    }
    // getter Method 
    public Devices[] getDevices(){
        return this.devices; 
    } 

}
