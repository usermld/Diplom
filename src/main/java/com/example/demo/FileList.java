package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileList {

    public static ArrayList to_list(ArrayList<File> f_list, File f){
        f_list.add(f);
        return f_list;
    }
    public static void show_files(ArrayList<File> f_list) {
        for (File f : f_list) {
            System.out.println("Имя файла: " + f.getName() + ", путь к этому файлу: " + f);

        }
    }
}
