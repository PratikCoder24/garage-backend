package Garage_System.exception;

public class InvalidJobCardStateException extends RuntimeException{
    public InvalidJobCardStateException(String message){
        super(message);
    }
}
