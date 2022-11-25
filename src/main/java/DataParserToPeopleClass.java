import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataParserToPeopleClass {

    String GENDER_PARSE = "Gender format is incorrect," +
            " use f for Female and m for Male. " +
            "GOD CREATE ONLY TWO GENDERS, check Bible";

    public People parseToClass(String[] data) {

        String lastname = capitalizeWord(data[0]);
        String name = capitalizeWord(data[1]);
        String patronymic = capitalizeWord(data[2]);
        String date = data[3];
        String phonenumber = data[4];
        String gender = data[5];

        People people = new People();
        people.setLastName(lastname);
        people.setName(name);
        people.setPatronymic(patronymic);
        people.setDateOfBirth(parseDate(date));
        people.setPhoneNumber(parsePhoneNumber(phonenumber));
        people.setGender(parseGender(gender));
        return people;
    }

    private String capitalizeWord (String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    private LocalDate parseDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate time = null;
        try {
            time = LocalDate.parse(date, dtf);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    private String parsePhoneNumber (String phonenumber) {
        if (phonenumber.length() < 10 || phonenumber.length() > 11) {
            return phonenumber;
        }
        if (phonenumber.length() == 11) {
            phonenumber = phonenumber.substring(1);
        }

        String phoneMask= "###-###-##-##";

        MaskFormatter maskFormatter= null;
        try {
            maskFormatter = new MaskFormatter(phoneMask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            phonenumber = maskFormatter.valueToString(phonenumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "+7-" + phonenumber;
    }

    private Gender parseGender(String genderType) {
        Gender gender = null;
        try {
            if (genderType.length() == 1) {
                if (genderType.equalsIgnoreCase("m")) {
                    gender = Gender.MALE;
                } else if (genderType.equalsIgnoreCase("f")) {
                    gender = Gender.FEMALE;
                } else throw new ParseException(GENDER_PARSE, 0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return gender;
    }
}
