public class NegativeException  extends Exception{
    public NegativeException(String message){
        super(message);
    }

    public NegativeException(){
        super("Input cannot be negative");
        
    }
}
