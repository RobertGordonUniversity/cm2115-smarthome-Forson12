package uk.ac;

import uk.ac.rgu.cm2115.devices.Devices;

/**
 * Class to act as a hub for the smarthome
 * @author Mark Snaith
 */
public class Home  {
    public Devices[] devices; 

    public Home(){
        devices = new Devices[4]; 

    }
    public void addDevice(Devices Device){
        for(int i=0; i<this.devices.length; i++){
            if(devices[i] == null){
                devices[i] = Device; 
                break; 
            }
        }

    }
    // getter Method 
    public Devices[] getDevices(){
        return this.devices; 
    } 

}
