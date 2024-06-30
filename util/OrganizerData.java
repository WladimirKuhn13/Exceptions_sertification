package Homework3.util;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizerData {

    public String[] getOrderedData(String[] data) {

        String[] result = new String[data.length];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Необходимо упорядочить введенные данные.\nВведите цифру, напротив которой, указана фамилия: ");
        showData(data);
        int lastName = scanner.nextInt();
        result[0] = data[lastName];

        System.out.println("Введите цифру, напротив которой, указано имя: ");
        showData(data);
        int indexFirstName = scanner.nextInt();
        result[1] = data[indexFirstName];

        System.out.println("Введите цифру, напротив которой, указано отчество: ");
        showData(data);
        int indexMiddleName = scanner.nextInt();
        result[2] = data[indexMiddleName];

        System.out.println("Введите цифру, напротив которой, указана дата рождения: ");
        showData(data);
        int indexBirthDate = scanner.nextInt();
        result[3] = data[indexBirthDate];

        System.out.println("Введите цифру, напротив которой, указан номер телефона: ");
        showData(data);
        int indexPhoneNumber = scanner.nextInt();
        result[4] = data[indexPhoneNumber];

        System.out.println("Введите цифру, напротив которой, указан пол: ");
        showData(data);
        int indexGender = scanner.nextInt();
        result[5] = data[indexGender];
        
        return result;
    }

    public void showData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + "." +  " " + data[i]);
        }
    }
}
