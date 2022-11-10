package uk.ac.rgu.cm2115.devices;

import uk.ac.rgu.cm2115.commands.Command;

/**
 * Class to act as a hub for the smarthome
 * @author Mark Snaith
 */
public class Home  {
    public Devices[] devices; 

    private String[] commandNames = new String[10]; 
    private Command[] commands = new Command[10]; 
    private int numCommands = 0; 
    

    public Home(){
        devices = new Devices[4]; 

    }
    //Methods 
    public void addDevice(Devices device){
        for(int i=0; i<this.devices.length; i++){
            if(devices[i] == null){
                devices[i] = device; 
                break; 
            }
        }

    }

    //AddCommand Method 
    public void addCommand(String name, Command command){
        if (this.numCommands == 10){
            return;
        }
        commandNames[this.numCommands] = name; 
        commands[this.numCommands] = command; 

        this.numCommands++; 
    }

    // public getCommand method
    public Command getCommand(String name){
        for(int i =0; i <this.commandNames.length; i++){
            if(this.commandNames[i].equalsIgnoreCase(name)){
                return this.commands[i]; 

            }
        }
        return null; 
    }

    // public runCommand
    public void runCommand(String name){
        Command command = this.getCommand(name);

        if(command != null){
            command.execute();
        }
    }



    // getter Method 
    public Devices[] getDevices(){
        return this.devices; 
    }
    public String[] getCommandNames() {
        return commandNames;
    }
    public Command[] getCommands() {
        return commands;
    }
    

}
