package uk.ac.rgu.cm2115.devices;

import uk.ac.rgu.cm2115.devices.diagnostics.DeviceVisitor;

//import javafx.scene.paint.Color;

public  class Light extends Devices<LightStatus> implements Switchable, Dimmable{

    // public Light(String aname) {
    //     super(aname);
    //     //T
    // }

    public String myLight; 
    public Color Color; 
    //public LightStatus status; 

    
    //Color constructor 
    public Light(String aname) {
        super(aname);
        //this.Color = new  Color(r, g, b);
        this.Status = LightStatus.OFF; 
    }
    
    // Setter Methods
    // public void setMyLight(String myLight) {
    //     this.myLight = myLight;
    // }

    public void setColor(Color color) {
        Color = color;
    }


    // Color getter Method 
    public Color getMyColor() {
        return Color;
    }
    
    
    // Method to accept color parameters 
    public  void acceptMyColors (int red, int green, int blue){
        red = Color.r; 
        green = Color.g;
        blue = Color.b;

        //return Color;

    }


    @Override
    public void switchOn(){
        this.Status = LightStatus.ON;
        //System.out.print(getName() + " Light " + " is Switch On, " + " Status: " + this.getStatus() + " ");
        log(getName() + " Light " + " is Switch On, " + " Status: " + this.getStatus() + " ");
    }

    @Override
    public void switchOff(){
        this.Status = LightStatus.OFF;
        //System.out.print(getName() + " Light " + " Switch Off" + " Status: " +  this.getStatus() + " ");
        log(getName() + " Light " + " Switch Off" + " Status: " +  this.getStatus() + " ");
    }

    @Override
    public void dimUp(){
        this.Status = LightStatus.DIMMED;
        //System.out.print(getName() + " Dim On " + " Status: " + this.getStatus()  + " ");
        log(getName() + " Dim On " + " Status: " + this.getStatus()  + " ");
    }

    @Override
    public void dimDown(){
        this.Status = LightStatus.DIMMED;
        //System.out.print(getName() + " Dim Off " + " Status: " + this.getStatus()+ " ");
        log(getName() + " Dim Off " + " Status: " + this.getStatus()+ " ");
    }

        
   // Color inner class 

    public class Color{
         public int r;
         public int g;
         public int b;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }


        @Override
        public String toString() {
            return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
        
    }


    @Override
    public final void accept(DeviceVisitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
        
    }





    

    



    
}


