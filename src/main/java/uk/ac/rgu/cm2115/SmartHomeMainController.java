package uk.ac.rgu.cm2115;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import uk.ac.rgu.cm2115.commands.Command;
import uk.ac.rgu.cm2115.commands.CommandNotExistException;
import uk.ac.rgu.cm2115.devices.Controller;
import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
//import uk.ac.rgu.cm2115.devices.LightStatus;
//import uk.ac.rgu.cm2115.devices.Devices.DeviceComparator;

public class SmartHomeMainController extends Controller<Home>{

    @FXML
    private ListView <Devices<?>> lstDevices;

    @FXML
    private Label lblStatus;
    @FXML
    private HBox hboxCommands; 
    @FXML 
    private Button btnCreateRoutine; 
    @FXML 
    private Button btnSortDevicesClick; 
    @FXML
    private Button btnDevicesByType; 
    @FXML
    private TextField txtFilterDevices; 
    @FXML
    private TextField txtCommandName; 

    //setModel(); 
    @FXML
    public void setModel(Home model){
        this.model = model; 
        this.lstDevices.getItems().addAll(model.getDevices());

        Map<String, Command> commands = model.getCommands();
        // commands.forEach((name, command) -> { 
        //     //System.out.println("Processing");
        //     Button b = new Button(name); 
        //     b.setOnAction((e) -> command.execute());
        //     this.hboxCommands.getChildren().add(b); 
        // }); 

        
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
        Devices<?> newDevices = this.lstDevices.getSelectionModel().getSelectedItem();
        //System.out.println(newDevices);
        this.lblStatus.setText(newDevices.getStatus().toString());
        System.out.println(this.lblStatus);
    }

    @FXML 
    private void btnCreateRoutineClick() throws IOException{
        try {
            MainApp.setScene("SmartHomeRoutine", this.model);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Cannot load SmartHomeMain");
            a.show();

        }
    } 
    /*Sort By name */
    @FXML 
    private void btnSortDevicesClick() {
        List<Devices<?>> sDevices = this.model.getDevices();
        Collections.sort(sDevices); 
        this.lstDevices.getItems().clear(); 
        this.lstDevices.getItems().addAll(sDevices); 
    }
    /*Sort By Type */
    @FXML
    public void btnDevicesByType(){
        List<Devices<?>> sDevices = this.model.getDevices();
        sDevices.sort(new Devices.DeviceComparator());
        this.lstDevices.getItems().clear(); 
        this.lstDevices.getItems().addAll(sDevices); 
        //System.out.println(sDevices.toString());

    }
    /*Filtering */
    /*This code gets the text from the filter box, then clears all items from the ListView. If there’s no
    text, we restore the full list; if there is text, we use a stream and lambda expression to filter the
    list based on the entered text */
    @FXML
    public void txtFilterDevicesOnChange(){
        String text = this.txtFilterDevices.getText();
        this.lstDevices.getItems().clear();
        List<Devices<?>> devices = this.model.getDevices();
        if(text == null || text.equals("")){
            this.lstDevices.getItems().addAll(devices);
        }
        else{
            List<Devices<?>> filtered = devices.stream().filter((d) -> {
                String name = d.getName().toLowerCase();
                String search = text.toLowerCase();
                return name.startsWith(search);
            }).collect(Collectors.toList());
        this.lstDevices.getItems().addAll(filtered);
        }
    }
    @FXML
    private void btnRunCommandClick(){
        String text = this.txtCommandName.getText();
        if(text != null){
            try{
                Command command = this.model.getCommand(text);
                command.execute();
            }catch(CommandNotExistException ex){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText(ex.getMessage());
                a.show();
            }
        }

    }


}


    
// }
