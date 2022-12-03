package uk.ac.rgu.cm2115.devices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import uk.ac.rgu.cm2115.commands.Command;
import uk.ac.rgu.cm2115.commands.CommandNotExistException;
import uk.ac.rgu.cm2115.devices.Devices.DeviceComparator;
import uk.ac.rgu.cm2115.devices.amazon.DeviceFactory;

/**
 * Class to act as a hub for the smarthome
 * @author Mark Snaith
 */
public class Home  {
    public List<Devices<?>> devices = new ArrayList<>(); 

    //private String[] commandNames = new String[10]; 
    //Map<String, Command> commandNames = new HashMap<>();
    //private Command[] commands = new Command[10]; 
    Map<String, Command> commands = new HashMap<>();
    

    //private int numCommands = 0; 

    /*Lab 6B field */
    private DeviceFactory factory; 
    
    /*Constructor */
    // public Home(DeviceFactory factory) {
    //     this.factory = factory;
    // }

    public Home(DeviceFactory factory){
        devices = new ArrayList<>(4); 
        this.factory = factory;

    }

    //addDevice Method 
    public void addDevice(Devices<?> device){
        // for(int i=0; i<this.devices.size(); i++){
        //     if(devices.get(i) == null){
        //         devices.set(i, device); 
        //         break; 
        //     }
        // }
        devices.add(device);

    }

    //AddCommand Method 
    public void addCommand(String name, Command command){
        // if (this.numCommands == 10){
        //     return;
        // }
        //commandNames[this.numCommands] = name;
        //commandNames.get(name); 
        //commands[this.numCommands] = command; 
        commands.put(name.toLowerCase(), command);
        

        // this.numCommands++; 
    }

    // public getCommand method
    public Command getCommand(String name){

        Command command = this.commands.get(name.toLowerCase()); 

        if(command == null){
            throw new CommandNotExistException("Command " + name + " does not exist");
        }else{
            for(int i =0; i <this.commands.size(); i++){
                if(this.commands.get(i).equals(name)){  //equalsIgnoreCase(name)
                    return this.commands.get(i); 
                }
            }
        }
        return command; 
    }

    // public runCommand
    public Command runCommand(String name){
        Command command = this.getCommand(name.toLowerCase());

        // if(command != null){
        //     command.execute();
        // }
        if (command == null){
            throw new CommandNotExistException("Command "+name+" does not exist");
        }else{
            command.execute();
        }

        return command;

        // if(command != null){
        //     try{
        //         command.execute();
        //     }catch(CommandNotExistException ex){
        //         Alert a = new Alert(AlertType.ERROR);
        //         a.setContentText(ex.getMessage());
        //         a.show();
        //     }

        // }

        // return command;

    }



    // getter Method 
    public List<Devices<?>> getDevices(){
        return this.devices; 
    }

    public Set<String> getCommandNames() {
        return commands.keySet(); 
    } 
    
    public Map<String, Command> getCommands() {
        return commands; 
    }


    /*Lab 6 Abstruct Factory methods */
    public Light addLight(String name){
        Light light = this.factory.geLight(name); 
        this.addDevice(light);
        return light; 
    }

    public SmartPlug addSmartPlug(String name){
        SmartPlug plug = this.factory.geSmartPlug(name);
        this.addDevice(plug);
        return plug; 
    }

    public Thermostat addThermostat(String name){
        Thermostat thrm = this.factory.getThermostat(name);
        this.addDevice(thrm);
        return thrm; 
    }

}
