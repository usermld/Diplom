package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.Scanner;
import java.util.*;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class CertificationDiplomApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		File dir = new File("C:/Users/user/Desktop/demo/files");
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
					create_file();
					break;
				case 2:
					add_file();
					break;
                case 3:
					push_file();
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
		FTPClient con = null;
		try
		{
			con = new FTPClient();
			con.connect("185.180.223.189");
			System.out.println("connect");
			if (con.login("ftpuser", "1111"))
			{
				System.out.println("succes");
				con.enterLocalPassiveMode(); // important!
				con.setFileType(FTP.BINARY_FILE_TYPE);
				String data = "C:/Users/user/Desktop/test_2.txt";
				FileInputStream in = new FileInputStream(new File(data));
				boolean result = con.storeFile("/test_2.txt",in);
				in.close();
//							if (result) Log.v("upload result", "succeeded");
			}
			con.logout();
			con.disconnect();
			System.out.println("disconect");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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

        add_f.renameTo(new File("C:/Users/user/Desktop/demo/files" + add_f.getName()));
    }

    public static void create_file() {
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        File f_name = new File("C:/Users/user/Desktop/demo/files" + name);

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

