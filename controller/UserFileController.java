package Homework3.controller;

import Homework3.model.UserFile;
import Homework3.service.UserFileService;



public class UserFileController {

    // UserFileServiceCopy service = new UserFileServiceCopy();
    UserFileService service = new UserFileService();

    public UserFile createUserFile(String firstName, String middleName, String lastName, String birthDay, long phoneNumber, char gender) {
        return service.createUserFile(firstName, middleName, lastName, birthDay, phoneNumber, gender);
    }

    public int checkingNumberOfFields(String[] fields) {
        return service.checkingNumberOfFields(fields);
    }

    public void parseData(String[] data) {
        service.parseData(data);
    }

    public void createFileWithUserData(UserFile userFile) {
        service.createFileWithUserData(userFile);
    }
}
