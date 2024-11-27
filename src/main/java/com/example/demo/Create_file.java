package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create_file{
    public static ArrayList<File> create(ArrayList<File> f) {
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Добавьте в него текст или нажмите enter для пропуска");
        String text = scanner.nextLine();
        File f_name = new File("C:/Users/user/Desktop/demo/share/" + name);
        f.add(f_name);

        try {
            boolean created = f_name.createNewFile();
            if (created)
                System.out.println("Файл создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter(name, true))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return f;
    }

}
