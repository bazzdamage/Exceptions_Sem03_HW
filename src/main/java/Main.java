public class Main {
    public static void main(String[] args) {

        System.out.println("Program by bazzdamage is starting...");

        UserInputProcessor uip = new UserInputProcessor();
        var res = uip.UserInputHandler();
        DataParserToPeopleClass dp = new DataParserToPeopleClass();

        var print = dp.parseToClass(res);
        System.out.println(print);

        FileSaver fs = new FileSaver();
        fs.saveToCsv(print);
    }
}
