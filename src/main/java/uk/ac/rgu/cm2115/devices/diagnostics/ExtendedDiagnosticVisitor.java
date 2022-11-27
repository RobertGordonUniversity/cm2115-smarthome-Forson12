package uk.ac.rgu.cm2115.devices.diagnostics;

import uk.ac.rgu.cm2115.devices.Light;
import uk.ac.rgu.cm2115.devices.SmartPlug;
import uk.ac.rgu.cm2115.devices.Thermostat;

public class ExtendedDiagnosticVisitor implements DeviceVisitor{

    @Override
    public void visit(Light light) {
        // TODO Auto-generated method stub
        System.out.println("Performing an extended diagnostic on " + light.toString());
        
    }

    @Override
    public void visit(SmartPlug plug) {
        // TODO Auto-generated method stub
        System.out.println("Performing an extended diagnostic on " + plug.toString());
        
    }

    @Override
    public void visit(Thermostat thrm) {
        System.out.println("Performing an extended diagnostic on " + thrm.toString());
        
    }

}
