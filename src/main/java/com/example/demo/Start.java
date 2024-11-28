package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Start {
    public static void go_2() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Просмотр текущих параметров подключения");
            System.out.println("2. Изменение параметров подключения");
            System.out.println("3. Вернуться в основное меню");

            int choice_2 = scanner.nextInt();
            scanner.nextLine();

            switch (choice_2) {
                case 1:
                    System.out.println("ip-адрес текущего подключения: " + FTP_connect.getIp());
                    System.out.println("Имя пользователя текущего подключения: " + FTP_connect.getUser());
                    System.out.println(("Пароль пользователя текущего подключения: ") + FTP_connect.getPsw());
                    break;
                case 2:
                    System.out.println("Введите новый ip-адрес");

                    String new_ip = scanner.nextLine();
                    if (new_ip == "") System.out.println("ip адрес не изменён");
                    else FTP_connect.setIp(new_ip);

                    System.out.println("Введите имя нового пользователя");

                    String new_user = scanner.nextLine();
                    if (new_user == "") System.out.println("Пользователь не изменён");
                    else FTP_connect.setUser(new_user);

                    System.out.println("Введите пароль нового пользователя");

                    String new_psw = scanner.nextLine();
                    if (new_psw == "") System.out.println("Пароль не изменён");
                    else FTP_connect.setPsw(new_psw);

                    System.out.println("Изменения сохранены");
                    break;
                case 3:
                    return;
            }
        }
    }


    public static void go() {
        Scanner scanner = new Scanner(System.in);

        File dir = new File("C:/Users/user/Desktop/demo/share");
        boolean created = dir.mkdir();
        if (created)
            System.out.println("Папка share создана");

        ArrayList<File> file_list = new ArrayList<File>(Arrays.asList(dir.listFiles()));

        while (true) {
            System.out.println("\nИнструкция пользования: \nДля выбора необходимой функции введите номер этой функции в консоль");
            System.out.println("\nMenu:");
            System.out.println("1. Создать файл");
            System.out.println("2. Добавить файл");
            System.out.println("3. Отправить файл");
            System.out.println("4. Просмотр всех добавленных файлов");
            System.out.println("5. Просмотр параметров подключения по FTP протоколу");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Create_file.create(file_list);
                    break;
                case 2:
                    Add_file.add(file_list);
                    break;
                case 3:
                    FTP_connect.push_file();
                    break;
                case 4:
                    FileList.show_files(file_list);
                    break;
                case 5:
                    Start.go_2();
                    break;
                case 6:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Такой функции нет. Попробуйте ещё раз");
            }
        }
    }
}



