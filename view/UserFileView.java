package Homework3.view;

import java.util.Scanner;
import Homework3.controller.UserFileController;
import Homework3.model.UserFile;
import Homework3.util.OrganizerData;

public class UserFileView {
    
    public void start() {

        UserFileController controller = new UserFileController();
        OrganizerData organizer = new OrganizerData();

        System.out.println("Введите данные о пользователе: ");
        Scanner scanner = new Scanner(System.in);
        String fields = scanner.nextLine();

        String[] data = fields.split(" ");

        if (controller.checkingNumberOfFields(data) == -1) {
            System.out.println("Вы ввели больше 6 полей! Выполните ввод снова.");
            start();
            System.exit(0);
        } else if (controller.checkingNumberOfFields(data) == -2) {
            System.out.println("Вы ввели меньше 6 полей! Выполните ввод снова.");
            start();
            System.exit(0);
        } else if (controller.checkingNumberOfFields(data) == 1) {
            System.out.println("Отлично! Вы ввели необходимое количество полей.");
        }

        String[] orderedData = organizer.getOrderedData(data);

        System.out.println("Данные упорядоченны.");

        controller.parseData(orderedData);

        System.out.println("Форматы данных корректны.");

        UserFile file = controller.createUserFile(orderedData[0], orderedData[1], orderedData[2], orderedData[3], Long.parseLong(orderedData[4]), orderedData[5].charAt(0));

        controller.createFileWithUserData(file);
    }
}
