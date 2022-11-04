package uk.ac.rgu.cm2115.devices;

public enum LightStatus {
    
    ON("SwitchON"),
    OFF("SwitchOFF"), 
    DIMMED("DimmedUp/Down");

    public final  String label; 

    LightStatus (String label){
        this.label = label; 

    }



    
}
