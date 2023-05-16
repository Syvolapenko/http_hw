package TestClass;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusClient {
    public static final String GET_URL = "https://http.cat/";

    public static void main(String[] args) {
//        Завдання 1
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker(GET_URL);
        System.out.println(httpStatusChecker.getStatusImage(300));
//        Завдання 2 і 3
        askStatus();
    }

    public static void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Please enter valid number");
        }
        int code = scanner.nextInt();
        new HttpStatusImageDownloader().downloadStatusImage(code);
    }
}