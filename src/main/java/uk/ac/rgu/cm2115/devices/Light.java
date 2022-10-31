package uk.ac.rgu.cm2115.devices;

public class Light extends Devices implements Switchable, Dimmable{

    public Light(String aname) {
        super(aname);
        //T
    }

    public String myLight; 


    @Override
    public void swichOn(){
        System.out.print(getName() + " Light" + " Switch On");
    }

    @Override
    public void swichOff(){
        System.out.print(getName() + " Light" + " Switch Off");
    }

    @Override
    public void dimUp(){
        System.out.print(getName() + " Dim On");
    }

    @Override
    public void dimDown(){
        System.out.print(getName() + " Dim Off");
    }

   
    public static class color(){
        

    }

}


