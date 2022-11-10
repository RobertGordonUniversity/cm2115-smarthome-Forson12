package uk.ac.rgu.cm2115.devices;

public enum TurnStatus {
     
    ON("TURN-ON"),
    OFF("TURN-OFF"); 
    
    public final  String label; 

    TurnStatus (String label){
        this.label = label; 

    }
}
