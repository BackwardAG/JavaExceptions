package Exceptions;

public class Bad_Phone extends Exception {
    String inputString;

    public Bad_Phone(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Не возможно преобразовать " + inputString + " в телефонный номер, (верный формат телефона - 10 цифр без пробелов 9295232342)\n";
    }
}