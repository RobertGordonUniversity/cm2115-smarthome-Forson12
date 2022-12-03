package uk.ac.rgu.cm2115;

import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
import java.io.IOException;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import uk.ac.rgu.cm2115.commands.Command;
import uk.ac.rgu.cm2115.commands.RoutineCommand;
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
        Map<String, Command> commands = model.getCommands(); 
        commands.forEach((name, command) -> { 
            Button b = new Button(name); 
            b.setOnAction((e) -> command.execute());
            //this.hboxCommands.getChildren().add(b); 
        }); 
        this.lstCommands.getItems().addAll(this.model.getCommandNames()); 
    

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
        
        // String[] commandNames = this.model.getCommandNames(); 
        // Command[] commands = this.model.getCommands();

        // for(int i =0; i< commandNames.length; i++){
        //     if(commandNames[i] != null){ 
        //         continue; 
        //     }
        //     Command command = commands[i]; 
        //     Button commandButton = new Button(commandNames[i]); 

        //     commandButton.setOnAction((event) ->{
        //         command.execute();
        //     });

        //     //this.hboxCommands.getChildren().add(commandButton); 
        // }  
        // this.lstCommands.getItems().addAll(commandNames); 
        
    }


    @FXML 
    private void btnAddToRoutineClick() {
        //MainApp.setScene("SmartHomeRoutine", this.model);
        String selectString = this.lstCommands.getSelectionModel().getSelectedItem();
        this.lstRoutine.getItems().addAll(selectString); 
    }

    @FXML
    private void btnRemoveFromRoutineClick(){
        String removeString = this.lstRoutine.getSelectionModel().getSelectedItem();
        this.lstRoutine.getItems().remove(removeString); 

    }

    @FXML
    private void btnSaveRoutineClick() throws IOException{
        //Get text from text field
        String routineName = txtRoutineName.getText().toString();
        
        //Create Command array
        Command[] commands = new Command[lstRoutine.getItems().size()];
        //Iterate over items in lstRoutine
        // for (String routines : lstRoutine.getItems()) {
        //     commands
        // }

        for(int i =0; i < commands.length; i++){
            commands[i] = model.getCommand(lstRoutine.getItems().get(i)); 
        }

        RoutineCommand routineCommand = new RoutineCommand(commands);
        model.addCommand(routineName, routineCommand);

        try {
            MainApp.setScene("SmartHomeMain", this.model);
        } catch (Exception e) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot load SmartHomeMain");
            a.show();

        }
        

        // String textEntered = txtRoutineName.getText().toString();
        // //textEntered += txtRoutineName;
        // System.out.println(textEntered);
        // //Command Arrays
        // Command[] myCommand = new Command[lstRoutine.getItems().size()];

        // // iterate through items in lstRoutine
        // for(Command command : myCommand){
        //     command.execute();

        // }

        // // for(String routine : lstRoutine.getItems()){
        // //     Home.addCommand(routine, routine);
        // // }

        // for (int i = 0; i < lstRoutine.getItems().size(); i++) {
        //     model.addCommand(textEntered, myCommand[i]);
        // }
        // //Add RoutineCommand
        // RoutineCommand myRoutineCommand = new RoutineCommand(myCommand); 

        // // Add the RoutineCommand object to the model
        
        
    }

    /*Implement a similar filtering system in the SmartHomeRoutine scene. This should filter the list of
    commands that can be added to a routine */
    

}
