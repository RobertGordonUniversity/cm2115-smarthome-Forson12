package uk.ac.rgu.cm2115.devices.amazon;

import uk.ac.rgu.cm2115.devices.Light;
import uk.ac.rgu.cm2115.devices.SmartPlug;
import uk.ac.rgu.cm2115.devices.Thermostat;

public interface DeviceFactory {
    public Light geLight(String name); 
    public SmartPlug geSmartPlug(String name); 
    public Thermostat getThermostat(String name); 
    
}
