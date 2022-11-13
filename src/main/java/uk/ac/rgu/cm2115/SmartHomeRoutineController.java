package uk.ac.rgu.cm2115;

import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import uk.ac.rgu.cm2115.commands.Command;
import uk.ac.rgu.cm2115.devices.Controller; 

public class SmartHomeRoutineController extends Controller<Home>{
    @FXML
    private ListView <String> lstCommands; 

    @FXML 
    private ListView <String> lstRoutine;
    
    @FXML
    private TextField txtRoutineName; 


    @FXML
    public void setModel(Home model){
        this.model = model; 

        // Devices[] devices = model.getDevices();
        // for(int i=0;i<devices.length;i++){
        //     if(devices[i] != null){
        //         this.lstCommands.getItems(); //.addAll(devices[i]);
        //         this.lstRoutine.getItems();

        //     }
        // }

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

            this.lstCommands.getItems().addAll(commandNames); 
            
            //this.hboxCommands.getChildren().add(commandButton); 
        }  
        
    }


    @FXML 
    private void btnAddToRoutineClick() {
        //MainApp.setScene("SmartHomeRoutine", this.model);
        String selectString = this.lstCommands.getSelectionModel().getSelectedItem();
        this.lstRoutine.getItems().add(selectString); 
    }

    @FXML
    private void btnRemoveFromRoutineClick(){
        String removeString = this.lstRoutine.getSelectionModel().getSelectedItem();
        this.lstRoutine.getItems().remove(removeString); 

    }

    @FXML
    private void btnSaveRoutineClick(){
        String textEntered = txtRoutineName.getText().toString();
        //textEntered += txtRoutineName;
        System.out.println(textEntered);
        
    }

}
