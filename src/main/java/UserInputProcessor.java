import java.util.Scanner;

public class UserInputProcessor {
    public String[] UserInputHandler() {
        String header = "Please input correct data in one line,separate it with SPACE...\n" +
                "Lastname Name Patronymic DateOfBirth(dd.mm.yyyy) Phone Gender(m or f)\n" +
                "For Example:\n" +
                "Smith John McGregor 29.05.1950 89997775511 m\n";
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println(header);

        while (!isValidString(input = sc.nextLine())) {
            System.out.println(header);
        }
        return input.trim().split(" ");
    }

    private boolean isValidString(String input) {
        if (input.isEmpty()) {
            System.out.println("Please type something next time...");
            return false;
        }
        if (input.trim().split(" ").length != 6) {
            System.out.println("You entered data in wrong format, please refer to example");
            return false;
        }
        return true;
    }
}
