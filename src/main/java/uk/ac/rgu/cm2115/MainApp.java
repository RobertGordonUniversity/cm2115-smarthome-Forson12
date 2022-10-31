package uk.ac.rgu.cm2115; 

//import uk.ac.rgu.Light;
//import uk.ac.rgu.SmartApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.effect.Light;
import javafx.stage.Stage;
import uk.ac.rgu.cm2115.devices.Controller;
import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
import uk.ac.rgu.cm2115.devices.Light;
import uk.ac.rgu.cm2115.devices.SmartPlug;
import uk.ac.rgu.cm2115.devices.Switchable;
import uk.ac.rgu.cm2115.devices.Thermostat;

/**
 * JavaFX App
 */
public class MainApp extends Application {

    public static void main(String[] args) {

        // JavaFX launch code - we'll get to this later
        //launch();

        /* 
        SmartApp s1 = new SmartApp("off");
         System.out.println(s1); 
        */ 

        
            //Light l1 = new Light("down");
            //l1.simpleMessage();
            //System.out.println(l1);
        
        
        // Light L1 = new Light("Living Room"); 
        // L1.swichOn();

        Switchable[] turnOn = new Switchable[2]; 
        turnOn[0] = new Light("Kitchen Light "); 
        turnOn[1] = new SmartPlug("Wifi ");
        //turnOn[1].swichOn();

        

        // Devices[] devices = new Devices[5]; 
        // devices[0] = new Light("Living room");
        // devices[1] = new SmartPlug("Kettle");
        // devices[2] = new Thermostat("Wifi");
        // devices[3] = new Light("Bed room");
        // devices[4] = new SmartPlug("Tv");

        // for (int i =0; i < devices.length; i++){
        //     System.out.println(devices[i]);
        // }

 

    }

    /* Code below is for JavaFX - we'll get to this later in the module! */

    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("SmartHomeMain"), 640, 480);
        stage.setScene(scene);
        stage.show();

        Home home = new Home(); 
        home.addDevice(new Light("Living room"));
        home.addDevice(new SmartPlug("Kettle"));
        home.addDevice(new Thermostat("Whole house"));
        setScene("SmartHomeMain", home);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    
    public static <T> void setScene(String fxml, T model) throws IOException{

        if(fxml.endsWith(".fxml")){
            fxml = fxml.replace(".fxml","");
        }

        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();

        @SuppressWarnings("unchecked")
        Controller<T> controller = (Controller<T>)loader.getController();
        controller.setModel(model);

        scene.setRoot(root);
    }
    

    //Testing SmartApp




}