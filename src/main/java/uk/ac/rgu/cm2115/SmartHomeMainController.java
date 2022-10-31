package uk.ac.rgu.cm2115;

import uk.ac.Home;
import uk.ac.rgu.cm2115.devices.Devices;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SmartHomeMainController extends Controller<Home>{

    @FXML
    private ListView<Devices> lstDevices;

    //setModel(); 
    public void setModel(Home model){
        this.model = model; 
        Devices[] devices = model.getDevices();
        for(int i=0;i<devices.length;i++){
            if(devices[i] != null){
                this.lstDevices.getItems().add(devices[i]);
            }
        }
            

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
