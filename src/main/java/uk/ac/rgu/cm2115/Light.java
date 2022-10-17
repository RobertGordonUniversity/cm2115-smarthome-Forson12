package uk.ac.rgu.cm2115;

import uk.ac.rgu.cm2115.devices.Devices;

public class Light extends Devices{

    public Light(String aname) {
        super(aname);
        //T
    }

    public String myLight; 

    public void swichOn(){
        System.out.print(getName() + " Light" + " Switch On");
    }

    public void swichOff(){
        System.out.print(getName() + " Light" + " Switch Off");
    }

    public void dimUP(){
        System.out.print(getName() + " Dim On");
    }

    public void dimDown(){
        System.out.print(getName() + " Dim Off");
    }

}
