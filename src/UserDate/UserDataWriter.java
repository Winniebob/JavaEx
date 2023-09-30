package UserDate;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserDataWriter {
    public void readUserDataFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}