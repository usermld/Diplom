package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class CertificationDiplomApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		File dir = new File("C:/Users/user/Desktop/demo/files");
//		boolean created = dir.mkdir();
//		if(created)
//			System.out.println("Folder has been created");

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
					create_file();
					break;
				case 2:
					add_file();
					break;
//				case 3:
//					change_file();
//					break;
				case 3:
					FTPClient client = new FTPClient();
					File f = new File("C:/Users/user/Desktop/key.txt");
					FileInputStream fis = null;//new FileInputStream(f);

					try {
						client.connect("185.180.223.189");
						client.login("ftpuser", "1234");
						System.out.println("connect");

						//
						// Create an InputStream of the file to be uploaded
						//

						//String filename = "key.txt";
						//File filename = new File("C:/Users/user/Desktop/key.txt");
						String f_name = "key.txt";
						fis = new FileInputStream(f);

						//
						// Store file to server
						//
						client.storeFile(f_name, fis);
						client.logout();
						System.out.println("filenaem succes");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (fis != null) {
								fis.close();
							}
							client.disconnect();
							System.out.println("disconect");
							} catch (IOException e) {
							e.printStackTrace();
						}
					}
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


	public static void push_file() {

	}

    public static void add_file() {
        System.out.println("Введите путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        String f_path = scanner.nextLine();
        File add_f = new File(f_path);

        if(add_f.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");

        add_f.renameTo(new File("C://Users//user//Desktop//Diplom//" + add_f.getName()));
    }

    public static void create_file() {
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        File f_name = new File("C://Users//user//Desktop//Diplom//" + name);

        try
        {
            boolean created = f_name.createNewFile();
            if(created)
                System.out.println("Файл создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

//public static void change_file() {
//	System.out.println("Введите имя изменяемого файла: ");
//	Scanner scanner = new Scanner(System.in);
//	String c_file = scanner.nextLine();
//	try(FileReader reader = new FileReader(c_file))
//	{
//		// читаем посимвольно
//		int c;
//		while((c=reader.read())!=-1){
//
//			System.out.print((char)c);
//		}
//	}
//	catch(IOException ex){
//
//		System.out.println(ex.getMessage());
//	}
//
//	try(FileWriter writer = new FileWriter(c_file, true))
//	{
//		// запись всей строки
//		System.out.println();
//		System.out.println("Введите текст: ");
//		String text = scanner.nextLine();
//		writer.write("\n" + text);
//		// запись по символам
////                        writer.append('\n');
////                        writer.append('E');
//
//		writer.flush();
//	}
//	catch(IOException ex){
//
//		System.out.println(ex.getMessage());
//	}
//}


