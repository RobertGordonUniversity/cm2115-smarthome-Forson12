package uk.ac.rgu.cm2115.commands;

public class RoutineCommand implements Command{
    private Command[] commands = new Command[10]; 

    public RoutineCommand(Command[] commands) {
        this.commands = commands;
    }


    @Override 
    public void execute() {
        // TODO Auto-generated method stub
        //Command command = new Command(); 

        for(int i =0; i <this.commands.length; i++){
            commands[i].execute(); 
        }
        
    }
    
}
