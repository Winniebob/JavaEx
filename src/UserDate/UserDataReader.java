package UserDate;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataReader {

    private static final int EXPECTED_DATA_COUNT = 6;

    public void readUserData(String userData) {
        try {
            String[] data = userData.split("\\s+");
            if (data.length != EXPECTED_DATA_COUNT) {
                throw new IllegalArgumentException("Неверное количество данных. Ожидается " + EXPECTED_DATA_COUNT);
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            validateData(lastName, firstName, patronymic, dateOfBirth, phoneNumber, gender);
            writeDataToFile(lastName, firstName, patronymic, dateOfBirth, phoneNumber, gender);
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void validateData(String lastName, String firstName, String patronymic, String dateOfBirth,
                              long phoneNumber, char gender) {
        if (!isValidDate(dateOfBirth)) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.mm.yyyy");
        }

        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Неверное значение пола. Ожидается f или m");
        }
    }

    private boolean isValidDate(String date) {
        String[] parts = date.split("\\.");
        if (parts.length != 3) {
            return false;
        }
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 9999
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void writeDataToFile(String lastName, String firstName, String patronymic, String dateOfBirth,
                                 long phoneNumber, char gender) {
        try (FileWriter writer = new FileWriter(lastName + ".txt", true)) {
            writer.write(lastName + " " + firstName + " " + patronymic + " "
                    + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при сохранении данных: " + e.getMessage());
            e.printStackTrace();
        }
    }
}