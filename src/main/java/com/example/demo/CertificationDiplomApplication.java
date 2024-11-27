package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class CertificationDiplomApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		File dir = new File("C:/Users/user/Desktop/demo/share");
		boolean created = dir.mkdir();
		if(created)
			System.out.println("Folder has been created");

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Создать файл");
			System.out.println("2. Добавить файл");
			System.out.println("3. Отправить файл");
			System.out.println("4. Выход");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					FTP_connect.create_file();
					break;
				case 2:
					FTP_connect.add_file();
					break;
                case 3:
					FTP_connect.push_file();
					break;
				case 4:
					System.out.println("Exiting...");
					scanner.close();
					return;

				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
	}
}

