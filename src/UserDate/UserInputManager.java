package UserDate;

import java.util.InputMismatchException;
import java.util.Scanner;

class UserInputManager {

    private static final String FILE_EXTENSION = ".txt";

    private UserDataReader reader;
    private UserDataWriter writer;

    public UserInputManager() {
        reader = new UserDataReader();
        writer = new UserDataWriter();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            while (choice != 3) {
                displayMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        enterUserData();
                        break;
                    case 2:
                        readUserData();
                        break;
                    case 3:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод.");

        }
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Ввести данные пользователя");
        System.out.println("2. Прочитать сохраненные данные");
        System.out.println("3. Выход");
        System.out.print("Введите номер нужного пункта: ");
    }

    private void enterUserData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные пользователя в формате:");
        System.out.println("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
        System.out.print(">> ");

        String userData = scanner.nextLine();
        reader.readUserData(userData);
    }

    private void readUserData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию пользователя:");
        System.out.print(">> ");

        String lastName = scanner.nextLine();
        writer.readUserDataFromFile(lastName + FILE_EXTENSION);
    }
}