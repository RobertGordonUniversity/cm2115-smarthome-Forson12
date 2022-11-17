package uk.ac.rgu.cm2115.devices;

//import javafx.scene.paint.Color;

public abstract class Light extends Devices<LightStatus> implements Switchable, Dimmable{

    // public Light(String aname) {
    //     super(aname);
    //     //T
    // }

    public String myLight; 
    public Color Color; 
    //public LightStatus status; 

    
    //Color constructor 
    public Light(String aname /*int r, int g, int b*/ ) {
        super(aname);
        //this.Color = new  Color(r, g, b);
        this.Status = LightStatus.ON; 
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
        System.out.print(getName() + " Light " + " is Switch On, " + " Status: " + LightStatus.ON + " ");
    }

    @Override
    public void switchOff(){
        System.out.print(getName() + " Light " + " Switch Off" + " Status: " + LightStatus.OFF + " ");
    }

    @Override
    public void dimUp(){
        System.out.print(getName() + " Dim On " + " Status: " + LightStatus.DIMMED + " ");
    }

    @Override
    public void dimDown(){
        System.out.print(getName() + " Dim Off " + " Status: " + LightStatus.DIMMED + " ");
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





    

    



    
}


