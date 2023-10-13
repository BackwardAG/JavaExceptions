package Exceptions;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Presenter< V extends View> {

    private Check_Date model;
    private V view;

    public Presenter(V v) {
        view = v;
    }

    public void start() {
        boolean wokring = true;
        do {
            String input = view.getInput(
                    "Введите данные через пробел (Фамилию Имя Отчество Дату Рождения Номер Телефона  Пол), или Exit для прекращения программы:");
            if (input.equals("Exit")) {
                wokring = false;
                break;
            } else {
                // заменяем множественные пробелы на одинарные 
                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");

                int inputDataCount = checkInputDataCount(splitedInput.length);
                if (inputDataCount == -1) {
                    view.printOutput("Введено слишком мало данных (должно быть " + Check_Date.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else if (inputDataCount == 0) {
                    view.printOutput("Введено слишком много данных (должно быть " + Check_Date.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else {
                    try {
                        model = new Check_Date();
                        model.CheckData(splitedInput);
                        writePersonData(model);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Parsing_DataString e) {
                        view.printOutput(e.getMessage());
                    }
                }
            }
        } while (wokring);
    }

    // проверяем кол-во введённых данных через возврат кода ошибки при несоответствии
    private int checkInputDataCount(int inputDataCount) {
        if (inputDataCount < Check_Date.dataCount) {
            return -1;
        } else if (inputDataCount > Check_Date.dataCount) {
            return 0;
        } else {
            return inputDataCount;
        }
    }
    
    // создаём или подключаемся к фаилу по фамилии и добавляем новые данные
    private void writePersonData(Check_Date data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}