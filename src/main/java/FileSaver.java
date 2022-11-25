import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileSaver {

    public void saveToCsv(People people) {
        String filename = people.getLastName();
        String filePath = "src/main/resources/" + filename + ".csv";
        String text = people.toCsv();
        String header = String.format("<%s>,<%s>,<%s>,<%s>,<%s>,<%s>\n",
                "Lastname", "Name", "Patronymic", "Date Of Birth", "Phone Number", "Gender");

        try {
            if (!Files.exists(Path.of(filePath))) {
                Files.write(Paths.get(filePath), header.getBytes(), StandardOpenOption.CREATE_NEW);
            }
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
