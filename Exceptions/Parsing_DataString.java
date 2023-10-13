package Exceptions;

public class Parsing_DataString extends Exception {
    String message;

    public Parsing_DataString(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}