package uk.ac.rgu.cm2115.devices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeviceLogger {
    private String fileName;

    // Files from Lab 8 
    public DeviceLogger(String myfile) throws IOException{
        this.fileName = myfile;
        File fileName = new File("myfile.txt");

        if(fileName.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        
    } 
    
    public void log(String input){
        try(FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw)){
            fw.append(input); 
            //bw.write("This is a message \n");
            // bw.write("this is another message \n");
            bw.close();
            fw.close();
        }catch(IOException ex){
            System.out.println("An error occurred:" + ex.getMessage());
        }

    }

    public void readLog(){
        try(FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)){

            String line = br.readLine(); 

            while(line != null){
                System.out.println(line);
                line = br.readLine(); 
            }
        }catch(IOException ex){
            System.out.println("An error occurred:" + ex.getMessage());
        }

    }
    
}
