import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class People {
    private String lastName;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Gender gender;

    public People(String lastName, String name, String patronymic, LocalDate dateOfBirth, String phoneNumber, Gender gender) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public People() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return  lastName + " " + name + " " + patronymic +
                "\n" + dateOfBirth.format(dtf) +
                "\n" + phoneNumber +
                '\n' + gender;
    }

    public String toCsv() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%s,%s,%s,%s,%s,%s\n",
                lastName, name, patronymic, dateOfBirth.format(dtf), phoneNumber, gender);
    }
}
