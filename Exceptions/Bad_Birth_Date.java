package Exceptions;

public class Bad_Birth_Date extends Exception {
    
    String inputString;

    public Bad_Birth_Date(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе даты '" + inputString + "', требуемый формат ввода 'дд.мм.гггг'.\n";
    }
}