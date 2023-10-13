package Exceptions;

public class Bad_Names extends Exception {

    String inputString;

    public Bad_Names(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Не верный формат ввода ФИО '" + inputString + "'. ФИО может состоять только из букв.\n";
    }
}