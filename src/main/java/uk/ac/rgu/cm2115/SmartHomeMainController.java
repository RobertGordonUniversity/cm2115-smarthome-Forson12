package uk.ac.rgu.cm2115;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import uk.ac.rgu.cm2115.devices.Devices.DeviceComparator;

public class SmartHomeMainController extends Controller<Home>{

    @FXML
    private ListView <Devices> lstDevices;

    @FXML
    private Label lblStatus;
    @FXML
    private HBox hboxCommands; 
    @FXML 
    private Button btnCreateRoutine; 

    //setModel(); 
    @FXML
    public void setModel(Home model){
        this.model = model; 
        this.lstDevices.getItems().addAll(model.getDevices());

        Map<String, Command> commands = model.getCommands();
        commands.forEach((name, command) -> { 
            //System.out.println("Processing");
            Button b = new Button(name); 
            b.setOnAction((e) -> command.execute());
            this.hboxCommands.getChildren().add(b); 
        }); 

        
        /*Before LAb 7 */
        // Devices[] devices = model.getDevices();
        // for(int i=0;i<devices.length;i++){
        //     if(devices[i] != null){
        //         this.lstDevices.getItems().add(devices[i]);
        //     }
        // }
        // This code gets the command names and corresponding commands from the model (Home object), then
        // creates JavaFX buttons that correspond to each command. Each button is assigned an event handler
        // (the setOnAction method) in the form of a lambda expression which executes the command.
        
        // String[] commandNames = this.model.getCommandNames(); 
        // Command[] commands = this.model.getCommands();

        // for(int i =0; i< commandNames.length; i++){
        //     if(commandNames[i] == null){
        //         continue; 
        //     }
        //     Command command = commands[i]; 
        //     Button commandButton = new Button(commandNames[i]); 

        //     commandButton.setOnAction((event) ->{
        //         command.execute();
        //         // Devices newDevices = this.lstDevices.getSelectionModel().getSelectedItem();
        //         // this.lblStatus.setText(newDevices.getStatus().toString());
        //     });
        //     this.hboxCommands.getChildren().add(commandButton); 
        // }
        
        
    }

    @FXML
    private void deviceSelected(){
        Devices newDevices = this.lstDevices.getSelectionModel().getSelectedItem();
        //System.out.println(newDevices);
        this.lblStatus.setText(newDevices.getStatus().toString());
        System.out.println(this.lblStatus);
    }

    @FXML 
    private void btnCreateRoutineClick() throws IOException{
        MainApp.setScene("SmartHomeRoutine", this.model);
    } 

    @FXML 
    private void btnSortDevicesClick() {
        List<Devices<DeviceComparator>> sDevices = this.model.getDevices();
        Collections.sort(sDevices); 
        this.lstDevices.getItems().clear(); 
        this.lstDevices.getItems().addAll(sDevices); 
    }


}


    
// }
