package Exceptions;

public class Bad_Gender extends Exception {
    String inputString;

    public Bad_Gender(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Проверьте верность указанного пола (используйте только латинские буквы f или m), а не '" + inputString + "'\n";
    }
}
