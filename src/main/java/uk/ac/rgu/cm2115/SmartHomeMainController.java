package uk.ac.rgu.cm2115;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import uk.ac.rgu.cm2115.commands.Command;
import uk.ac.rgu.cm2115.devices.Controller;
import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
//import uk.ac.rgu.cm2115.devices.LightStatus;

public class SmartHomeMainController extends Controller<Home>{

    @FXML
    private ListView <Devices> lstDevices;

    @FXML
    private Label lblStatus;
    @FXML
    private HBox hboxCommands; 

    //setModel(); 
    @FXML
    public void setModel(Home model){
        this.model = model; 
        Devices[] devices = model.getDevices();
        for(int i=0;i<devices.length;i++){
            if(devices[i] != null){
                this.lstDevices.getItems().add(devices[i]);
            }
        }

        // This code gets the command names and corresponding commands from the model (Home object), then
        // creates JavaFX buttons that correspond to each command. Each button is assigned an event handler
        // (the setOnAction method) in the form of a lambda expression which executes the command.
        
        String[] commandNames = this.model.getCommandNames(); 
        Command[] commands = this.model.getCommands();

        for(int i =0; i< commandNames.length; i++){
            if(commandNames[i] == null){
                continue; 
            }
            Command command = commands[i]; 
            Button commandButton = new Button(commandNames[i]); 

            commandButton.setOnAction((e) ->{
                command.execute();
            });
            this.hboxCommands.getChildren().add(commandButton); 
        }
        
        
    }

    @FXML
    private void deviceSelected(){
        Devices newDevices = this.lstDevices.getSelectionModel().getSelectedItem();
        this.lblStatus.setText(newDevices.getStatus().toString());
    }


}

//public class SmartHomeMainController extends Controller<Home>{
    

//     this.model = model; 
//     Devices[] devices = model.getDevices();
//     for(int i=0;i<devices.length;i++){
//         if(devices[i] != null){
//             this.lstDevices.getItems().add(devices[i]);
//         }
//         }


    
// }
