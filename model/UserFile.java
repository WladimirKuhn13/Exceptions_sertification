package Homework3.model;

public class UserFile {
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDay;
    private long phoneNumber;
    private char gender;

    public UserFile(String lastName, String firstName, String middleName, String birthDay, long phoneNumber, char gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public UserFile() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getbirthDay() {
        return birthDay;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}
