package uk.ac.rgu.cm2115; 

//import uk.ac.rgu.Light;
//import uk.ac.rgu.SmartApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
//import javafx.scene.effect.Light;
import javafx.stage.Stage;
import uk.ac.rgu.cm2115.devices.Controller;
import uk.ac.rgu.cm2115.devices.Devices;
import uk.ac.rgu.cm2115.devices.Home;
import uk.ac.rgu.cm2115.devices.Light;
import uk.ac.rgu.cm2115.devices.LightStatus;
import uk.ac.rgu.cm2115.devices.SmartPlug;
import uk.ac.rgu.cm2115.devices.Switchable;
//import uk.ac.rgu.cm2115.devices.Light.Color; 
import uk.ac.rgu.cm2115.devices.Thermostat;
import uk.ac.rgu.cm2115.devices.TurnStatus;
import uk.ac.rgu.cm2115.devices.amazon.AmazonDeviceFactory;
import uk.ac.rgu.cm2115.devices.amazon.DeviceFactory;

/**
 * JavaFX App
 */
public class MainApp extends Application {

    public static void main(String[] args) {

        // JavaFX launch code - we'll get to this later
        launch(); 

        // Switchable kobi = new SmartPlug("Wifi"); 
        // kobi.swichOn();

        /* 
        SmartApp s1 = new SmartApp("off");
         System.out.println(s1); 
        */ 

        
            //Light l1 = new Light("down");
            //l1.simpleMessage();
            //System.out.println(l1);
        
        
        // Light L1 = new Light("Living Room"); 
        // L1.swichOn();

        // Lab 4 Testin 
        // Switchable[] turnOn = new Switchable[2]; 
        // turnOn[0] = new Light("Kitchen Light "); 
        // turnOn[1] = new SmartPlug("Wifi ");
        //turnOn[1].swichOn();


        // Lab 5 Testing 
        // Light light = new Light("Living Room", 255, 0, 0); 
        // System.out.println(light.Color);
        // light.swichOn();
        //light.getMyColor(); 

        //LightStatus Ls =  LightStatus.ON; 
        //System.out.println(Ls.label);
        // SmartPlug S1 = new SmartPlug("Wifi"); 
        // S1.swichOn();
        //  TurnStatus T1 = TurnStatus.ON; 
        // System.out.println(T1.label);

       
        
        //Lab 3 Test and tryout 
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

        /*Lab 6 B Abstract Factory */
        DeviceFactory factory = new AmazonDeviceFactory(); 
        Home home = new Home(factory); 
        
        Light light = home.addLight("Living Room"); 
        SmartPlug plug = home.addSmartPlug("Kettle");
        Thermostat thrm = home.addThermostat("Whole house"); 

        home.addCommand("Switch on Light", light :: switchOn);
        home.addCommand("Switch on Kettle", plug :: switchOn);
        home.addCommand("Switch off Thermostat", thrm :: turnOff);

        /*LAB 6 A */
        // Light light = new Light("Living Room");
        // SmartPlug plug = new SmartPlug("Kettle");
        // Thermostat thrm = new Thermostat("Whole house");

        // home.addDevice(light);
        // home.addDevice(plug);
        // home.addDevice(thrm);

        // home.addCommand("Switch on light", light::switchOn);
        // home.addCommand("Switch on kettle", plug::switchUp);
        // home.addCommand("Turn up thermostat", thrm::turnUp);

        //home.runCommand("Switch on Light");
        
        // for Lab 3 (Add the various devices to listview)
        // home.addDevice(new Light("Living room", 255,0,0));
        // home.addDevice(new SmartPlug("Kettle"));
        // home.addDevice(new Thermostat("Whole house"));

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

}