package uk.ac.rgu.cm2115.devices;

public abstract class Controller<T> {
    
    protected T model; 

    public abstract void setModel (T model);
    
}
