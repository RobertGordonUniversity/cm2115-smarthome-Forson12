package uk.ac.rgu.cm2115;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
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
