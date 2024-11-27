package com.example.demo;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Add_file {
    public static void add() {
        System.out.println("Введите путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        String f_path = scanner.nextLine();
        File add_f = new File(f_path);

        if (add_f.exists()) {
            add_f.renameTo(new File("C:/Users/user/Desktop/demo/share/" + add_f.getName()));
            System.out.println("Файл найден и скопирован в папку share");
        } else
            System.out.println("Файл не найден");
    }
}
