package Homework3.service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Homework3.Exceptions.DateFormatException;
import Homework3.Exceptions.GenderFormatException;
import Homework3.Exceptions.NameFormatException;
import Homework3.model.UserFile;

public class UserFileService {

    public UserFile createUserFile(String firstName, String middleName, String lastName, String birthDay, long phoneNumber, char gender) {
        return new UserFile(firstName, middleName, lastName, birthDay, phoneNumber, gender);
    }

    public int checkingNumberOfFields(String[] fields) {
        if (fields.length > 6) {
            return -1;
        } else if (fields.length < 6) {
            return -2;
        }
        else {
            return 1;
        }
    }

    public void parseData(String[] data) throws NameFormatException {
        // проверка полей "имя" "фамилия" "отчество" 

        
        for (int i = 0; i < data[0].length(); i++) {
            if (Character.isDigit(data[0].charAt(i)) == true) {
                throw new NameFormatException("В фамилии присутствуют цифры");
            }
        }

        for (int i = 0; i < data[1].length(); i++) {
            if (Character.isDigit(data[1].charAt(i)) == true) {
                throw new NameFormatException("В имени присутствуют цифры");
            }
        }

        for (int i = 0; i < data[2].length(); i++) {
            if (Character.isDigit(data[2].charAt(i)) == true) {
                throw new NameFormatException("В отчестве присутствуют цифры");
            }
        }

        //проверка поля "дата рождения"
        LocalDate birthDate;

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDate = LocalDate.parse(data[3], format);
        } catch (DateTimeParseException e) {
            throw new DateFormatException("Вы ввели неверный формат даты");
        }

        //проверка поля "номер телефона"
        
        for (int i = 0; i < data[4].length(); i++) {
            if (Character.isDigit(data[4].charAt(i)) != true) {
                throw new NumberFormatException("В номере телефона не может быть букв или других символов");
            }
        }
        long phoneNumber = Long.parseLong(data[4]);
        if (data[4].length() != 11) {
            throw new NumberFormatException("В номере телефона должно быть 11 цифр");
        }
        else if (((int)(phoneNumber / Math.pow(10, 10))) != 8) {
            throw new NumberFormatException("Номер должен начинаться с 8");
        }

        // проверка поля "пол"
        if(data[5].length() != 1) {
            throw new GenderFormatException("Поле должно содержать 1 символ 'M' или 'F'");
        } else if (data[5].charAt(0) != 'M' && data[5].charAt(0) != 'm' && data[5].charAt(0) != 'F' && data[5].charAt(0) != 'f') {
            throw new GenderFormatException("Указан неверный символ: допускается 'M' или 'F'");
        }
    }
    
    public void createFileWithUserData(UserFile userFile) {
        String fileName = userFile.getLastName() + ".txt";
        Path path = Paths.get(fileName);

        if(Files.exists(path) == false) {
            try(FileWriter writer = new FileWriter(fileName)) {
                writer.append("<" + userFile.getLastName() + ">");
                writer.append("<" + userFile.getFirstName() + ">");
                writer.append("<" + userFile.getMiddleName() + ">");
                writer.append("<" + userFile.getbirthDay() + ">");
                writer.append("<" + userFile.getPhoneNumber() + ">");
                writer.append("<" + userFile.getGender() + ">\n");
                System.out.println("Файл создан! Данные корректно записаны в новый файл.");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
                e.printStackTrace();
            }
        } else {
            try(FileWriter writer = new FileWriter(fileName, true)) {
                writer.append("<" + userFile.getLastName() + ">");
                writer.append("<" + userFile.getFirstName() + ">");
                writer.append("<" + userFile.getMiddleName() + ">");
                writer.append("<" + userFile.getbirthDay() + ">");
                writer.append("<" + userFile.getPhoneNumber() + ">");
                writer.append("<" + userFile.getGender() + ">\n");
                System.out.println("Данные успешно записаны в существующий файл.");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
                e.printStackTrace();
            }
        }
    }
}
